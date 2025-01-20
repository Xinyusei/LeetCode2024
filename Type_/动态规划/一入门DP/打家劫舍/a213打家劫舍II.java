package Type_.动态规划.一入门DP.打家劫舍;

/**
 * 213. 打家劫舍 II
 * https://leetcode.cn/problems/house-robber-ii/description/
 */
public class a213打家劫舍II {
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            return Math.max(nums[0] + rob1(nums, 2, n - 1), rob1(nums, 1, n));
        }

        public int rob1(int[] nums, int start, int end) {
            if(start > end)
                return 0;
            int[] f = new int[nums.length + 1];
            f[start] = nums[start];
            for (int i = start + 1; i < end; i++) {
                f[i] = Math.max(f[i - 1],f[i - 2] + nums[i]);
            }
            return f[end - 1];
        }
    }
}
