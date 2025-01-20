package Type_.动态规划.三_背包问题.一_零一背包;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/07
 * @Description:
 */
public class a3180执行操作可获得的最大总奖励I {
    class Solution {
        public int maxTotalReward(int[] s) {
            Arrays.sort(s);
            int n = s.length;
            //最大值为 mx ,想要全部加起来, 前面的和最大是 mx - 1 ，也就是说最大价值就是 2 * mx - 1,即 背包容量 <= 2 * mx
            int mx = s[n - 1];
            boolean[] f = new boolean[2 * mx];
            //在 i 个数中挑选，总奖励j 是否可以获得
            //base case
            f[0] = true;
            for (int i = 1; i < n; i++) {
                int v = s[i]; //当前数的值
                for (int j = 2 * mx - 1; j >= v; j--) {
                    f[j] |= f[j - v];
                }
            }
            int ans = 0;
            for (int i = 0; i < f.length; i++) {
                if (f[i])
                    ans = i;
            }
            return ans;
        }
    }
}
