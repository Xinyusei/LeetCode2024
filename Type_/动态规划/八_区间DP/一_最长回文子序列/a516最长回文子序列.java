package Type_.动态规划.八_区间DP.一_最长回文子序列;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2025/01/21
 * @Description:
 */
public class a516最长回文子序列 {
    /**
     * DFS + cache
     */
    class S1 {
        class Solution {
            private int[][] memo;

            public int longestPalindromeSubseq(String s) {
                int n = s.length();
                this.memo = new int[n][n];
                for (int[] row : memo) {
                    Arrays.fill(row, -1);
                }

                return dfs(s, 0, n - 1);
            }

            //dfs(s,i,j) 表示 从 s[lo] 到 s[hi] 的最长回文子序列的长度
            private int dfs(String s, int lo, int hi) {
                //base case dfs(i,i) = 1
                if (lo == hi)
                    return 1;
                if (lo > hi)
                    return 0;
                //遍历过
                if (memo[lo][hi] != -1)
                    return memo[lo][hi];

                if (s.charAt(lo) == s.charAt(hi)) {
                    memo[lo][hi] = dfs(s, lo + 1, hi - 1) + 2;
                } else
                    memo[lo][hi] = Math.max(dfs(s, lo + 1, hi), dfs(s, lo, hi - 1));
                return memo[lo][hi];
            }

        }
    }


    /**
     * DP TABLE - 优化
     */
    class S2_2 {
        class Solution {
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

    /**
     * DP TABLE - 未优化
     */
    class S2_1 {
        class Solution {
            public int longestPalindromeSubseq(String s) {
                int n = s.length();
                int[][] f = new int[n][n];

                //f[i][j] 表示 s[i] 到 s[j] 的最长回文子序列的长度
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = 0; j < n; j++) {
                        if (i == j)
                            f[i][j] = 1;
                        else if (i > j)
                            f[i][j] = 0;
                        else {
                            if (s.charAt(i) == s.charAt(j)) {
                                f[i][j] = f[i + 1][j - 1] + 2;
                            } else
                                f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                        }
                    }
                }
                return f[0][n - 1];
            }
        }
    }
}
