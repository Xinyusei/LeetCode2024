package Type_.回溯.组合型回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/15
 * @Description:
 */
public class a22括号生成 {
    class S1 {
        class Solution {
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            public List<String> generateParenthesis(int n) {
                backtrack(n, n);
                return res;
            }

            private void backtrack(int left, int right) {
                if (left == 0 && right == 0) {
                    res.add(sb.toString());
                    return;
                }

                if (left > 0) {
                    sb.append('(');
                    backtrack(left - 1, right);
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (right > left) {
                    sb.append(')');
                    backtrack(left, right - 1);
                    sb.deleteCharAt(sb.length() - 1);

                }
            }

        }
    }
}
