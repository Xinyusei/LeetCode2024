package Type_.滑动窗口与双指针.定长滑动窗口;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 * https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
 */
public class a1984学生分数的最小差值 {
    class Solution {
        public int minimumDifference(int[] nums, int k) {
            if (k == 1)
                return 0;
            Arrays.sort(nums);
            //1 4 7 9 11
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i <= nums.length - k; i++) {
                ans = Math.min(ans, nums[i + k - 1] - nums[i]);
            }
            return ans;
        }
    }
}
