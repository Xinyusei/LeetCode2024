package Type_.动态规划.一入门DP.最大子段和;

/**
 * 53. 最大子数组和
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">...</a>
 */
public class a53最大子数组和 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
                ans = Math.max(nums[i], ans);
            }
            return ans;
        }
    }
}
