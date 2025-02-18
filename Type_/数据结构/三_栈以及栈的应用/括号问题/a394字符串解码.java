package Type_.数据结构.三_栈以及栈的应用.括号问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: ZJX
 * @Date: 2025/02/17
 * @Description:
 */
public class a394字符串解码 {
    class S1 {
        class Solution {
            public String decodeString(String s) {
                StringBuilder res = new StringBuilder();
                int multi = 0;
                List<Integer> stack_multi = new ArrayList<>();
                List<String> stack_res = new LinkedList<>();

                for (char c : s.toCharArray()) {
                    if (c == '[') {
                        stack_multi.add(multi);
                        stack_res.add(res.toString());
                        multi = 0;
                        res = new StringBuilder();
                    } else if (c == ']') {
                        StringBuilder tmp = new StringBuilder();
                        int cur_multi = stack_multi.removeLast();
                        for (int i = 0; i < cur_multi; i++) tmp.append(res);
                        res = new StringBuilder(stack_res.removeLast() + tmp);
                    } else if (c >= '0' && c <= '9') multi = multi * 10 + (c - '0');

                    else res.append(c);
                }
                return res.toString();
            }
        }
    }
}
