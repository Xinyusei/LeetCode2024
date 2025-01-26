package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求子数组个数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2799. 统计完全子数组的数目
 * https://leetcode.cn/problems/count-complete-subarrays-in-an-array/description/
 */
public class a2799统计完全子数组的数目 {
    class Solution {
        //分别计算以每个下标作为起始下标的完全子数组的数目
        public int countCompleteSubarrays(int[] nums) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums)
                seen.add(num);
            int distinct = seen.size();
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                Set<Integer> curSet = new HashSet<>();
                for (int j = i; j < nums.length; j++) {
                    curSet.add(nums[j]);
                    if (curSet.size() == distinct)
                        ans++;
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public int countCompleteSubarrays(int[] nums) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums)
                seen.add(num);
            int n = seen.size();
            Map<Integer, Integer> window = new HashMap<>();
            int ret = 0;
            for (int lo = 0, hi = 0; hi < nums.length; hi++) {
                window.put(nums[hi], window.getOrDefault(nums[hi], 0) + 1);
                while (window.size() == n) {
                    //找到一个完全子数组nums[lo...hi],此时,nums[lo...hi]就是一个滑动窗口,
                    //此时nums[lo...hi...n-1] (hi...n-1表示子数组右边界的范围为[j...n-1])都是完全子数组,
                    //所以res += n-hi.
                    ret += nums.length - hi;
                    //此时子数组满足 完全子数组
                    int prev = nums[lo];
                    window.put(prev, window.get(prev) - 1);
                    if (window.get(prev) == 0)
                        window.remove(prev);
                    lo++;
                }
            }
            return ret;
        }
    }
}
