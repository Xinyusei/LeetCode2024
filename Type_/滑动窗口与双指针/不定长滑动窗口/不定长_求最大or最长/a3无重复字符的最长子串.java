package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求最大or最长;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class a3无重复字符的最长子串 {
    /**
     * 滑动窗口-双指针+哈希表
     * 定义两个指针 start 和 end，表示当前处理到的子串是 [start,end]。[start,end] 始终满足要求：无重复字符。
     * 从前往后进行扫描，同时维护一个哈希表记录 [start,end] 中每个字符出现的次数。遍历过程中，end 不断自增，将第 end 个字符在哈希表中出现的次数加一。
     * 令 right 为 下标 end 对应的字符，当满足 map.get(right) > 1 时，代表此前出现过第 end 位对应的字符。
     * 此时更新 start 的位置（使其右移），直到不满足 map.get(right) > 1 （代表 [start,end] 恢复满足无重复字符的条件）。
     * 同时使用 [start,end] 长度更新答案。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int ans = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            seen.put(ch, seen.getOrDefault(ch, 0) + 1);
            while (seen.get(ch) > 1) {
                char de = s.charAt(left);
                seen.put(de, seen.get(de) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {

        Map<Character, Integer> seen = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (seen.containsKey(ch))
                seen.put(ch, seen.get(ch) + 1);
            else
                seen.put(ch, 1);
            right++;
            while (left < right && seen.get(ch) > 1) {
                char de = s.charAt(left);
                seen.put(de, seen.get(de) - 1);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        while (right < chars.length) {
            char ch = chars[right];
            if (seen.containsKey(ch))
                seen.put(ch, seen.get(ch) + 1);
            else
                seen.put(ch, 1);
            right++;
            while (left < right && seen.get(ch) > 1) {
                char de = chars[left];
                seen.put(de, seen.get(de) - 1);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }


    class S1 {
        class Solution {
            public int lengthOfLongestSubstring(String s) {
                int start = 0, end = 0, n = s.length();
                int res = 0;
                Map<Character, Integer> record = new HashMap<>();
                while (end < s.length()) {
                    char addCh = s.charAt(end);
                    record.put(addCh, record.getOrDefault(addCh, 0) + 1);

                    while (record.get(addCh) > 1) {
                        char rmCh = s.charAt(start);
                        record.put(rmCh, record.get(rmCh) - 1);
                        if (record.get(rmCh) == 0)
                            record.remove(rmCh);
                        start++;
                    }
                    res = Math.max(res, end - start + 1);
                    end++;
                }
                return res;

            }
        }
    }

}
