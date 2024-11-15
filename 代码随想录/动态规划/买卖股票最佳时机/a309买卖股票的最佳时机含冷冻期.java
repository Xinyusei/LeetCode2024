package 代码随想录.动态规划.买卖股票最佳时机;

/**
 * @Author: ZJX
 * @Date: 2024/11/15
 * @Description:
 */
public class a309买卖股票的最佳时机含冷冻期 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] f = new int[n + 1][2];
            f[1][0] = 0;
            f[1][1] = -prices[0];
            for (int i = 2; i <= n; i++) {
                //第 i 天不持有股票
                f[i][0] = Math.max(f[i - 1][1] + prices[i - 1], f[i - 1][0]);
                //第 i 天持有股票
                f[i][1] = Math.max(f[i - 2][0] - prices[i - 1], f[i - 1][1]);
            }
            return Math.max(f[n][0], f[n][1]);
        }
    }
}
