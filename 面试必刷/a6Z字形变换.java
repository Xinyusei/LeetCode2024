package 面试必刷;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/23
 * @Description:
 */
public class a6Z字形变换 {
    /**
     * 找规律 - 第一行 / 中间几行 / 最后一行
     */
    class S1 {
        class Solution {
            public String convert(String s, int numRows) {
                if (numRows == 1 || s.length() <= numRows)
                    return s;
                //变换周期为 2 * r - 2;
                int t = numRows * 2 - 2;
                StringBuilder sb = new StringBuilder();
                //第一行：
                for (int i = 0; i < s.length(); i += t)
                    sb.append(s.charAt(i));
                for (int i = 1; i < numRows - 1; i++) {
                    int s1 = t - i * 2, s2 = i * 2, idx = i;
                    //System.out.println("s1 = " + s1);
                    //System.out.println("s2 = " + s2);
                    boolean flag = true;
                    while (idx < s.length()) {
                        sb.append(s.charAt(idx));
                        if (flag) {
                            idx += s1;
                            flag = false;
                        } else {
                            idx += s2;
                            flag = true;
                        }
                    }
                }
                //最后一行
                for (int i = numRows - 1; i < s.length(); i += t)
                    sb.append(s.charAt(i));
                return sb.toString();
            }
        }
    }

    /**
     * 更简单的规律 - 是 S1的压缩版,更直观
     */
    class S2 {

        class Solution {
            public String convert(String s, int numRows) {
                if (numRows == 1 || s.length() <= numRows)
                    return s;
                List<StringBuilder> rows = new ArrayList<>();
                for (int i = 0; i < numRows; i++) {
                    rows.add(new StringBuilder());
                }
                int idx = 0, flag = -1;
                for (char c : s.toCharArray()) {
                    rows.get(idx).append(c);
                    //每次到达第1行 或者 最后一行,方向反转
                    if (idx == 0 || idx == numRows - 1)
                        flag = -flag;
                    idx += flag;
                }
                StringBuilder sb = new StringBuilder();
                for (StringBuilder row : rows) {
                    sb.append(row);
                }
                return sb.toString();
            }
        }
    }


}
