package 面试150;

/**
 * @Author: ZJX
 * @Date: 2024/12/23
 * @Description:
 */
public class a6Z字形变换 {
    /**
     * 找规律
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



}
