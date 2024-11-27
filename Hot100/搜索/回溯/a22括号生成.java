package Hot100.搜索.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/27
 * @Description:
 */
public class a22括号生成 {
    class Solution1 {
        //暴力递归，主要
        class Solution {
            static final char[] s = new char[]{'(', ')'};
            StringBuilder sb = new StringBuilder();
            List<String> res = new ArrayList<>();

            int n;

            public List<String> generateParenthesis(int n) {
                this.n = n;
                backtrack(s);

                return res;
            }

            private void backtrack(char[] s) {
                if (sb.length() == n * 2) {
                    if (valid(sb)) {
                        res.add(sb.toString());
                    }
                    return;
                }

                for (int i = 0; i < s.length; i++) {
                    sb.append(s[i]);
                    //System.out.println(sb);
                    backtrack(s);
                    //System.out.println(sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }


            private boolean valid(StringBuilder sb) {
                LinkedList<Character> stack = new LinkedList<>();
                for (int i = 0; i < sb.length(); i++) {
                    char c = sb.charAt(i);
                    if (c == '(')
                        stack.addLast(c);
                    else {
                        if (stack.isEmpty() || stack.getLast() != '(')
                            return false;
                        stack.removeLast();
                    }
                }
                return stack.isEmpty();
            }
        }
    }


    class Solution2 {
        //剪枝- 相当于
        //剩余左括号总数要小于等于右括号。 递归把所有符合要求的加上去就行了：
        class Solution {
            List<String> res = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            public List<String> generateParenthesis(int n) {
                if (n <= 0)
                    return res;
                backtrack(n, n);
                return res;
            }

            private void backtrack(int left, int right) {
                // 若左括号剩下的多，说明不合法
                if (right < left)
                    return;
                // 数量小于 0 肯定是不合法的
                if (left < 0 || right < 0)
                    return;
                //当所有括号都恰好用完时，得到一个合法的括号组合
                if (left == 0 && right == 0) {
                    res.add(sb.toString());
                    return;
                }
                sb.append('(');
                backtrack(left - 1, right);
                sb.deleteCharAt(sb.length() - 1);

                sb.append(')');
                backtrack(left, right - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
