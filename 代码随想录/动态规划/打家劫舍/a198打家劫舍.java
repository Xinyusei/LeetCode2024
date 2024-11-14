package 代码随想录.动态规划.打家劫舍;

/**
 * @Author: ZJX
 * @Date: 2024/11/14
 * @Description:
 */
public class a198打家劫舍 {
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            if (n <= 1)
                return nums[0];
            f[0] = nums[0];
            f[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < n; i++) {
                f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
            }
            return f[n - 1];
        }
    }
}
