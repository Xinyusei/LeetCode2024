package 周赛.w425;

import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/24
 * @Description:
 */
public class a100484最小正和子数组 {
    class Solution {
        public int minimumSumSubarray(List<Integer> nums, int l, int r) {
            int ret = Integer.MAX_VALUE;
            for (int lo = 0; lo < nums.size(); lo++) {
                int window = 0;
                for (int hi = lo; hi < nums.size() && hi < r + lo; hi++) {
                    window += nums.get(hi);
                    if (window > 0 && (hi - lo + 1) >= l)
                        ret = Math.min(ret, window);
                }
            }
            return ret == Integer.MAX_VALUE ? -1 : ret;
        }
    }
}
