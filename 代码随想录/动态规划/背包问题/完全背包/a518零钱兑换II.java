package 代码随想录.动态规划.背包问题.完全背包;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/10/30
 * @Description:
 */
public class a518零钱兑换II {
    class Solution {
        /**
         * 完全背包 - 二维模版
         *
         * @param amount
         * @param coins
         * @return
         * @author ZJX
         * @date 2024/10/30
         */
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] f = new int[n + 1][amount + 1];
            f[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= amount; j++) {
                    f[i][j] = f[i - 1][j];
                    if (coins[i - 1] <= j) {
                        f[i][j] += f[i][j - coins[i - 1]];
                    }
                }
            }
            return f[n][amount];
        }

        // 完全背包 - 一维模版
        public int change2(int amount, int[] coins) {
            int n = coins.length;
            int[] f = new int[amount + 1];
            f[0] = 1;
            for (int coin : coins) {
                for (int j = 1; j <= amount; j++) {
                    if (coin <= j) {
                        f[j] += f[j - coin];
                    }
                }
            }
            return f[amount];
        }
    }


    class Solution2 {
        int[][] memo;

        public int change(int amount, int[] coins) {
            int n = coins.length;
            this.memo = new int[coins.length][amount + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dfs(amount, coins, n - 1);
        }

        public int dfs(int amount, int[] coins, int index) {
            if (index < 0)
                return amount == 0 ? 1 : 0;
            if (memo[index][amount] != -1)
                return memo[index][amount];

            if (amount < coins[index])
                return memo[index][amount] = dfs(amount, coins, index - 1);
            else
                return memo[index][amount] = dfs(amount, coins, index - 1) + dfs(amount - coins[index], coins, index);
        }
    }
}
