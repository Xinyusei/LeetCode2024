package Type_.动态规划.二_网格图DP.进阶;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/07
 * @Description:
 */
public class a688骑士在棋盘上的概率 {
    class Solution {
        double[][][] f;

        final static int[][] dir = new int[][]{
                {-1, -2},
                {1, -2},
                {-2, -1},
                {2, -1},
                {-2, 1},
                {2, 1},
                {-1, 2},
                {1, 2}
        };

        public double knightProbability(int n, int k, int row, int column) {
            f = new double[n][n][k + 1];
            for (double[][] f1 : f) {
                for (double[] f2 : f1) {
                    Arrays.fill(f2, -1.0);
                }
            }
            return dfs(row, column, n, k);
        }

        private double dfs(int x, int y, int n, int k) {
            if (k == 0 && x >= 0 && y >= 0 && x < n && y < n) {
                return f[x][y][k] = 1.0;
            }
            if (k < 0 || x < 0 || y < 0 || x >= n || y >= n) {
                return 0.0;
            }
            if (f[x][y][k] != -1.0)
                return f[x][y][k];

            double res = 0;
            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                res += dfs(nx, ny, n, k - 1) / 8;
            }
            return f[x][y][k] = res;
        }
    }
}
