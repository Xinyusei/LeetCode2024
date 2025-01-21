package Type_.动态规划.二_网格图DP.一_基础;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/description/">62不同路径</a>
 */
public class a62不同路径 {
    /**
     * 记忆化 + DFS
     */
    class Solution1 {
        int m, n;
        int[][] memo;

        public int uniquePaths(int m, int n) {
            this.m = m;
            this.n = n;
            memo = new int[m][n];
            for (int[] me : memo) {
                Arrays.fill(me, -1);
            }
            return search(m - 1, n - 1);
        }

        private int search(int i, int j) {
            if (i == 0 || j == 0)
                return 1;
            if (memo[i][j] != -1)
                return memo[i][j];
            return memo[i][j] = search(i - 1, j) + search(i, j - 1);
        }
    }

    /**
     * DP
     */
    class Solution2 {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
