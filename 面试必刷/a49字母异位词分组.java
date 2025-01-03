package 面试必刷;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/12/30
 * @Description:
 */
public class a49字母异位词分组 {
    class S1 {
        class Solution {
            public List<List<String>> groupAnagrams(String[] strs) {
                //
                Map<String, List<String>> record = new HashMap<>();
                for (String s : strs) {
                    String cur = convert_v2(s);
                    //System.out.println("cur = " + cur);
                    record.putIfAbsent(cur, new ArrayList<>());
                    record.get(cur).add(s);
                }
                return new ArrayList<>(record.values());
                //return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(this::convert_v2)).values());
            }

            private String convert_v1(String s) {
                int[] cnt = new int[26];
                for (char ch : s.toCharArray()) {
                    cnt[ch - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cnt.length; i++) {
                    if (cnt[i] == 0)
                        continue;
                    char ch = (char) (i + 'a');
                    sb.append(("" + ch).repeat(cnt[i]));
                }
                return sb.toString();
            }

            private String convert_v2(String s) {
                int[] cnt = new int[26];
                for (char ch : s.toCharArray()) {
                    cnt[ch - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cnt.length; i++) {
                    if (cnt[i] == 0)
                        continue;
                    char ch = (char) (i + 'a');
                    sb.append(ch).append(cnt[i]);

                }
                return sb.toString();
            }
        }
    }
}

