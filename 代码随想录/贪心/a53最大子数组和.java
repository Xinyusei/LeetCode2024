package 代码随想录.贪心;

/**
 * @Author: ZJX
 * @Date: 2024/10/20
 * @Description:
 */
public class a53最大子数组和 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            f[0] = nums[0];
            int ret = f[0];
            for (int i = 1; i < n; i++) {
                f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
                ret = Math.max(f[i], ret);
            }
            return ret;
        }
    }
}
