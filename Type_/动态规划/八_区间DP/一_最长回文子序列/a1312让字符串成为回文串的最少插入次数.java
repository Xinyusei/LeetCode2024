package Type_.动态规划.八_区间DP.一_最长回文子序列;

/**
 * @Author: ZJX
 * @Date: 2025/01/21
 * @Description:
 */
public class a1312让字符串成为回文串的最少插入次数 {
    class S1{
        class Solution {
            public int minInsertions(String s) {
                return s.length() - longestPalindromeSubseq(s);
            }

            public int longestPalindromeSubseq(String s) {
                int n = s.length();
                int[][] f = new int[n][n];

                //f[i][j] 表示 s[i] 到 s[j] 的最长回文子序列的长度

                //base case
                for (int i = 0; i < n; i++) {
                    f[i][i] = 1;
                }

                for (int i = n - 1; i >= 0; i--) {
                    //注意这里 j 不用从 0 开始，因为当 i > j,f[i][j] = 0;
                    //i = j,f[i][j] = 1
                    //故 j 直接 从 i + 1 开始
                    for (int j = i + 1; j < n; j++) {
                        if (s.charAt(i) == s.charAt(j)) {
                            f[i][j] = f[i + 1][j - 1] + 2;
                        } else
                            f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                    }

                }
                return f[0][n - 1];
            }
        }
    }
}
