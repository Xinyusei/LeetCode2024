package Type_.动态规划.四_经典线性DP.一_最长公共子序列LCS;

/**
 * 1143. 最长公共子序列
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 */
public class a1143最长公共子序列 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            //a c d d b
            //b c e b
            int m = text1.length(), n = text2.length();
            int[][] f = new int[m + 1][n + 1];
            //f[i][j]表示text1[0:i-1](第0个元素到第i-1个元素)和text2[0:j-1]的最长公共子序列长度
            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        f[i][j] = f[i - 1][j - 1] + 1;
                    }else
                        f[i][j] = Math.max(f[i - 1][j],f[i][j - 1]);
                }
            }
            return f[m][n];
        }
    }
}
