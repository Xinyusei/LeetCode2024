package 面试必刷;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/12/31
 * @Description:
 */
public class a224基本计算器 {
    /**
     * 计算 + - * / ,包括 括号
     */
    class S2 {
        class Solution {
            Map<Integer, Integer> rightIndex;

            public int calculate(String s) {
                rightIndex = new HashMap<>();
                List<Integer> stack = new ArrayList<>();
                //记录 key：左括号索引 value：右括号索引
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(')
                        stack.addLast(i);
                    else if (s.charAt(i) == ')')
                        rightIndex.put(stack.removeLast(), i);
                }
                return doCalculate(s, 0, s.length() - 1);
            }

            // 定义：返回 s[start..end] 内的表达式的计算结果
            // 无论多少层括号嵌套，通过 doCalculate 函数递归调用自己，都可以将括号中的算式算出结果。
            // 换句话说，括号包含的算式，我们直接视为一个数字就行了。

            //docCalculate(3 * (4 - 5/2) - 6)
            //= 3 * doCalculate(4 - 5/2) - 6
            //= 3 * 2 - 6
            //= 0
            public int doCalculate(String s, int start, int end) {
                List<Integer> stack = new ArrayList<>();
                // 记录 num 前的符号，初始化为 +
                char sign = '+';
                // 记录算式中的数字
                int num = 0;
                for (int i = start; i <= end; i++) {
                    char c = s.charAt(i);
                    //如果是数字
                    if (c >= '0' && c <= '9') {
                        num = num * 10 + (c - '0');
                    }
                    if (c == '(') {
                        // 递归计算括号内的表达式
                        num = doCalculate(s, i + 1, rightIndex.get(i) - 1);
                        i = rightIndex.get(i);
                    }
                    //1 + 6 - 20
                    //如果不是数字 ,考虑是否是 + - * /,或者是算式的末尾
                    if (c == '+' || c == '-' || c == '*' || c == '/' || i == end) {
                        int pre;
                        switch (sign) {
                            case '+':
                                stack.addLast(num);
                                break;
                            case '-':
                                stack.addLast(-num);
                                break;
                            case '*':
                                pre = stack.removeLast();
                                stack.addLast(pre * num);
                                break;
                            case '/':
                                pre = stack.removeLast();
                                stack.add(pre / num);
                                break;
                        }
                        sign = c;
                        num = 0;
                    }
                }
                System.out.println("stack = " + stack);
                int res = 0;
                while (!stack.isEmpty()) {
                    res += stack.removeLast();
                }
                return res;
            }
        }
    }

    /**
     * 计算 + - * / 不包括括号
     */
    class S1 {
        class Solution {
            public int calculate(String s) {

                List<Integer> stack = new ArrayList<>();
                // 记录 num 前的符号，初始化为 +
                char sign = '+';
                // 记录算式中的数字
                int num = 0;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    //如果是数字
                    if (c >= '0' && c <= '9') {
                        num = num * 10 + (c - '0');
                    }

                    //1 + 6 - 20
                    //如果不是数字 ,考虑是否是 + - * /,或者是算式的末尾
                    if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                        int pre;
                        switch (sign) {
                            case '+':
                                stack.addLast(num);
                                break;
                            case '-':
                                stack.addLast(-num);
                                break;
                            case '*':
                                pre = stack.removeLast();
                                stack.addLast(pre * num);
                                break;
                            case '/':
                                pre = stack.removeLast();
                                stack.add(pre / num);
                                break;
                        }
                        sign = c;
                        num = 0;
                    }
                }
                System.out.println("stack = " + stack);
                int res = 0;
                while (!stack.isEmpty()) {
                    res += stack.removeLast();
                }
                return res;
            }
        }
    }
}

