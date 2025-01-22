package Type_.动态规划.四_经典线性DP.一_最长公共子序列LCS;

import java.util.Arrays;

/**
 * 72. 编辑距离
 * https://leetcode.cn/problems/edit-distance/description/
 */
public class a72编辑距离 {
    /**
     * DFS + cache
     * 状态: DFS(i,j)表示 从 s1[0...i] 转化为 s2[0...j]的最少操作数
     */
    class S1_1 {
        class Solution {
            //备忘录，防止重复计算
            Integer[][] memo;

            public int minDistance(String word1, String word2) {
                int m = word1.length(), n = word2.length();
                this.memo = new Integer[m][n];
                return dfs(word1, word1.length() - 1, word2, word2.length() - 1);
            }

            // dfs(i,j) 表示从 s1[0...i] 转化为 s2[0...j]的最少操作数
            private int dfs(String s1, int i, String s2, int j) {
                //base case
                if (i < 0 && j < 0)
                    return 0;
                else if (i < 0)
                    return j + 1;
                else if (j < 0)
                    return i + 1;
                if (memo[i][j] != null)
                    return memo[i][j];
                int res;
                if (s1.charAt(i) == s2.charAt(j))
                    res = dfs(s1, i - 1, s2, j - 1);
                else {
                    //1.替换 2.删除 3.插入
                    res = 1 + Math.min(Math.min(
                                    dfs(s1, i - 1, s2, j - 1),
                                    dfs(s1, i - 1, s2, j)),
                            dfs(s1, i, s2, j - 1));
                }
                return memo[i][j] = res;
            }
        }
    }

    /**
     * DP TABLE
     * f[i][j] 表示：从 s1[0...i - 1] 转化为 s2[0...j - 1]的最少操作数
     */
    class S2_1 {
        class Solution {
            public int minDistance(String word1, String word2) {
                char[] s = word1.toCharArray();
                char[] t = word2.toCharArray();
                int m = s.length, n = t.length;
                //dp table
                int[][] f = new int[m + 1][n + 1];
                //base case
                for (int i = 0, j = 0; j <= n; j++) f[i][j] = j;
                for (int i = 0, j = 0; i <= m; i++) f[i][j] = i;

                for (int i = 1; i <= m; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (s[i - 1] == t[j - 1])
                            f[i][j] = f[i - 1][j - 1];
                        else
                            //1.替换 2.删除 3.插入
                            f[i][j] = 1 + Math.min(Math.min(
                                    f[i - 1][j - 1],
                                    f[i - 1][j]
                            ), f[i][j - 1]);
                    }
                }
                return f[m][n];
            }
        }
    }

    /**
     * DFS + cache
     * 状态: DFS(i,j) 表示 从 s1[i...m - 1] 转化为 s2[j...n - 1]的最少操作数
     */
    class S1_2 {
        class Solution {
            //备忘录，防止重复计算
            Integer[][] memo;

            public int minDistance(String word1, String word2) {
                int m = word1.length(), n = word2.length();
                this.memo = new Integer[m + 1][n + 1];
                return dfs(word1, 0, word2, 0);
            }

            // dfs(i,j) ：从 s1[i...m - 1] 转化为 s2[j...n - 1]的最少操作数
            private int dfs(String s1, int i, String s2, int j) {
                int m = s1.length(), n = s2.length();
                //base case
                if (i == m && j == n)
                    return 0;
                else if (i == m)
                    return n - j;
                else if (j == n)
                    return m - i;
                if (memo[i][j] != null)
                    return memo[i][j];
                int res;
                if (s1.charAt(i) == s2.charAt(j))
                    res = dfs(s1, i + 1, s2, j + 1);
                else {
                    //1.替换 2.删除 3.插入
                    res = 1 + Math.min(Math.min(
                                    dfs(s1, i + 1, s2, j + 1),
                                    dfs(s1, i + 1, s2, j)),
                            dfs(s1, i, s2, j + 1));
                }
                return memo[i][j] = res;
            }
        }
    }

    /**
     * DP TABLE
     * f[i][j] 表示 从 s1[i...m - 1] 转化为 s2[j...n - 1]的最少操作数
     */
    class S2_2 {
        class Solution {
            public int minDistance(String word1, String word2) {
                char[] s = word1.toCharArray();
                char[] t = word2.toCharArray();
                int m = s.length, n = t.length;
                //dp table
                int[][] f = new int[m + 1][n + 1];
                //base case
                for (int j = n; j >= 0; j--) f[m][j] = n - j;
                for (int i = m; i >= 0; i--) f[i][n] = m - i;

                for (int i = m - 1; i >= 0; i--) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (s[i] == t[j])
                            f[i][j] = f[i + 1][j + 1];
                        else
                            f[i][j] = 1 + Math.min(Math.min(
                                    f[i + 1][j],
                                    f[i][j + 1]
                            ), f[i + 1][j + 1]);
                    }
                }
                return f[0][0];
            }
        }
    }
}
