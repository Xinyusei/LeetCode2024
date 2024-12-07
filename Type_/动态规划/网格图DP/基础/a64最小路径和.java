package Type_.动态规划.二_网格图DP.基础;

/**
 * 64. 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/description/
 */
public class a64最小路径和 {
    public int minPathSum(int[][] g) {
        int m = g.length,n = g[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = g[0][0];
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + g[i][0];
        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + g[0][j];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + g[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
