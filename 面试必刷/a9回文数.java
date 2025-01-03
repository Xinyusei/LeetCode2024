package 面试必刷;

/**
 * @Author: ZJX
 * @Date: 2024/12/23
 * @Description:
 */
public class a9回文数 {
    /**
     * 数字 -> 字符串
     */
    class S1 {
        class Solution {
            public boolean isPalindrome(int x) {
                String s = String.valueOf(x);
                System.out.println(s);
                for (int lo = 0, hi = s.length() - 1; lo < hi; lo++, hi--) {
                    if (s.charAt(lo) != s.charAt(hi))
                        return false;
                }
                return true;
            }
        }
    }


    /**
     * 反转后面部分数字
     */
    class S2 {
        class Solution {
            public boolean isPalindrome(int x) {
                if (x < 0 || (x % 10 == 0 && x != 0))
                    return false;
                int reverse = 0;
                //1
                //12
                while (x > reverse) {
                    reverse = reverse * 10 + x % 10;
                    x /= 10;
                }
                return x == reverse || x == reverse / 10;
            }
        }
    }
}
