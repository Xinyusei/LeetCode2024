package Type_.动态规划.二_网格图DP.二_进阶;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/07
 * @Description:
 */
public class a741摘樱桃 {
    class Solution {
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int[][][] f = new int[n * 2 - 1][n + 1][n + 1];
            for (int[][] m : f) {
                for (int[] r : m) {
                    Arrays.fill(r, Integer.MIN_VALUE);
                }
            }
            f[0][1][1] = grid[0][0];
            for (int t = 1; t < n * 2 - 1; t++) {
                for (int j = Math.max(t - n + 1, 0); j <= Math.min(t, n - 1); j++) {
                    if (grid[t - j][j] < 0) continue;
                    for (int k = j; k <= Math.min(t, n - 1); k++) {
                        if (grid[t - k][k] < 0) continue;
                        f[t][j + 1][k + 1] = Math.max(Math.max(f[t - 1][j + 1][k + 1], f[t - 1][j + 1][k]), Math.max(f[t - 1][j][k + 1], f[t - 1][j][k])) +
                                grid[t - j][j] + (k != j ? grid[t - k][k] : 0);
                    }
                }
            }
            return Math.max(f[n * 2 - 2][n][n], 0);
        }
    }
}
