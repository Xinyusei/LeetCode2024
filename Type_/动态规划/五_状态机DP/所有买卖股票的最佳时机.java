package Type_.动态规划.五_状态机DP;

/**
 * @Author: ZJX
 * @Date: 2024/12/21
 * @Description:
 */
public class 所有买卖股票的最佳时机 {
    /**
     * 最大交易次数为k(通解) - 188. 买卖股票的最佳时机 IV 通法
     */
    class S1 {
        /**
         * 全状态 - 无优化
         */
        class Solution {
            public int maxProfit(int k, int[] prices) {
                int n = prices.length;
                int[][][] f = new int[n][k + 1][2];
                //f[i][j][0/1] 表示在前i天,最多进行了k次交易,此时不持有/持有当前股票所获得的最大利润
                //买入会使得交易次数 + 1
                for (int i = 0, j = 0; j <= k; j++)
                    f[i][j][1] = -prices[0];
                for (int i = 1; i < n; i++) {
                    for (int j = 1; j <= k; j++) {
                        //当前不持有股票
                        f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + prices[i]);
                        //当前持有股票
                        f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - prices[i]);
                    }
                }
                return Math.max(f[n - 1][k][0], f[n - 1][k][1]);
            }
        }

        /**
         * 优化 - 可以用滚动数组
         */
        class Solution2 {
            public int maxProfit(int k, int[] prices) {
                int n = prices.length;
                int[][] f = new int[k + 1][2];
                //f[i][j][0/1] 表示在前i天,最多进行了k次交易,此时不持有/持有当前股票所获得的最大利润
                //买入会使得交易次数 + 1
                for (int j = 0; j <= k; j++)
                    f[j][1] = -prices[0];
                for (int price : prices) {
                    for (int j = 1; j <= k; j++) {
                        //当前不持有股票
                        f[j][0] = Math.max(f[j][0], f[j][1] + price);
                        //当前持有股票
                        f[j][1] = Math.max(f[j][1], f[j - 1][0] - price);
                    }
                }
                return Math.max(f[k][0], f[k][1]);
            }
        }
    }

    /**
     * 限制了最大交易次数为2 - 123. 买卖股票的最佳时机 III
     */
    class S2 {
        /**
         * 全状态
         */
        class Solution {
            public int maxProfit(int[] prices) {
                int n = prices.length;
                int k = 2;
                int[][][] f = new int[n][k + 1][2];
                //f[i][j][0/1] 表示在前i天,最多进行了k次交易,此时不持有/持有当前股票所获得的最大利润
                //买入会使得交易次数 + 1
                for (int i = 0, j = 0; j <= k; j++)
                    f[i][j][1] = -prices[0];
                for (int i = 1; i < n; i++) {
                    for (int j = 1; j <= k; j++) {
                        //当前不持有股票
                        f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + prices[i]);
                        //当前持有股票
                        f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - prices[i]);
                    }
                }
                return Math.max(f[n - 1][k][0], f[n - 1][k][1]);
            }
        }

        /**
         * 优化 - 滚动数组版本
         */
        class Solution2 {
            public int maxProfit(int[] prices) {
                int n = prices.length, k = 2;
                int[][] f = new int[k + 1][2];
                //f[i][j][0/1] 表示在前i天,最多进行了k次交易,此时不持有/持有当前股票所获得的最大利润
                //买入会使得交易次数 + 1
                for (int j = 0; j <= k; j++)
                    f[j][1] = -prices[0];
                for (int price : prices) {
                    for (int j = 1; j <= k; j++) {
                        //当前不持有股票
                        f[j][0] = Math.max(f[j][0], f[j][1] + price);
                        //当前持有股票
                        f[j][1] = Math.max(f[j][1], f[j - 1][0] - price);
                    }
                }
                return Math.max(f[k][0], f[k][1]);
            }
        }
    }

    /**
     * 最大交易次数为1 - 121. 买卖股票的最佳时机
     */
    class S4 {
        class Solution {
            public int maxProfit(int[] prices) {
                int n = prices.length, k = 1;
                int[][] f = new int[k + 1][2];
                //f[i][j][0/1] 表示在前i天,最多进行了k次交易,此时不持有/持有当前股票所获得的最大利润
                //买入会使得交易次数 + 1
                for (int j = 0; j <= k; j++)
                    f[j][1] = -prices[0];
                for (int price : prices) {
                    for (int j = 1; j <= k; j++) {
                        //当前不持有股票
                        f[j][0] = Math.max(f[j][0], f[j][1] + price);
                        //当前持有股票
                        f[j][1] = Math.max(f[j][1], f[j - 1][0] - price);
                    }
                }
                return Math.max(f[k][0], f[k][1]);
            }
        }
    }

    /**
     * 不限制交易次数 - 122. 买卖股票的最佳时机 II
     */
    class S3 {
        /**
         * 滚动数组版本
         */
        class Solution {
            public int maxProfit(int[] prices) {
                int n = prices.length;
                int[] f = new int[2];
                //f[i][j][0/1] 表示在前i天,最多进行了k次交易,此时不持有/持有当前股票所获得的最大利润
                // 不限制交易次数 k = Integer.MAX_VALUE;
                //买入会使得交易次数 + 1
                f[1] = -prices[0];
                for (int price : prices) {
                    //当前不持有股票
                    f[0] = Math.max(f[0], f[1] + price);
                    //当前持有股票
                    f[1] = Math.max(f[1], f[0] - price);
                }
                return Math.max(f[0], f[1]);
            }
        }
    }




}
