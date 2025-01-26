package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求最大or最长;

import java.util.HashSet;
import java.util.Set;

/**
 * 1695. 删除子数组的最大得分
 * https://leetcode.cn/problems/maximum-erasure-value/description/
 */
public class a1695删除子数组的最大得分 {
    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            Set<Integer> window = new HashSet<>();
            int MaxScore = 0;
            int sum = 0;
            for (int lo = 0, hi = 0; hi < nums.length; hi++) {
                int toAdd = nums[hi];
                if (window.contains(toAdd)) {
                    while (nums[lo] != toAdd) {
                        window.remove(nums[lo]);
                        sum -= nums[lo];
                        lo++;
                    }
                    lo++;
                } else {
                    window.add(toAdd);
                    sum += toAdd;
                    MaxScore = Math.max(MaxScore, sum);
                }
            }
            return MaxScore;
        }
    }
}
