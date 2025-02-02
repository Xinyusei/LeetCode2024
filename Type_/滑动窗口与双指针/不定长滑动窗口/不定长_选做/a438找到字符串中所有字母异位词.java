package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_选做;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2025/02/02
 * @Description:
 */
public class a438找到字符串中所有字母异位词 {
    class S1 {
        class Solution {
            public List<Integer> findAnagrams(String s, String p) {
                int valid = 0;
                Map<Character, Integer> need = new HashMap<>(), curr = new HashMap<>();
                for (char c : p.toCharArray())
                    need.put(c, need.getOrDefault(c, 0) + 1);

                List<Integer> res = new ArrayList<>();
                for (int start = 0, end = 0; end < s.length(); end++) {
                    char addCh = s.charAt(end);
                    if (need.containsKey(addCh)) {
                        curr.put(addCh, curr.getOrDefault(addCh, 0) + 1);
                        if (curr.get(addCh).equals(need.get(addCh)))
                            valid++;
                    }
                    while (valid == need.size()) {
                        if (p.length() == end - start + 1)
                            res.add(start);
                        char rmCh = s.charAt(start);
                        if (need.containsKey(rmCh)) {
                            if (curr.get(rmCh).equals(need.get(rmCh)))
                                valid--;
                            curr.put(rmCh, curr.get(rmCh) - 1);

                        }
                        start++;
                    }
                }
                return res;
            }
        }
    }

    /**
     * 用数组优化哈希表
     */
    class S2 {
        class Solution {
            public List<Integer> findAnagrams(String s, String p) {
                int valid = 0;
                int[] need = new int[26], curr = new int[26];
                int sz = 0;
                for (char c : p.toCharArray()) {
                    need[c - 'a']++;
                }
                for (int i : need) {
                    if (i != 0)
                        sz++;
                }


                List<Integer> res = new ArrayList<>();
                for (int start = 0, end = 0; end < s.length(); end++) {
                    char addCh = s.charAt(end);
                    int addIdx = addCh - 'a';
                    if (need[addIdx] != 0) {
                        curr[addIdx]++;
                        if (need[addIdx] == curr[addIdx])
                            valid++;
                    }
                    while (valid == sz) {
                        if (p.length() == end - start + 1)
                            res.add(start);
                        char rmCh = s.charAt(start);
                        int rmIdx = rmCh - 'a';
                        if (need[rmIdx] != 0) {
                            if (need[rmIdx] == curr[rmIdx])
                                valid--;
                            curr[rmIdx]--;
                        }
                        start++;
                    }
                }
                return res;
            }
        }
    }
}
