package 代码随想录.动态规划.打家劫舍;

/**
 * @Author: ZJX
 * @Date: 2024/11/14
 * @Description:
 */
public class a213打家劫舍II {
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1)
                return nums[0];
            else if (n == 2)
                return Math.max(nums[0], nums[1]);
            return Math.max(rob1(nums, 0, n - 2), rob1(nums, 1, n - 1));
        }

        /**
         * @param nums
         * @param left  最左索引
         * @param right 最右索引
         * @return
         * @author ZJX
         * @date 2024/11/14
         */
        public int rob1(int[] nums, int left, int right) {
            int n = right - left + 1;
            int[] f = new int[n];
            f[0] = nums[left];
            f[1] = Math.max(nums[left], nums[left + 1]);
            for (int i = 2; i < n; i++) {
                f[i] = Math.max(f[i - 1], f[i - 2] + nums[left + i]);
            }
            return f[n - 1];
        }
    }
}
