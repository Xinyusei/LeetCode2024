package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求最大or最长;

import java.util.Arrays;

/**
 * 2779. 数组的最大美丽值
 * https://leetcode.cn/problems/maximum-beauty-of-an-array-after-applying-operation/description/?envType=daily-question&envId=2024-06-15
 * 2024-6-15
 */
public class a2779数组的最大美丽值 {
    class Solution {
        public int maximumBeauty(int[] nums, int k) {
            //1,2,4,6   k = 2  min = 0,max= 4
            Arrays.sort(nums);
            int lo = 0, hi = 0;
            int res = 1;
            int max = nums[lo] + k;
            for (; hi < nums.length; hi++) {
                if (nums[hi] - k <= max)
                    res = Math.max(res, hi - lo + 1);
                else {
                    lo++;
                    max = nums[lo] + k;
                }
            }
            return res;
        }
    }
}
