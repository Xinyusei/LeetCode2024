package 面试150;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/12/31
 * @Description:
 */
public class a71简化路径 {
    class S1 {
        class Solution {
            public String simplifyPath(String path) {
                String[] split = path.split("/");
                //System.out.println(Arrays.toString(split));
                List<String> stack = new ArrayList<>();
                for (String p : split) {
                    if (p.isEmpty() || p.equals(".") || p.equals(" ")) {
                        continue;
                    }
                    if (p.equals("..")) {
                        if (!stack.isEmpty())
                            stack.removeLast();
                    } else
                        stack.add(p);
                }
                System.out.println("stack = " + stack);
                StringBuilder res = new StringBuilder("/");
                for (String s : stack) {
                    res.append(s).append("/");
                }
                if (res.length() == 1)
                    return res.toString();
                else
                    return res.deleteCharAt(res.length() - 1).toString();
            }
        }
    }
}
