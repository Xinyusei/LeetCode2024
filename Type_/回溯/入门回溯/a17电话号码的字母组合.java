package Type_.回溯.入门回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/14
 * @Description:
 */
public class a17电话号码的字母组合 {
    class S1 {
        class Solution {
            private final static String[] record = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            private List<String> res;

            private StringBuilder path;

            public List<String> letterCombinations(String digits) {
                if(digits == null || digits.isEmpty())
                    return new ArrayList<>();
                res = new ArrayList<>();
                path = new StringBuilder();
                backtrack(digits, 0);
                return res;
            }

            private void backtrack(String s, int idx) {
                if (path.length() == s.length()) {
                    res.add(new String(path));
                    return;
                }

                for (int i = idx; i < s.length(); i++) {
                    int num = s.charAt(i) - '0';
                    String t = record[num];
                    for (char c : t.toCharArray()) {
                        path.append(c);
                        backtrack(s, i + 1);
                        path.deleteCharAt(path.length() - 1);
                    }
                }
            }
        }

    }
}
