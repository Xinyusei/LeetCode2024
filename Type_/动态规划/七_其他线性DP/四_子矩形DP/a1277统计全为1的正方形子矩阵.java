package Type_.动态规划.七_其他线性DP.四_子矩形DP;

/**
 * @Author: ZJX
 * @Date: 2025/01/22
 * @Description:
 */
public class a1277统计全为1的正方形子矩阵 {
    /**
     * 如何定义 DP table 是关键
     * 跟 211最大正方形 很类似
     */
    class S1 {
        class Solution {
            public int countSquares(int[][] matrix) {
                int m = matrix.length, n = matrix[0].length;

                //base case
                int[][] f = new int[m][n];
                // 以 matrix[i][j] 为右下角元素的不同边长的正方形的 个数为f[i][j]
                //或者说:以 matrix[i][j] 为右下角元素的正方形的最大边长为f[i][j]
                System.arraycopy(matrix[0], 0, f[0], 0, n);
                for (int i = 0; i < m; i++)
                    f[i][0] = matrix[i][0];
                int res = 0;
                for (int i = 1; i < m; i++) {
                    for (int j = 1; j < n; j++) {
                        if (matrix[i][j] == 1) {
                            f[i][j] = 1 + Math.min(Math.min(
                                            f[i - 1][j],
                                            f[i][j - 1]),
                                    f[i - 1][j - 1]);
                        }
                    }
                }
                for (int[] row : f) {
                    for (int x : row) {
                        res += x;
                    }
                }
                return res;
            }
        }
    }
}
