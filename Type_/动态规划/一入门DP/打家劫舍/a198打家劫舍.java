package Type_.动态规划.一入门DP.打家劫舍;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">...</a>
 */
public class a198打家劫舍 {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1)
                return nums[0];
            if (nums.length <= 2)
                return Math.max(nums[0], nums[1]);
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }
    }
}
