package Type_.数学.杂项.回文数;

/**
 * @Author: ZJX
 * @Date: 2025/01/16
 * @Description:
 */
public class a9回文数 {
    class S1 {
        class Solution {
            public boolean isPalindrome(int x) {
                String s = String.valueOf(x);
                int lo = 0, hi = s.length() - 1;
                while (lo < hi) {
                    if (s.charAt(lo) != s.charAt(hi))
                        return false;
                    lo++;
                    hi--;
                }
                return true;
            }
        }
    }

    class S2 {
        class Solution {
            public boolean isPalindrome(int x) {
                int rev = 0, copy = x;
                while (copy > 0) {
                    rev = rev * 10 + copy % 10;
                    copy /= 10;
                }
                return rev == x;
            }
        }
    }
}
