package Type_.动态规划.二_网格图DP.基础;

import java.util.Arrays;

/**
 * 1289. 下降路径最小和 II
 * https://leetcode.cn/problems/minimum-falling-path-sum-ii/description/
 */
public class a1289下降路径最小和II {
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int n = grid.length;
            if (n == 1)
                return grid[0][0];
            int ret = Integer.MAX_VALUE;
            int[][] dp = new int[n][n];
            for (int[] d : dp) {
                Arrays.fill(d, Integer.MAX_VALUE);
            }
            System.arraycopy(grid[0], 0, dp[0], 0, n);

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k == j)
                            continue;
                        dp[i][j] = Math.min(dp[i - 1][k], dp[i][j]);
                    }
                    dp[i][j] += grid[i][j];
                    if (i == n - 1)
                        ret = Math.min(ret, dp[i][j]);
                }
            }


            //System.out.println(Arrays.deepToString(dp));
            return ret;
        }
    }
}
