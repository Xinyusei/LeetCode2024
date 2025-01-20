package Type_.动态规划.三_背包问题.二_完全背包;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2025/01/20
 * @Description:
 */
public class a322零钱兑换 {
    /**
     * 记忆化搜索
     */
    class S1 {
        class Solution {
            //-2代表未访问过 ， -1代表无法凑出
            private int[] memo;

            public int coinChange(int[] coins, int amount) {
                this.memo = new int[amount + 1];
                Arrays.fill(memo, -2);

                return dfs(amount, coins);
            }

            //凑成 target 金额所需要的最少 硬币个数
            private int dfs(int target, int[] coins) {
                if (target == 0)
                    return 0;
                if (target < 0)
                    return -1;
                if (memo[target] != -2)
                    return memo[target];

                int res = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (coin > target)
                        continue;
                    int subProblem = dfs(target - coin, coins);
                    if (subProblem == -1)
                        continue;
                    res = Math.min(res, subProblem + 1);
                }
                return memo[target] = res == Integer.MAX_VALUE ? -1 : res;
            }
        }
    }

    /**
     * DP TABLE
     */
    class S2 {
        class Solution {
            public int coinChange(int[] coins, int amount) {
                int[] f = new int[amount + 1];
                Arrays.fill(f, Integer.MAX_VALUE);
                f[0] = 0;
                for (int i = 1; i <= amount; i++) {
                    for (int coin : coins) {
                        if (i < coin || f[i - coin] == Integer.MAX_VALUE)
                            continue;
                        f[i] = Math.min(f[i], f[i - coin] + 1);
                    }
                }
                return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
            }
        }
    }
}
