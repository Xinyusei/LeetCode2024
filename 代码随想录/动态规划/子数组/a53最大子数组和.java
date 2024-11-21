package 代码随想录.动态规划.子数组;

/**
 * @Author: ZJX
 * @Date: 2024/11/20
 * @Description:
 */
public class a53最大子数组和 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] f = new int[n + 1];
            int ret = Integer.MIN_VALUE;

            //f[i] 表示nums[0 : i - 1]且以nums[i - 1]结尾的最大子数组和
            for (int i = 1; i <= n; i++) {
                f[i] = Math.max(0, f[i - 1]) + nums[i - 1];
                ret = Math.max(ret, f[i]);
            }
            return ret;
        }
    }
}
