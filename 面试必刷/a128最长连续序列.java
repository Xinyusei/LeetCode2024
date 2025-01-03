package 面试必刷;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/12/29
 * @Description:
 */
public class a128最长连续序列 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> record = new HashSet<>();
            for (int x : nums) {
                record.add(x);
            }
            int ans = 0;

            for (int num : record) {
                if (record.contains(num - 1))
                    // num 不是连续子序列的第一个
                    continue;
                //num 是子序列的第一个
                int curNum = num;
                while (record.contains(curNum + 1)) {
                    curNum++;
                }
                ans = Math.max(ans, curNum - num + 1);
            }
            return ans;
        }
    }
}
