package Type_.动态规划.状态机DP;

/**
 * @Author: ZJX
 * @Date: 2024/12/13
 * @Description:
 */
public class a3259超级饮料的最大强化能量 {
    class Solution {
        public long maxEnergyBoost(int[] s1, int[] s2) {
            int n = s1.length;
            long[][] f = new long[n + 1][2];
            f[1][0] = s1[0];
            f[1][1] = s2[0];
            for (int i = 2; i <= n; i++) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 2][1]) + s1[i - 1];
                f[i][1] = Math.max(f[i - 1][1], f[i - 2][0]) + s2[i - 1];
            }
            return Math.max(f[n][0], f[n][1]);
        }
    }
}
