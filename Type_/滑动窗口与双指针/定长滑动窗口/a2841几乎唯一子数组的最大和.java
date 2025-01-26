package Type_.滑动窗口与双指针.定长滑动窗口;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2841. 几乎唯一子数组的最大和
 * https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/description/
 */
public class a2841几乎唯一子数组的最大和 {
    class Solution {
        public long maxSum(List<Integer> nums, int m, int k) {
            long res = 0, cur = 0;
            Map<Integer, Integer> window = new HashMap<>();

            for (int lo = 0, hi = 0; hi < nums.size(); hi++) {
                int AddKey = nums.get(hi);
                cur += AddKey;
                window.put(AddKey, window.getOrDefault(AddKey, 0) + 1);
                if (hi - lo + 1 == k) {
                    int diffN = window.keySet().size();
                    if (diffN >= m) {
                        res = Math.max(res, cur);
                    }
                    int deleteKey = nums.get(lo++);
                    cur -= deleteKey;
                    if (window.get(deleteKey) == 1)
                        window.remove(deleteKey);
                    else
                        window.put(deleteKey, window.get(deleteKey) - 1);
                }
            }
            return res;
        }
    }
}
