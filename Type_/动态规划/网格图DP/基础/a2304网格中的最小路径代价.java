package Type_.动态规划.二_网格图DP.基础;

import java.util.Arrays;

/**
 * 2304. 网格中的最小路径代价
 * https://leetcode.cn/problems/minimum-path-cost-in-a-grid/description/
 */
public class a2304网格中的最小路径代价 {
    class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
            int m = grid.length, n = grid[0].length;
            int ret = Integer.MAX_VALUE;
            int[][] dp = new int[m][n];
            for (int[] d : dp) {
                Arrays.fill(d, Integer.MAX_VALUE);
            }
            //base case
            System.arraycopy(grid[0], 0, dp[0], 0, n);
            //5 , 3
            //23, 8


            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        int prev = grid[i - 1][k];
                        dp[i][j] = Math.min(dp[i][j], moveCost[prev][j] + dp[i - 1][k]);
                    }
                    dp[i][j] += grid[i][j];
                    //System.out.println(Arrays.deepToString(dp));
                    if (i == m - 1)
                        ret = Math.min(ret, dp[i][j]);
                }
            }
            return ret;
        }
    }
}
