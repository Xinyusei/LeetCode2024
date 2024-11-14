package 代码随想录.动态规划.背包问题.完全背包;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/14
 * @Description:
 */
public class a139单词拆分 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] f = new boolean[n + 1];
            Arrays.fill(f, false);
            f[0] = true;

            for (int i = 1; i <= n; i++) {
                for (String sub : wordDict) {
                    int m = sub.length();
                    if (i < m)
                        continue;
                    String cur = s.substring(i - m, i);
                    if (cur.equals(sub))
                        f[i] = f[i] || f[i - m];
                }
            }
            return f[n];
        }
    }
}
