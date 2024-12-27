package 面试150;

/**
 * @Author: ZJX
 * @Date: 2024/12/27
 * @Description:
 */
public class a209长度最小的子数组 {
    /**
     * 经典滑动窗口
     */
    class S1 {
        class Solution {
            public int minSubArrayLen(int target, int[] nums) {
                int sum = 0, res = Integer.MAX_VALUE;
                for (int lo = 0, hi = 0; hi < nums.length; hi++) {
                    sum += nums[hi];
                    while (sum >= target) {
                        res = Math.min(res, hi - lo + 1);
                        sum -= nums[lo++];
                    }
                }
                return res == Integer.MAX_VALUE ? 0 : res;
            }
        }
    }
}
