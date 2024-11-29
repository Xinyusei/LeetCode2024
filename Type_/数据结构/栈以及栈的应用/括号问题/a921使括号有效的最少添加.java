package Type_.数据结构.栈以及栈的应用.括号问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/29
 * @Description:
 */
public class a921使括号有效的最少添加 {
    class Solution1 {
        public int minAddToMakeValid(String s) {
            //ls代表对右括号的需求
            List<Character> ls = new ArrayList<>();
            int left = 0;
            for (char c : s.toCharArray()) {
                if (c == '(')
                    ls.addFirst(c);
                else {
                    if (ls.isEmpty()) {
                        left++;
                    } else
                        ls.removeFirst();
                }
            }
            return ls.size() + left;
        }
    }

    class Solution2 {
        public int minAddToMakeValid(String s) {
            // res 记录插入次数
            int res = 0;
            // need 变量记录右括号的需求量
            int need = 0;
            for (char c : s.toCharArray()) {
                if (c == '(')
                    // 对右括号的需求 + 1
                    need++;
                else {
                    //此时没有需要匹配的左括号,但是多出了一个右括号,右括号需要额外的左括号来匹配,res++,代表插入一个左括号,此时need变为0，对右括号的需求减为0.
                    need--;
                    if (need == -1) {
                        res++;
                        need = 0;
                    }

                }
            }
            return need + res;
        }
    }
}
