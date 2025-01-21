package Type_.动态规划.四_经典线性DP.一_最长公共子序列LCS;

import java.util.Arrays;

/**
 * 97. 交错字符串
 * https://leetcode.cn/problems/interleaving-string/description/
 */
public class a97交错字符串 {


    /**
     * DP TABLE
     * 定义 f[i][j] 为使用 s1 的前 i 个字符，使用 s2 的前 j 个字符，能否凑出 s3 的前 i+j 个字符。
     */
    class S1_1 {
        class Solution {
            public boolean isInterleave(String s1, String s2, String s3) {
                int m = s1.length(), n = s2.length(), t = s3.length();
                // 如果长度对不上，必然不可能
                if (m + n != t)
                    return false;
                boolean[][] f = new boolean[m + 1][n + 1];
                // f[i][j] 为使用 s1 的前 i 个字符，使用 s2 的前 j 个字符，能否凑出 s3 的前 i+j 个字符。
                //base case
                f[0][0] = true;
                for (int i = 1; i <= m && f[i - 1][0]; i++)
                    f[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
                for (int j = 1; j <= n && f[0][j - 1]; j++)
                    f[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);
                //遍历
                for (int i = 1; i <= m; i++) {
                    for (int j = 1; j <= n; j++) {
                        int k = i + j - 1;
                        if (s1.charAt(i - 1) == s3.charAt(k))
                            f[i][j] |= f[i - 1][j];
                        if (s2.charAt(j - 1) == s3.charAt(k))
                            f[i][j] |= f[i][j - 1];
                    }
                }
                return f[m][n];
            }
        }
    }

    //DFS + cache
    //dfs(i,j) 表示 s1[i...m - 1] s2[j...n - 1] 是否能交错 组成 s3[i + j - 1 ... m + n - 1]
    class S2_1 {
        class Solution {
            int[][] memo;

            public boolean isInterleave(String s1, String s2, String s3) {

                int m = s1.length(), n = s2.length(), t = s3.length();
                // 如果长度对不上，必然不可能
                if (m + n != t)
                    return false;

                memo = new int[m + 1][n + 1];
                //-1 未遍历 ， 1 true 0 false
                for (int[] row : memo) {
                    Arrays.fill(row, -1);
                }

                return dfs(s1, 0, s2, 0, s3);
            }

            //dfs(i,j) 表示 s1[i...m - 1] s2[j...n - 1] 是否能交错 组成 s3[i + j - 1 ... m + n - 1]
            private boolean dfs(String s1, int i, String s2, int j, String s3) {
                int k = i + j;
                // base case，s3 构造完成
                if (k == s3.length())
                    return true;
                // 查备忘录，如果已经计算过，直接返回
                if (memo[i][j] != -1)
                    return memo[i][j] == 1;

                boolean res = false;
                // 如果，s1[i] 可以匹配 s3[k]，那么填入 s1[i] 试一下
                if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
                    res = dfs(s1, i + 1, s2, j, s3);

                // 如果，s1[i] 匹配不了，s2[j] 可以匹配，那么填入 s2[j] 试一下
                if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
                    res = res || dfs(s1, i, s2, j + 1, s3);
                // 如果 s1[i] 和 s2[j] 都匹配不了，则返回 false
                // 将结果存入备忘录
                memo[i][j] = res ? 1 : 0;
                return res;

            }
        }
    }

    //DFS + cache
    // dfs(i,j) 表示 s1[0...i-1] s2[0...j-1] 是否能交错 组成 s3[0....i+j-1]
    class S2_2 {
        class Solution {
            Boolean[][] memo;

            public boolean isInterleave(String s1, String s2, String s3) {
                int m = s1.length(), n = s2.length(), t = s3.length();
                // 如果长度对不上，必然不可能
                if (m + n != t)
                    return false;

                memo = new Boolean[m + 1][n + 1];

                return dfs(s1, m, s2, n, s3);
            }

            // dfs(i,j) 表示 s1[0...i-1] s2[0...j-1] 是否能交错 组成 s3[0....i+j-1]
            private boolean dfs(String s1, int i, String s2, int j, String s3) {
                // base case
                if (i == 0 && j == 0)
                    return true;
                else if (i == 0)
                    return s2.substring(0, j).equals(s3.substring(0, j));
                else if (j == 0)
                    return s1.substring(0, i).equals(s3.substring(0, i));

                // 查备忘录，如果已经计算过，直接返回
                if (memo[i][j] != null)
                    return memo[i][j];

                boolean res = false;
                int k = i + j - 1; // 计算当前 s3 的索引

                // 如果，s1[i-1] 可以匹配 s3[k]，那么填入 s1[i-1] 试一下
                if (s1.charAt(i - 1) == s3.charAt(k)) {
                    res = dfs(s1, i - 1, s2, j, s3);
                }

                // 如果，s1[i-1] 匹配不了，s2[j-1] 可以匹配，那么填入 s2[j-1] 试一下
                if (!res && s2.charAt(j - 1) == s3.charAt(k)) {
                    res = dfs(s1, i, s2, j - 1, s3);
                }
                // 将结果存入备忘录
                memo[i][j] = res;
                return res;
            }
        }


    }
}
