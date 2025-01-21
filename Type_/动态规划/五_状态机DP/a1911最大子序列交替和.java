package Type_.动态规划.五_状态机DP;

/**
 * @Author: ZJX
 * @Date: 2024/12/22
 * @Description:
 */
public class a1911最大子序列交替和 {
    /**
     * 状态机DP - 时间0(n) 空间0(n)
     */
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;
            long[][] f = new long[n][2];

            //f[i][0/1]前 i 个数长度为偶数/奇数的最大交替和
            f[0][0] = 0;
            f[0][1] = nums[0];
            long ret = Long.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] - nums[i]);
                f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] + nums[i]);
            }
            return Math.max(f[n - 1][0], f[n - 1][1]);
        }
    }


    /**
     * 状态机DP + 滚动数组 - 时间0(n) 空间0(1)
     */
    class Solution2 {
        public long maxAlternatingSum(int[] nums) {
            int n = nums.length;
            long[] f = new long[2];
            //f[i][0/1]前 i 个数长度为偶数/奇数的最大交替和
            f[1] = nums[0];
            for (int i = 1; i < n; i++) {
                f[0] = Math.max(f[0], f[1] - nums[i]);
                f[1] = Math.max(f[1], f[0] + nums[i]);
            }
            return Math.max(f[0], f[1]);
        }
    }
}
