package Type_.动态规划;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 */
public class a322零钱兑换 {
    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //f[i]表示凑齐金额i所需的最少硬币数为f[i]
        int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);
        //base case
        f[0] = 0;
        for (int i = 0; i < f.length; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    f[i] = Math.min(f[i], f[i - coin] + 1);
                }
            }
        }
        return f[amount] == amount + 1 ? -1 : f[amount];
    }

    //二维dp版本
    public int coinChange2(int[] coins, int amount) {
        int INF = Integer.MAX_VALUE;
        //f[i]表示凑齐金额i所需的最少硬币数为f[i]
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        //base case
        //初始化（没有任何硬币的情况）：只有 f[0][0] = 0
        //其余情况均为无效值,这是由「状态定义」决定的，当不考虑任何硬币的时候，只能凑出总和为 0 的方案，所使用的硬币数量为 0
        for (int j = 1; j <= amount; j++)
            f[0][j] = INF;
        for (int i = 1; i <= n; i++) {
            int v = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= coins[i - 1])
                    if (f[i][j - v] != INF)
                        f[i][j] = Math.min(f[i][j], f[i][j - v] + 1);
            }
        }
        return f[n][amount] == INF ? -1 : f[n][amount];
    }


    //记忆化搜索
    class Solution {
        int[] memo;

        int INF = Integer.MAX_VALUE;

        public int coinChange(int[] cs, int amount) {
            this.memo = new int[amount + 1];
            //-2 代表没有遍历过
            //-1 代表无解
            Arrays.fill(memo, -2);

            return f(cs, amount);
        }

        //凑集金额为amount所需的最少硬币
        public int f(int[] cs, int amount) {
            if (amount == 0)
                return 0;
            if (amount < 0)
                return -1;
            if (memo[amount] != -2)
                return memo[amount];

            int ans = INF;
            for (int c : cs) {
                if (c <= amount) {
                    int subProblem = f(cs, amount - c);
                    //无解,跳过
                    if (subProblem == -1)
                        continue;
                    //有解
                    ans = Math.min(ans, subProblem + 1);
                }
            }
            return memo[amount] = (ans == INF ? -1 : ans);
        }
    }
}
