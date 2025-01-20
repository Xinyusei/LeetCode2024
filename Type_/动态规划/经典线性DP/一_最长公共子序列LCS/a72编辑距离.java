package Type_.动态规划.经典线性DP.一_最长公共子序列LCS;

import java.util.Arrays;

/**
 * 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/description/
 */
public class a72编辑距离 {
    /**
     * DP
     */
    class Solution1 {
        public int minDistance(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] f = new int[m + 1][n + 1];
            //f[i][j] 表示s1[0-i-1]转化为s2[0-j-1]的最小操作数
            for (int i = 0; i <= m; i++)
                f[i][0] = i;
            for (int j = 0; j <= n; j++)
                f[0][j] = j;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    char c1 = s1.charAt(i - 1), c2 = s2.charAt(j - 1);
                    if (c1 == c2)
                        f[i][j] = f[i - 1][j - 1];
                    else
                        f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1], f[i - 1][j - 1])) + 1;
                }
            }
            return f[m][n];
        }
    }

    class Solution2 {
        private char[] s, t;
        private int[][] memo;

        public int minDistance(String s1, String s2) {
            s = s1.toCharArray();
            t = s2.toCharArray();
            int m = s1.length(), n = s2.length();
            memo = new int[m][n];
            for (int[] mo : memo) {
                Arrays.fill(mo, -1);
            }
            return dfs(m - 1, n - 1);
        }

        public int dfs(int i, int j) {
            if(i < 0) return j + 1;
            if(j < 0) return i + 1;
            if (memo[i][j] != -1)
                return memo[i][j];
            char c1 = s[i], c2 = t[j];
            if (c1 == c2)
                return memo[i][j] = dfs(i - 1, j - 1);
            else
                return memo[i][j] = Math.min(dfs(i - 1, j), Math.min(dfs(i, j - 1), dfs(i - 1, j - 1))) + 1;
        }
    }
}
