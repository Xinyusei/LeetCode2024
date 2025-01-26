package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求最小or最短;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/">209. 长度最小的子数组</a>
 */
public class a209长度最小的子数组 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int lo = 0, hi = 0, curSum = 0, ans = Integer.MAX_VALUE;
            while (hi < nums.length) {
                if (nums[hi] >= target)
                    return 1;
                curSum += nums[hi];
                while (curSum >= target) {
                    ans = Math.min(ans, hi - lo + 1);
                    curSum -= nums[lo];
                    lo++;
                }
                hi++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
