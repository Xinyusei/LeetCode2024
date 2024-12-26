package 面试150;

/**
 * @Author: ZJX
 * @Date: 2024/12/26
 * @Description:
 */
public class a392判断子序列 {
    /**
     * 贪心 + 双指针
     */
    class S3 {
        class Solution {
            public boolean isSubsequence(String s, String t) {
                int m = s.length(), n = t.length();
                int i = 0, j = 0;
                while (i < m && j < n) {
                    if (s.charAt(i) == t.charAt(j))
                        i++;
                    j++;
                }
                return i == m;
            }
        }
    }

    /**
     * 朴素 DP
     */
    class S1 {
        class Solution {
            public boolean isSubsequence(String s, String t) {
                int m = s.length(), n = t.length();
                boolean[][] f = new boolean[m + 1][n + 1];
                for (int i = 0, j = 0; j <= n; j++)
                    f[i][j] = true;
                for (int i = 1; i <= m; i++) {
                    char c1 = s.charAt(i - 1);
                    for (int j = 1; j <= n; j++) {
                        char c2 = t.charAt(j - 1);
                        if (c1 == c2)
                            f[i][j] |= f[i - 1][j - 1];
                        else
                            f[i][j] |= f[i][j - 1];
                    }
                }
                return f[m][n];
            }
        }
    }

    /**
     * 第二种DP思路-预处理记录信息
     * 希望能够找到距离最近的下一个匹配字符的位置，跳过中间不匹配字符的匹配
     */
    class S2 {
        class Solution {
            public boolean isSubsequence(String s, String t) {
                //f[i][j] 表示 字符串 t 中从位置 i 开始往后 字符j 第一次出现的位置
                int n = t.length();
                int[][] f = new int[n + 1][26];
                if (t.isEmpty())
                    return s.isEmpty();
                for (int j = 0; j < 26; j++)
                    f[n][j] = n;
                for (int i = n - 1; i >= 0; i--) {
                    char c = t.charAt(i);
                    for (int ch = 0; ch < 26; ch++) {
                        if (c == ch + 'a')
                            f[i][ch] = i; //i为字符本身,首次出现的位置就是i
                        else
                            f[i][ch] = f[i + 1][ch]; //其他字符跟随后一位的信息

                    }
                    int idx = 0; //t的匹配起点，初始为0
                    for (char ch : s.toCharArray()) {
                        int k = ch - 'a'; //获取当前字符的编号
                        if (f[idx][k] == n)
                            return false; //s的当前字符在t中找不到待匹配的字符，匹配失败
                        idx = f[idx][k] + 1; //更新编号
                    }
                }
                return true;
            }
        }
    }
}
