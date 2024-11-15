package 代码随想录.动态规划.买卖股票最佳时机;

/**
 * @Author: ZJX
 * @Date: 2024/11/15
 * @Description:
 */
public class a122买卖股票的最佳时机II {
    class Solution {
        public int maxProfit(int[] prices) {
            //int k = 无限制,也就是 k 对结果没有任何影响
            int n = prices.length;
            int[][] f = new int[n + 1][2];
            for (int i = 0; i <= n; i++)
                f[i][1] = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                f[i][0] = Math.max(f[i - 1][1] + prices[i - 1], f[i - 1][0]);
                f[i][1] = Math.max(f[i - 1][0] - prices[i - 1], f[i - 1][1]);
            }
            return Math.max(f[n][0], f[n][1]);
        }
    }
}
