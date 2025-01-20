package Type_.动态规划.一_入门DP.打家劫舍;

/**
 * <a href="https://leetcode.cn/problems/count-number-of-ways-to-place-houses/">2320. 统计放置房子的方式数</a>
 */
public class a2320统计放置房子的方式数 {
    class Solution {
        static final int MOD = (int) 1e9 + 7, MX = (int) 1e4 + 1;
        static int[] f = new int[MX + 1];
        //考虑一边的情况
        //第i个地块,放 f[i] = f[i - 2]/ 不放 f[i] = f[i - 1]
        //故:f[i] = f[i - 1] + f[i - 2]
        //另外一遍的情况也是同上,两边相互独立。故return f[n] * f[n]
        static {
            f[0] = 1;
            f[1] = 2;
            for (int i = 2; i <= MX; i++) {
                f[i] = (f[i - 1] + f[i - 2]) % MOD;
            }

        }
        public int countHousePlacements(int n) {
            return (int)((long) f[n] * f[n] % MOD);
        }
    }
}
