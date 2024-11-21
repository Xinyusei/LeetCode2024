package Hot100.哈希;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/11/21
 * @Description:
 */
public class a49字母异位词分组 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //每一个strs其实可以对应一个数字
            Map<String, List<String>> record = new HashMap<>();
            for (String s : strs) {
                String key = convert(s);
                if (!record.containsKey(key)) {
                    record.put(key, new LinkedList<>());
                }
                record.get(key).add(s);
            }
            return new LinkedList<>(record.values());
        }


        public String convert(String s) {
            char[] count = new char[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                count[c - 'a']++;
            }
            return new String(count);
        }
    }
}
