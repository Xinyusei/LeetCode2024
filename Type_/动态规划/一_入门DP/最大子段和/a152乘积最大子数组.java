package Type_.动态规划.一_入门DP.最大子段和;

/**
 * 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 */
public class a152乘积最大子数组 {
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int[] fMax = new int[n];
            int[] fMin = new int[n];
            fMax[0] = fMin[0] = nums[0];


            for (int i = 1; i < n; i++) {
                fMax[i] = Math.max(nums[i], Math.max(fMax[i - 1] * nums[i], fMin[i - 1] * nums[i]));
                fMin[i] = Math.min(nums[i], Math.min(fMax[i - 1] * nums[i], fMin[i - 1] * nums[i]));

            }
            int ret = Math.max(fMax[0], fMin[0]);
            for (int i = 1; i < n; i++) {
                ret = Math.max(ret, Math.max(fMax[i], fMin[i]));
            }
            return ret;
        }
    }
}
