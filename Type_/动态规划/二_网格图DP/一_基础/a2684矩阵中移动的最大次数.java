package Type_.动态规划.二_网格图DP.一_基础;

/**
 * 2684. 矩阵中移动的最大次数
 * https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/description/
 */
public class a2684矩阵中移动的最大次数 {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        //dp[i][j] 表示 能达到i,j的移动次数
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        int ret = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (dp[i][j - 1] != 0 && grid[i][j] > grid[i][j - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                if (i + 1 < m && dp[i + 1][j - 1] != 0 && grid[i][j] > grid[i + 1][j - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                if (i >= 1 && dp[i - 1][j - 1] != 0 && grid[i][j] > grid[i - 1][j - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret == 1 ? 0 : ret - 1;
    }
}
