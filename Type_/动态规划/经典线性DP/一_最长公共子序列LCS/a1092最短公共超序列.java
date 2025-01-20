package Type_.动态规划.经典线性DP.一_最长公共子序列LCS;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/10
 * @Description:
 */
public class a1092最短公共超序列 {
    class Solution2 {
        class Solution {
            public String shortestCommonSupersequence(String str1, String str2) {
                int m = str1.length(), n = str2.length();
                str1 = " " + str1;
                str2 = " " + str2;
                char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
                int[][] f = new int[m + 10][n + 10];
                //s1[i]==s2[j] : f[i][j]=f[i−1][j−1]+1。代表必然使用 s1[i] 与 s2[j] 时 LCS 的长度。
                //s1[i]!=s2[j] : f[i][j]=max(f[i−1][j],f[i][j−1])。
                //分别代表必然不使用 s1[i]（但可能使用s2[j]）时 和 必然不使用 s2[j]（但可能使用s1[i]）时 LCS 的长度。
                for (int i = 1; i <= m; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (s1[i] == s2[j]) f[i][j] = f[i - 1][j - 1] + 1;
                        else f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    }
                }
                StringBuilder sb = new StringBuilder();
                int i = m, j = n;
                while (i > 0 || j > 0) {
                    if (i == 0) sb.append(s2[j--]);
                    else if (j == 0) sb.append(s1[i--]);
                    else {
                        if (s1[i] == s2[j]) {
                            sb.append(s1[i]);
                            i--;
                            j--;
                        } else if (f[i][j] == f[i - 1][j]) {
                            //说明这个s1[i]是特有的
                            sb.append(s1[i--]);
                        } else {
                            sb.append(s2[j--]);
                        }
                    }
                }
                return sb.reverse().toString();
            }
        }
    }

    class Solution {
        /**
         * 容易想到最终的方案必然是由三部分组成：两字符串的公共子序列（且必然是最长公共子序列）+ 两者特有的字符部分。 - 直接在原有字符串遍历
         * 超内存
         *
         * @param str1
         * @param str2
         * @return
         * @author ZJX
         * @date 2024/12/11
         */
        public String shortestCommonSupersequence(String str1, String str2) {
            int m = str1.length(), n = str2.length();
            //int[][] f = new int[m + 1][n + 1];
            String[][] f = new String[m + 1][n + 1];
            for (String[] s : f) {
                Arrays.fill(s, "");
            }
            for (int i = 1; i <= m; i++) {
                char c1 = str1.charAt(i - 1);
                for (int j = 1; j <= n; j++) {
                    char c2 = str2.charAt(j - 1);
                    if (c1 == c2)
                        f[i][j] = f[i - 1][j - 1] + c1;
                    else
                        f[i][j] = f[i - 1][j].length() >= f[i][j - 1].length() ? f[i - 1][j] : f[i][j - 1];
                }
            }
            StringBuilder ans = new StringBuilder();
            String lcs = f[m][n];
            int i = 0, j = 0;
            for (char ch : lcs.toCharArray()) {
                while (i < m && str1.charAt(i) != ch)
                    ans.append(str1.charAt(i++));
                while (j < n && str2.charAt(j) != ch)
                    ans.append(str2.charAt(j++));
                ans.append(ch);
                i++;
                j++;
            }
            //System.out.println(f[m][n]);
            return ans.append(str1.substring(i)).append(str2.substring(j)).toString();
        }
    }


}

