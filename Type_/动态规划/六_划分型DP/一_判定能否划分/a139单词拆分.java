package Type_.动态规划.六_划分型DP.一_判定能否划分;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2025/01/20
 * @Description:
 */
public class a139单词拆分 {

    /**
     * DP TABLE
     */
    class S2 {
        class Solution {
            public boolean wordBreak(String s, List<String> wordDict) {
                int n = s.length();
                boolean[] f = new boolean[n + 1];
                Set<String> record = new HashSet<>(wordDict);
                //base case
                f[0] = true;
                for (int i = 1; i <= n; i++) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (f[j] && record.contains(s.substring(j, i))) {
                            f[i] = true;
                            break;
                        }
                    }
                }
                return f[n];
            }
        }
    }

    /**
     * DFS + memo
     */
    class S1 {
        class Solution {
            // 记录wordDict的单词
            HashSet<String> record;
            //-1 未遍历 0 false 1 true
            HashMap<String, Integer> memo = new HashMap<>();

            public boolean wordBreak(String s, List<String> wordDict) {
                record = new HashSet<>(wordDict);

                return dfs(s, s.length());
            }

            private boolean dfs(String s, int end) {
                //base case
                if (end == 0)
                    return true;
                String sub = s.substring(end);

                //cache
                if (memo.containsKey(sub) && memo.get(sub) != -1)
                    return memo.get(sub) == 1;
                boolean res = false;
                for (int start = end - 1; start >= 0; start--) {
                    String ss = s.substring(start, end);
                    if (record.contains(ss)) {
                        res |= dfs(s, start);
                    }
                }
                memo.put(sub, res ? 1 : 0);
                return res;
            }
        }
    }

}
