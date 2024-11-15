package 代码随想录.动态规划.买卖股票最佳时机;

/**
 * @Author: ZJX
 * @Date: 2024/11/14
 * @Description:
 */
public class a121买卖股票的最佳时机 {
    class Solution1 {
        public int maxProfit(int[] prices) {
            int result = 0, n = prices.length;
            //f[i][0/1] 表示 前 i 天 买入/卖出的最大数量
            for (int i = 0; i < n; i++) {
                int sold = prices[i];
                for (int j = 0; j < i; j++) {
                    int pay = prices[j];
                    result = Math.max(result, sold - pay);
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            int result = 0, n = prices.length;
            int prev = prices[0];
            //f[i][0/1] 表示 前 i 天 买入/卖出的最大数量
            for (int i = 1; i < n; i++) {
                int sold = prices[i];
                result = Math.max(result, sold - prev);
                prev = Math.min(prev, sold);
            }
            return result;
        }
    }

    class Solution3 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] f = new int[2];
            //base case
            f[1] = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                f[0] = Math.max(f[1] + prices[i - 1], f[0]);
                f[1] = Math.max(-prices[i - 1], f[1]);

            }
            return Math.max(f[0], f[1]);
        }
    }
}
