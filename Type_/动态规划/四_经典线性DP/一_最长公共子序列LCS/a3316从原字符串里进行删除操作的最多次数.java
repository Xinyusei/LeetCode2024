package Type_.动态规划.四_经典线性DP.一_最长公共子序列LCS;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/12/11
 * @Description:
 */
public class a3316从原字符串里进行删除操作的最多次数 {
    class Solution2 {
        class Solution {
            public int maxRemovals(String source, String pattern, int[] targetIndices) {
                int m = source.length(), n = pattern.length();
                char[] s = source.toCharArray(), p = pattern.toCharArray();
                Set<Integer> targetSet = new HashSet<>();
                for (int i : targetIndices) {
                    targetSet.add(i);
                }
                //定义 : f[i][j] 表示要使 pattern[0] 到 pattern[j - 1] 是 source[0] 到 source[i - 1] 的子序列，最多可以进行的删除操作的次数。
                int[][] f = new int[m + 1][n + 1];

                for (int[] row : f) {
                    Arrays.fill(row, -1);
                }
                //
                //如果当前s[i - 1] == p[j - 1] 则可以选择要 此时的 f[i][j] = max(f[i][j], f[i - 1][j - 1])
                f[0][0] = 0;
                for (int i = 1; i <= m; i++) {
                    for (int j = 0; j <= n; j++) {
                        // 1 直接不要 source[i] 则 source[..i] 与 pattern[..j] 去匹配
                        // 如果 i 在删除下标的集合中 则操作次数加 1
                        f[i][j] = f[i - 1][j] + (targetSet.contains(i - 1) ? 1 : 0);
                        // 2 当前 source[i] 与 pattern[j] 相等 则可以选择要当前字符
                        // 此时的 f[i][j] = max(f[i][j], f[i - 1][j - 1])
                        if (j > 0 && s[i - 1] == p[j - 1])
                            f[i][j] = Math.max(f[i][j], f[i - 1][j - 1]);
                    }
                }
                return f[m][n];
            }
        }
    }

    class Solution1 {
        public int maxRemovals(String source, String pattern, int[] targetIndices) {
            //其实就是找 source中 除了和pattern的LCS外的 独有的字符
            int m = source.length(), n = pattern.length();
            source = " " + source;
            pattern = " " + pattern;
            int[][] f = new int[m + 10][n + 10];
            char[] s = source.toCharArray(), p = pattern.toCharArray();
            for (int i = 1; i <= m; i++) {
                char c1 = s[i];
                for (int j = 1; j <= n; j++) {
                    char c2 = p[j];
                    if (c1 == c2)
                        f[i][j] = f[i - 1][j - 1] + 1;
                    else
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
            //abc
            //acb
            System.out.println(f[m][n]);
            HashSet<Integer> sOnly = new HashSet<>(), pOnly = new HashSet<>();
            int i = m, j = n;
            while (i > 0 || j > 0) {
                if (i == 0) pOnly.add(j--);
                if (j == 0) sOnly.add(i--);
                if (s[i] == p[j]) {
                    i--;
                    j--;
                } else if (f[i][j] == f[i - 1][j]) {
                    sOnly.add(i - 1);
                    i--;
                } else {
                    pOnly.add(j - 1);
                    j--;
                }
            }
            int res = 0;
            for (int targetIndex : targetIndices) {
                if (sOnly.contains(targetIndex))
                    res++;
            }
            return res;
        }
    }
}
