package Type_.动态规划.四_经典线性DP.一_最长公共子序列LCS;

/**
 * 115. 不同的子序列
 * https://leetcode.cn/problems/distinct-subsequences/description/
 * 2024-6-17
 */
public class a115不同的子序列 {
    class Solution {
        static final int MOD = (int) 1e9 + 7;

        public int numDistinct(String s, String t) {
            int m = s.length(), n = t.length();
            if (m < n)
                return 0;
            int[][] f = new int[m + 1][n + 1];
            //f[i][j]  定义 f[i][j] 为考虑 s 中 [0~i - 1] 个字符，t 中 [0~j - 1] 个字符的匹配个数。
            //base case
            for (int i = 0; i <= m; i++)
                f[i][0] = 1;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    //两种决策
                    //1.s[i - 1] != t[j - 1],则不让s[i]参与匹配,跳过。有:f[i][j] = f[i - 1][j]
                    if (s.charAt(i - 1) != t.charAt(j - 1))
                        f[i][j] = f[i - 1][j];
                        //2.s[i - 1] == t[j - 1]
                        //2.1 s[i - 1]参与匹配,此时 不需要考虑当前s子串和t子串的最后一位字母，所以只需要 f[i-1][j-1]
                        //2.2 s[i - 1]不参与匹配,则需要f[i - 1][j]
                    else {
                        f[i][j] += f[i - 1][j - 1] + f[i - 1][j];
                    }
                }
            }
            return f[m][n];
        }
    }
}
