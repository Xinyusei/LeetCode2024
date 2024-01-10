package Ev2024_1;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/description/?envType=daily-question&envId=2024-01-10
 * 2696. 删除子串后的字符串最小长度
 */
public class 删除子串后的字符串最小长度1_10 {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(s.replace("AF", ""));
    }

    /**
     * 直接模拟删除AB、CD
     *
     * @param s
     * @return
     */
    public int minLength(String s) {
        String sub1 = "AB", sub2 = "CD";
        if (s.contains(sub1) || s.contains(sub2)) {
            s = s.replace(sub1, "");
            s = s.replace(sub2, "");
            System.out.println(s);
        }
        return s.length();
    }


    /**
     * 不去模拟删除，而是借助括号匹配的思路
     *
     * @param s
     * @return
     */
    public int minLength2(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('B', 'A');
        map.put('D', 'C');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.add(c);
            int n = stack.size();
            if ((c == 'D' || c == 'B' )&& n >= 2 && stack.get(n - 2) == map.get(c)) {
                stack.remove(n - 1);
                stack.remove(n - 2);
            }
        }
        return stack.size();

    }

    /**
     * https://leetcode.cn/problems/valid-parentheses/
     * 20. 有效的括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(c))
                    return false;
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

    public boolean isValid2(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != c)
                return false;
            else
                stack.pop();
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

}
