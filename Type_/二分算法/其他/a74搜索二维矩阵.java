package Type_.二分算法.其他;

/**
 * @Author: ZJX
 * @Date: 2025/01/12
 * @Description:
 */
public class a74搜索二维矩阵 {
    /**
     * 当做二叉查找树数来做 - 排除法
     */
    class S1 {
        class Solution {
            public boolean searchMatrix(int[][] matrix, int target) {
                int m = matrix.length, n = matrix[0].length;
                int currRow = 0, currCol = n - 1;
                while (currRow < m && currCol >= 0) {
                    int currVal = matrix[currRow][currCol];
                    if (currVal == target) return true;
                    else if (currVal > target) currCol--;
                    else currRow++;
                }
                return false;
            }
        }
    }


    /**
     * 方法二的优化 - 将每一行拼在一起,用下标映射来做
     */
    class S3 {
        class Solution {
            public boolean searchMatrix(int[][] matrix, int target) {
                int m = matrix.length, n = matrix[0].length;
                int lo = 0, hi = m * n;
                while (lo < hi) {
                    int mid = ((hi - lo) >> 1) + lo;
                    int row = mid / n, col = mid % n;
                    if (matrix[row][col] == target)
                        return true;
                    else if (matrix[row][col] > target)
                        hi = mid;
                    else
                        lo = mid + 1;
                }
                return false;
            }

        }
    }

    /**
     * 对一行进行二分
     */
    class S2 {
        class Solution {
            int t;

            public boolean searchMatrix(int[][] matrix, int target) {
                this.t = target;
                int m = matrix.length, n = matrix[0].length;
                for (int[] nums : matrix) {
                    if (binarySearch(nums, 0, n)) return true;
                }
                return false;
            }

            private boolean binarySearch(int[] nums, int lo, int hi) {
                while (lo < hi) {
                    int mid = ((hi - lo) >> 1) + lo;
                    if (nums[mid] == t) return true;
                    else if (nums[mid] > t) hi = mid;
                    else lo = mid + 1;
                }
                return false;
            }
        }
    }
}
