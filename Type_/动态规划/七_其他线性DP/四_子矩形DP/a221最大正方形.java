package Type_.动态规划.七_其他线性DP.四_子矩形DP;

/**
 * @Author: ZJX
 * @Date: 2025/01/22
 * @Description:
 */
public class a221最大正方形 {
    //todo
    /**
     * 如何定义 DP数组是关键
     */
    class S1 {
        class Solution {
            public int maximalSquare(char[][] matrix) {
                int m = matrix.length, n = matrix[0].length;

                //base case
                int[][] f = new int[m][n];
                // 以 matrix[i][j] 为右下角元素的最大的全为 1 正方形矩阵的边长为 f[i][j]。
                for (int j = 0; j < n; j++)
                    f[0][j] = (matrix[0][j] - '0');
                for (int i = 0; i < m; i++)
                    f[i][0] = (matrix[i][0] - '0');

                for (int i = 1; i < m; i++) {
                    for (int j = 1; j < n; j++) {
                        if (matrix[i][j] == '1') {
                            f[i][j] = 1 + Math.min(Math.min(
                                            f[i - 1][j],
                                            f[i][j - 1]),
                                    f[i - 1][j - 1]);
                        }
                    }
                }
                int maxD = 0;
                for (int[] row : f) {
                    for (int x : row) {
                        maxD = Math.max(maxD, x);
                    }
                }
                return maxD * maxD;
            }
        }
    }
}
