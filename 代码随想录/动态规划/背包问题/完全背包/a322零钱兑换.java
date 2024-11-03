package 代码随想录.动态规划.背包问题.完全背包;

import javax.naming.spi.NamingManager;
import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/11/03
 * @Description:
 */
public class a322零钱兑换 {
    class Solution1 {
        public int coinChange(int[] coins, int amount) {
            int[] f = new int[amount + 1];
            Arrays.fill(f, amount + 1);
            f[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int v : coins) {
                    if (v <= i) {
                        f[i] = Math.min(f[i], f[i - v] + 1);
                    }
                }
            }
            return f[amount] > amount ? -1 : f[amount];
        }
    }
}
