package Hot100.动态规划;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/29
 * @Description:
 */
public class a32最长有效括号 {
    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length(), ret = 0;
            int[] f = new int[n];
            List<Integer> stk = new ArrayList<>();
            //f[i] 定义:记录以s[i]结尾的最长合法括号字串长度
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                // 遇到左括号，记录索引
                if (c == '(') {
                    // 左括号不可能是合法括号子串的结尾
                    stk.addFirst(i);
                } else {
                    //遇到右括号
                    if (!stk.isEmpty()) {
                        //配对的左括号的索引
                        int leftIndex = stk.removeFirst();
                        int len = i - leftIndex + 1;
                        f[i] = len + (leftIndex >= 1 ? f[leftIndex - 1] : 0);
                    } /*else
                        f[i] = 0;*/
                }
                ret = Math.max(ret, f[i]);
                //System.out.println(Arrays.toString(f));
            }
            return ret;
        }
    }
}
