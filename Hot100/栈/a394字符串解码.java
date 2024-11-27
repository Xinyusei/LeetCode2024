package Hot100.栈;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/27
 * @Description:
 */
public class a394字符串解码 {
    class Solution1 {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            List<Integer> stack_multi = new LinkedList<>();
            List<String> stack_res = new LinkedList<>();

            for (char c : s.toCharArray()) {
                if (c == '[') {
                    stack_multi.addLast(multi);
                    stack_res.addLast(res.toString());
                    multi = 0;
                    res = new StringBuilder();
                } else if (c == ']') {
                    StringBuilder tmp = new StringBuilder();
                    int cur_multi = stack_multi.removeLast();
                    for (int i = 0; i < cur_multi; i++) {
                        tmp.append(res);
                    }
                    res = new StringBuilder(stack_res.removeLast() + tmp);
                } else if (c >= '0' && c <= '9') {
                    multi = multi * 10 + Integer.parseInt(c + "");
                }else
                    res.append(c);
            }
            return res.toString();
        }
    }
    
}
