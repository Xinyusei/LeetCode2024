package Type_.动态规划.二_网格图DP.进阶;

import java.util.Arrays;

/**
 * 1594. 矩阵的最大非负积
 * https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix/description/
 */
public class a1594矩阵的最大非负积 {
    class Solution {
        static final int MOD = (int) 1e9 + 7;

        public int maxProductPath(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            long[][] f1 = new long[m][n];
            long[][] f2 = new long[m][n];

            f1[0][0] = f2[0][0] = grid[0][0];

            for (int i = 1; i < m; i++)
                f1[i][0] = f2[i][0] = f1[i - 1][0] * grid[i][0];

            for (int j = 1; j < n; j++)
                f1[0][j] = f2[0][j] = f2[0][j - 1] * grid[0][j];

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (grid[i][j] >= 0) {
                        f1[i][j] = Math.max(f1[i - 1][j], f1[i][j - 1]);
                        f2[i][j] = Math.min(f2[i - 1][j], f2[i][j - 1]);
                    } else {
                        f1[i][j] = Math.min(f1[i - 1][j], f1[i][j - 1]);
                        f2[i][j] = Math.max(f2[i - 1][j], f2[i][j - 1]);
                    }f1[i][j] *= grid[i][j];
                    f2[i][j] *= grid[i][j];

                }
            }
            System.out.println(Arrays.deepToString(f1));
            System.out.println(Arrays.deepToString(f2));

            return f1[m - 1][n - 1] >= 0 ? (int)f1[m - 1][n - 1] % MOD : -1;
        }
    }
}
