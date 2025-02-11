package 面试必刷;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a240搜索二维矩阵II {
    class S1 {
        class Solution {
            public boolean searchMatrix(int[][] matrix, int target) {
                int m = matrix.length, n = matrix[0].length;
                int i = 0, j = n - 1;
                while (i < m && j >= 0) {
                    int curr = matrix[i][j];
                    if (curr > target) {
                        j--;
                    } else if (curr < target) {
                        i++;
                    } else
                        return true;
                }

                return false;
            }
        }
    }

    class S2 {
        class Solution {
            public boolean searchMatrix(int[][] matrix, int target) {
                int m = matrix.length, n = matrix[0].length;
                for (int i = 0; i < m; i++) {
                    int lo = 0, hi = n;
                    while (lo < hi) {
                        int mid = ((hi - lo) >> 1) + lo;
                        if (matrix[i][mid] >= target)
                            hi = mid;
                        else
                            lo = mid + 1;
                    }
                    if (lo < n && matrix[i][lo] == target)
                        return true;
                }
                return false;
            }
        }
    }
}
