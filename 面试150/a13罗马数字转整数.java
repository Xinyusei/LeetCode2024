package 面试150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/12/22
 * @Description:
 */
public class a13罗马数字转整数 {
    /**
     * 纯模拟
     */
    class Solution {
        private final static Map<String, Integer> record = new HashMap<>();

        private final static Set<Character> sp = new HashSet<>();

        static {
            record.put("I", 1);
            record.put("V", 5);
            record.put("X", 10);
            record.put("L", 50);
            record.put("C", 100);
            record.put("D", 500);
            record.put("M", 1000);
            record.put("IV", 5);
            record.put("IX", 9);
            record.put("XL", 40);
            record.put("XC", 90);
            record.put("CD", 400);
            record.put("CM", 900);

            sp.add('I');
            sp.add('X');
            sp.add('C');
        }

        public int romanToInt(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); ) {
                char ch = s.charAt(i);
                if (!sp.contains(ch) || i == s.length() - 1) {
                    res += record.get("" + ch);
                    i++;
                } else {
                    String sub = s.substring(i, i + 2);
                    if (record.containsKey(sub)) {
                        res += record.get(sub);
                        i += 2;
                    } else {
                        res += record.get("" + s.charAt(i));
                        i++;
                    }
                }
            }
            return res;
        }
    }

    /**
     *
     */
    class Solution2 {
        private final static Map<Character, Integer> record = new HashMap<>();

        static {
            record.put('I', 1);
            record.put('V', 5);
            record.put('X', 10);
            record.put('L', 50);
            record.put('C', 100);
            record.put('D', 500);
            record.put('M', 1000);
        }

        public int romanToInt(String s) {
            int res = 0, n = s.length();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                int v = record.get(ch);
                if (i < n - 1 && v < record.get(s.charAt(i + 1)))
                    res -= v;
                else
                    res += v;
            }
            return res;
        }
    }
}
