package Type_.动态规划.四_经典线性DP.一_最长公共子序列LCS;

/**
 * 583. 两个字符串的删除操作
 * https://leetcode.cn/problems/delete-operation-for-two-strings/description/
 */
public class a583两个字符串的删除操作 {
    class Solution {
        public int minDistance(String word1, String word2) {
            //求最长公共子序列的长度
            int n = word1.length(), m = word2.length();
            int[][] f = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    char c1 = word1.charAt(i - 1), c2 = word2.charAt(j - 1);
                    if (c1 == c2)
                        f[i][j] = f[i - 1][j - 1] + 1;
                    else
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
            return n + m - f[n][m];
        }
    }
}
