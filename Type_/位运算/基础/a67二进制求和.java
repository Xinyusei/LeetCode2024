package Type_.位运算.基础;

/**
 * @Author: ZJX
 * @Date: 2025/01/15
 * @Description:
 */
public class a67二进制求和 {
    class S1 {
        class Solution {
            public String addBinary(String a, String b) {
                a = new StringBuilder(a).reverse().toString();
                b = new StringBuilder(b).reverse().toString();
                //存放结果
                StringBuilder sb = new StringBuilder();
                int carry = 0;

                int m = a.length(), n = b.length();
                //11
                //1
                //001
                for (int i = 0; i < Math.max(m, n) || carry != 0; i++) {
                    int val = carry;
                    val += i < m ? (a.charAt(i) - '0') : 0;
                    val += i < n ? (b.charAt(i) - '0') : 0;

                    sb.append(val & 1);
                    carry = val >> 1;
                }
                return sb.reverse().toString();
            }
        }
    }
}
