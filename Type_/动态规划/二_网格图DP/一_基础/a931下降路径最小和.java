package Type_.动态规划.二_网格图DP.一_基础;

/**
 * <a href="https://leetcode.cn/problems/minimum-falling-path-sum/">下降路径最小和</a>
 */
public class a931下降路径最小和 {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            if (n == 1)
                return matrix[0][0];
            int[][] dp = new int[n][];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new int[matrix[i].length];
            }
            System.arraycopy(matrix[0], 0, dp[0], 0, n);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0)
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    else if (j == n - 1)
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    else
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                    dp[i][j] += matrix[i][j];
                }
            }
            int res = Integer.MAX_VALUE;
            for (int j = 0; j < dp[n - 1].length; j++) {
                res = Math.min(res, dp[n - 1][j]);
            }
            return res;
        }
    }
}
