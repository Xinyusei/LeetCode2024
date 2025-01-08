package 面试必刷.回溯.子集型回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/08
 * @Description:
 */
public class a784字母大小写全排列 {
    class S1 {
        class Solution {
            private final List<String> res = new ArrayList<>();

            private final StringBuilder path = new StringBuilder();

            public List<String> letterCasePermutation(String s) {
                dfs(s, 0);
                return res;
            }

            private void dfs(String s, int idx) {
                if (idx == s.length()) {
                    res.add(path.toString());
                    return;
                }

                char ch = s.charAt(idx);
                if (ch >= '0' && ch <= '9') {
                    path.append(ch);
                } else {
                    path.append(Character.toUpperCase(ch));
                    dfs(s, idx + 1);
                    path.deleteCharAt(path.length() - 1);

                    path.append(Character.toLowerCase(ch));
                }
                dfs(s, idx + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
