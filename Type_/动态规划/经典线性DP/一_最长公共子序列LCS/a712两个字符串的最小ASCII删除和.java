package Type_.动态规划.经典线性DP.一_最长公共子序列LCS;

public class a712两个字符串的最小ASCII删除和 {
    class Solution {
        public int minimumDeleteSum(String word1, String word2) {
            //求最长公共子序列的ASCII
            int n = word1.length(), m = word2.length();
            int[][] f = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    char c1 = word1.charAt(i - 1), c2 = word2.charAt(j - 1);
                    if (c1 == c2)
                        f[i][j] = f[i - 1][j - 1] + (int) c1;
                    else
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
            int sum = 0;
            for (char c : word1.toCharArray()) {
                sum += c;
            }
            for (char c : word2.toCharArray()) {
                sum += c;
            }
            return sum - 2 * f[n][m];
        }
    }
}
