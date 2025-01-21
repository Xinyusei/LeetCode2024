package Type_.动态规划.八_区间DP.二_其他区间DP;

/**
 * @Author: ZJX
 * @Date: 2025/01/21
 * @Description:
 */
public class a5最长回文子串 {
    /**
     * 暴力解法
     * 时间：O(N ^ 3)
     * 空间：O(1)
     */
    class S1 {
        class Solution {
            public String longestPalindrome(String s) {
                int n = s.length();
                int startIdx = 0, len = 1;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (isPalindrome(s, i, j)) {
                            if (j - i + 1 > len) {
                                len = j - i + 1;
                                startIdx = i;
                            }
                        }
                    }
                }

                return s.substring(startIdx, startIdx + len);
            }

            private boolean isPalindrome(String sub, int left, int right) {
                for (; left < right; left++, right--) {
                    if (sub.charAt(left) != sub.charAt(right))
                        return false;
                }
                return true;
            }
        }
    }

    /**
     * DP TABLE
     * 时间：O(N ^ 2)
     * 空间：O（N ^ 2）
     */
    class S2 {
        class Solution {
            public String longestPalindrome(String s) {
                int n = s.length();
                boolean[][] f = new boolean[n][n];
                //f[i][j] 表示 s[i] 到 s[j] 是否是回文子串(子数组)
                //base case
                for (int i = 0; i < n; i++) {
                    f[i][i] = true;
                }
                int startIndex = 0, maxLen = 1;
                for (int i = n - 1; i >= 0; i--) {
                    //注意这里 j 不用从 0 开始，因为当 i > j,f[i][j] = 0;
                    //i = j,f[i][j] = 1
                    //故 j 直接 从 i + 1 开始
                    for (int j = i + 1; j < n; j++) {
                        int len = j - i + 1;
                        if (s.charAt(i) == s.charAt(j)) {
                            if (len <= 2)
                                f[i][j] = true;
                            else
                                f[i][j] = f[i + 1][j - 1];


                        } else {
                            f[i][j] = false;
                        }
                        if (f[i][j] && len > maxLen) {
                            maxLen = len;
                            startIndex = i;
                        }
                    }
                }
                return s.substring(startIndex, startIndex + maxLen);

            }
        }
    }

    //暴力法」和「动态规划」枚举了字符串的左右边界，我们还可以 枚举可能出现的回文子串的「中心位置」，从「中心位置」尝试尽可能向两边，得到回文串。

    //找回文串的难点在于，回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧。

    /**
     * 中心扩散法
     */
    class S3 {
        class Solution {
            public String longestPalindrome(String s) {
                String res = "";
                for (int i = 0; i < s.length(); i++) {
                    String s1 = palindrome(s, i, i);
                    String s2 = palindrome(s, i, i + 1);
                    res = s1.length() > res.length() ? s1 : res;
                    res = s2.length() > res.length() ? s2 : res;
                }
                return res;
            }

            // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
            private String palindrome(String s, int l, int r) {
                //a b a c
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }

                return s.substring(l + 1, r);
            }
        }
    }
}
