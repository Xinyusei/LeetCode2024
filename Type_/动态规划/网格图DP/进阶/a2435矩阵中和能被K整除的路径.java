package Type_.动态规划.二_网格图DP.进阶;

/**
 * @Author: ZJX
 * @Date: 2024/12/03
 * @Description:
 */
public class a2435矩阵中和能被K整除的路径 {
    class Solution {
        final static int mod = (int) 1e9 + 7;

        public int numberOfPaths(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            //套路：把路径和模 k 的结果当成一个扩展维度
            int[][][] f = new int[m][n][k];
            //定义 f[i][j][v] 表示从左上走到 (i,j)，且路径和模 k 的结果为 v 时的路径数。

            //初始值 f[0][0][grid[0][0]modk]=1，答案为 f[m−1][n−1][0]。

            //base case
            for (int i = 0, prev = 0; i < m; i++) {
                f[i][0][(prev + grid[i][0]) % k] = 1;
                prev = (prev + grid[i][0]) % k;
            }
            for (int j = 0, prev = 0; j < n; j++) {
                f[0][j][(prev + grid[0][j]) % k] = 1;
                prev = (prev + grid[0][j]) % k;
            }
            //System.out.println(Arrays.deepToString(f));
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    int cur = grid[i][j];
                    for (int v = 0; v < k; v++) {
                        f[i][j][(v + cur) % k] = f[i - 1][j][v] % mod + f[i][j - 1][v] % mod;
                    }
                }
            }
            //System.out.println(Arrays.deepToString(f));
            return f[m - 1][n - 1][0] % mod;
        }
    }
}
