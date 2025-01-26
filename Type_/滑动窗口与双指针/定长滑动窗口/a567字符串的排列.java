package Type_.滑动窗口与双指针.定长滑动窗口;

import java.util.HashMap;

/**
 * 567. 字符串的排列
 * https://leetcode.cn/problems/permutation-in-string/
 */
public class a567字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> exits = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = 0;
        for (int left = 0, right = 0; right < s2.length(); right++) {
            char ch = s2.charAt(right);
            if (need.containsKey(ch)) {
                exits.put(ch, exits.getOrDefault(ch, 0) + 1);
                if (exits.get(ch).equals(need.get(ch))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                char de = s2.charAt(left);
                if (need.containsKey(de)) {
                    if (exits.get(de).equals(need.get(de)))
                        valid--;
                    exits.put(de, exits.get(de) - 1);
                    if (right - left + 1 == s1.length())
                        return true;
                }
                left++;
            }
        }
        return false;
    }
}

