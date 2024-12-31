package 面试150;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/12/31
 * @Description:
 */
public class a20有效的括号 {

    class S1 {
        class Solution {
            private final static Map<Character, Character> correctPattern = new HashMap<>();

            static {
                correctPattern.put(')', '(');
                correctPattern.put('}', '{');
                correctPattern.put(']', '[');
            }

            public boolean isValid(String s) {
                List<Character> stack = new ArrayList<>();
                for (char c : s.toCharArray()) {
                    //是左括号或者栈为空 入栈
                    if (!correctPattern.containsKey(c)){
                        stack.addLast(c);
                        continue;
                    }
                    //右括号
                    if (stack.isEmpty() || !stack.getLast().equals(correctPattern.get(c)))
                        return false;
                    stack.removeLast();
                }
                return stack.isEmpty();
            }
        }
    }
}
