package 面试必刷.回溯.入门回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2025/01/08
 * @Description:
 */
public class a17电话号码的字母组合 {
    class S1 {
        class Solution {
            private final static Map<Character, List<Character>> record = new HashMap<>();

            static {
                record.put('2', List.of('a', 'b', 'c'));
                record.put('3', List.of('d', 'e', 'f'));
                record.put('4', List.of('g', 'h', 'i'));
                record.put('5', List.of('j', 'k', 'l'));
                record.put('6', List.of('m', 'n', 'o'));
                record.put('7', List.of('p', 'q', 'r', 's'));
                record.put('8', List.of('t', 'u', 'v'));
                record.put('9', List.of('w', 'x', 'y', 'z'));
            }

            private final static String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            private final List<String> res = new ArrayList<>();
            private final StringBuilder curr = new StringBuilder();

            public List<String> letterCombinations(String digits) {
                if (digits == null || digits.isEmpty())
                    return res;
                backtrack(digits, 0);
                return res;
            }

            private void backtrack(String digits, int idx) {
                if (idx == digits.length()) {
                    //System.out.println("保存 curr = " + curr);
                    res.addLast(curr.toString());
                    return;
                }

        /*char c = digits.charAt(idx);
        for (Character cs : record.get(c)) {
            curr.append(cs);
            backtrack(digits, idx + 1);
            curr.deleteCharAt(curr.length() - 1);
        }*/

                for (char cs : mapping[digits.charAt(idx) - '0'].toCharArray()) {
                    curr.append(cs);
                    backtrack(digits, idx + 1);
                    curr.deleteCharAt(curr.length() - 1);
                }
            }
        }
    }
}
