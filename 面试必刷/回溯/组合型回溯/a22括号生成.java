package 面试必刷.回溯.组合型回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/10
 * @Description:
 */
public class a22括号生成 {
    class S1 {
        class Solution {


            StringBuilder sb = new StringBuilder();
            List<String> res = new ArrayList<>();

            public List<String> generateParenthesis(int n) {
                dfs(n, n);

                return res;
            }

            private void dfs(int left, int right) {
                //有效，生成全部括号 ，保存结果
                if (left == 0 && right == 0) {
                    res.add(sb.toString());
                    return;
                }
                if (left < 0 || right < 0)
                    return;
                if (right < left)
                    return;


                System.out.println("sb = " + sb + " , 添加 " + '(');
                sb.append('(');
                dfs(left - 1, right);
                System.out.println("sb = " + sb + " , 删除 " + '(');
                sb.deleteCharAt(sb.length() - 1);


                System.out.println("sb = " + sb + " , 添加 " + ')');
                sb.append(')');
                dfs(left, right - 1);
                System.out.println("sb = " + sb + " , 删除 " + ')');
                sb.deleteCharAt(sb.length() - 1);

            }
        }
    }
}
