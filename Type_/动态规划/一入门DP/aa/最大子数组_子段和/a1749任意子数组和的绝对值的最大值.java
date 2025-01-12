package Type_.动态规划.一入门DP.aa.最大子数组_子段和;

/**
 * 1749. 任意子数组和的绝对值的最大值
 * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/
 */
public class a1749任意子数组和的绝对值的最大值 {
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int fz = 0, ff = 0, ans = 0;
            for (int i = 0; i < nums.length; i++) {
                fz = Math.max(fz, 0) + nums[i];
                ff = Math.min(ff, 0) + nums[i];
                ans = Math.max(ans, Math.max(fz, -ff));
            }
            return ans;
        }
    }
}
