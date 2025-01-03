package 面试必刷;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/12/31
 * @Description:
 */
public class a150逆波兰表达式求值 {
    class S1 {
        class Solution {
            final static Set<String> r = new HashSet<>();

            static {
                r.add("+");
                r.add("-");
                r.add("*");
                r.add("/");
            }

            //后缀表达式 -
            public int evalRPN(String[] tokens) {
                List<Integer> stack = new ArrayList<>();
                for (String token : tokens) {
                    if (!r.contains(token)) {
                        stack.addLast(Integer.valueOf(token));
                        continue;
                    }
                    //计算
                    int second = stack.removeLast();
                    int first = stack.removeLast();
                    int res = switch (token) {
                        case "+" -> first + second;
                        case "-" -> first - second;
                        case "*" -> first * second;
                        default -> first / second;
                    };
                    stack.addLast(res);
                }
                return stack.removeLast();
            }
        }
    }
}
