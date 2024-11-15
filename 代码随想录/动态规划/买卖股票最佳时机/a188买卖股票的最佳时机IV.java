package 代码随想录.动态规划.买卖股票最佳时机;

/**
 * @Author: ZJX
 * @Date: 2024/11/14
 * @Description:
 */
public class a188买卖股票的最佳时机IV {
    class Solution {
        public int maxProfit(int K, int[] prices) {
            int n = prices.length;
            int[][][] f = new int[n + 1][K + 1][2];

            //base case
            //f[0][...][0] = 0;
            //因为 i 是从 1 开始的，所以 i = 0 意味着还没有开始，这时候的利润当然是 0。

            //f[0][...][1] = Integer.MIN_VALUE;
            //还没开始的时候，是不可能持有股票的。因为我们的算法要求一个最大值，所以初始值设为一个最小值，方便取最大值。
            for (int k = 0; k <= K; k++) {
                f[0][k][1] = Integer.MIN_VALUE;
            }

            //f[...][0][0] = 0;
            //因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0。
            //f[...][0][1] = Integer.MIN_VALUE;
            //不允许交易的情况下，是不可能持有股票的。因为我们的算法要求一个最大值，所以初始值设为一个最小值，方便取最大值。
            for (int i = 0; i <= n; i++) {
                f[i][0][1] = Integer.MIN_VALUE;
            }

            for (int i = 1; i <= n; i++) {
                for (int k = 1; k <= K; k++) {
                    //解释：今天我没有持有股票，有两种可能，我从这两种可能中求最大利润：
                    //1、我昨天持有股票，且截至昨天最大交易次数限制为 k；但是今天我 sell 了，所以我今天没有持有股票了，最大交易次数限制依然为 k。
                    //2、我昨天就没有持有，且截至昨天最大交易次数限制为 k；然后我今天选择 rest，所以我今天还是没有持有，最大交易次数限制依然为 k。
                    //f[i][k][0] = Math.max(         今天选择卖,             今天休息,不卖)
                    f[i][k][0] = Math.max(f[i - 1][k][1] + prices[i - 1], f[i - 1][k][0]);

//                    解释：今天我持有股票，有两种可能，我从这两种可能中求最大利润：
//                    1、我昨天就没有持有，且截至昨天最大交易次数限制为 k - 1；然后我今天选择 buy ，所以今天我就持有股票了，最大交易次数限制为 k。
//                    1、我昨天持有股票，且截至昨天最大交易次数限制为 k；但是今天我 rest 了，所以我今天还持有着股票，最大交易次数限制依然为 k。
//                    f[i][k][1] = Math.max(         今天选择买,             今天休息,不买)
                    f[i][k][1] = Math.max(f[i - 1][k - 1][0] - prices[i - 1], f[i - 1][k][1]);

                }
            }
            return Math.max(f[n][K][0], f[n][K][1]);
        }
    }

    class Solution1 {
        public int maxProfit(int K, int[] prices) {
            int n = prices.length;
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
