package 面试必刷;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/12/27
 * @Description:
 */
public class a3无重复字符的最长子串 {
    /**
     * 滑窗 - set记录
     */
    class S2 {
        class Solution {
            public int lengthOfLongestSubstring(String s) {
                Set<Character> record = new HashSet<>();
                char[] cs = s.toCharArray();
                int res = 0;
                for (int lo = 0, hi = 0; hi < cs.length; hi++) {
                    while (record.contains(cs[hi])) {
                        record.remove(cs[lo++]);
                    }
                    record.add(cs[hi]);
                    res = Math.max(res, hi - lo + 1);
                }
                return res;
            }
        }
    }

    /**
     * 滑窗 - map记录
     */
    class S1 {
        class Solution {
            public int lengthOfLongestSubstring(String s) {
                Map<Character, Integer> record = new HashMap<>();
                char[] cs = s.toCharArray();
                int res = 0;
                for (int lo = 0, hi = 0; hi < cs.length; hi++) {
                    record.put(cs[hi], record.getOrDefault(cs[hi], 0) + 1);
                    while (record.get(cs[hi]) > 1) {
                        record.put(cs[lo], record.get(cs[lo]) - 1);
                        lo++;
                    }
                    res = Math.max(res, hi - lo + 1);
                }
                return res;
            }
        }
    }

}
