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
public class 罗马数字整数互转 {
    /**
     * 罗马数字 -> 整数
     */
    class S1 {
        class Solution1 {
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

        class Solution2 {
            class Solution {
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
    }


    /**
     * 整数 -> 罗马数字
     */
    class S2 {
        class Solution {
            private final static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            private final static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            public String intToRoman(int num) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < values.length; i++) {
                    int x = values[i];
                    String symbol = symbols[i];
                    while (num >= x) {
                        num -= x;
                        sb.append(symbol);
                    }
                    if (num == 0)
                        break;
                }
                return sb.toString();
            }
        }
    }
}
