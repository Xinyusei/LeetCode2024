package 代码随想录.动态规划.子序列.LCS最长公共子序列;

/**
 * @Author: ZJX
 * @Date: 2024/11/20
 * @Description:
 */
public class a1143最长公共子序列 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length(), n2 = text2.length();
            int[][] f = new int[n1 + 1][n2 + 1];

            //f[i][j] 表示 以text1[i - 1] 和 text2[j - 1] 结尾的两个字符串中最长的公共子序列长度
            for (int i = 1; i <= n1; i++) {
                char c1 = text1.charAt(i - 1);
                for (int j = 1; j <= n2; j++) {
                    char c2 = text2.charAt(j - 1);
                    if (c1 == c2)
                        f[i][j] = f[i - 1][j - 1] + 1;
                    else
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }

            return f[n1][n2];
        }
    }
}
