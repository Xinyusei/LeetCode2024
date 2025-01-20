package Type_.动态规划.经典线性DP.一_最长公共子序列LCS;

/**
 * 97. 交错字符串
 * https://leetcode.cn/problems/interleaving-string/description/
 */
public class a97交错字符串 {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length(), n = s2.length(), t = s3.length();
            if (m + n != t)
                return false;
            boolean[][] f = new boolean[m + 1][n + 1];

            //base case
            //f[i][j][k] 为true以s1[0~i-1],s2[0~j-1]能交错构成s3[0~i + j - 1]
            for (int i = 1; i <= m; i++) {
                char c1 = s1.charAt(i - 1), c3 = s3.charAt(i - 1);
                if (c1 == c3)
                    f[i][0] = true;
                else
                    break;
            }
            for (int j = 1; j <= n; j++) {
                char c2 = s2.charAt(j - 1), c3 = s3.charAt(j - 1);
                if (c2 == c3)
                    f[0][j] = true;
                else
                    break;
            }
            f[0][0] = true;
            //遍历
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int k = i + j;
                    char c1 = s1.charAt(i - 1), c2 = s2.charAt(j - 1), c3 = s3.charAt(k - 1);
                    if (c1 == c3 && c2 == c3)
                        f[i][j] = f[i - 1][j] || f[i][j - 1];
                    else if (c1 == c3)
                        f[i][j] = f[i - 1][j];
                    else if (c2 == c3)
                        f[i][j] = f[i][j - 1];
                }

            }
            return f[m][n];
        }
    }
}
