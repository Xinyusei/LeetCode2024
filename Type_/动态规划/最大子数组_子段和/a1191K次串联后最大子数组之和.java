package Type_.动态规划.最大子数组_子段和;

/**
 * https://leetcode.cn/problems/k-concatenation-maximum-sum/description/
 */
public class a1191K次串联后最大子数组之和 {
    class Solution {
        static final int MOD = (int) 1e9 + 7;

        public int kConcatenationMaxSum(int[] s, int k) {
            //假设 原有数组被切分为 a b c，其中b代表了最大子数组和
            //如果想要拼接在一起 a b c a b c a b c，现在最大子数组和为 b + c + a + b 即  sum（原数组之和) + b
            //sum>0,子数组之和最大值随K的大小而增长
            //sum<=0,子数组之和最大值随K的大小而增长

            //1. k=1 时，原数组做1次dp，获取最大子数组之和，值记为 ans
            //2. k>1 时，原数组做2次dp，第二次遍历求值在第一遍的基础上，获取最大子数组之和。

            int n = s.length;
            long q;
            long p = 0;
            long res = 0;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                q = Math.max(0, p) + s[i];
                p = q;
                sum += s[i];
                res = Math.max(res, q);

            }
            //System.out.println(res);
            if (k > 1) {
                for (int i = 0; i < n; i++) {
                    q = Math.max(0, p) + s[i];
                    p = q;
                    res = Math.max(res, q);
                }
            }
            //System.out.println(res);
            if (sum <= 0 || k <= 1)
                return (int) (res % MOD);
            return (int) ((k - 2) * sum % MOD + res % MOD);
        }
    }
}
