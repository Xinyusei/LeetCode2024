package 代码随想录.动态规划.买卖股票最佳时机;

/**
 * @Author: ZJX
 * @Date: 2024/11/15
 * @Description:
 */
public class a123买卖股票的最佳时机III {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length, K = 2;
            int[][][] f = new int[n + 1][K + 1][2];
            for (int k = 0; k <= K; k++)
                f[0][k][1] = Integer.MIN_VALUE;
            for (int i = 0; i <= n; i++)
                f[i][0][1] = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int k = 1; k <= K; k++) {
                    f[i][k][0] = Math.max(f[i - 1][k][1] + prices[i - 1], f[i - 1][k][0]);
                    f[i][k][1] = Math.max(f[i - 1][k - 1][0] - prices[i - 1], f[i - 1][k][1]);
                }
            }
            return Math.max(f[n][K][0], f[n][K][1]);
        }
    }
}
