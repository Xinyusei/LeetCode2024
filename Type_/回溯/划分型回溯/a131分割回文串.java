package Type_.回溯.划分型回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/16
 * @Description:
 */
public class a131分割回文串 {
    class S1 {
        class Solution {
            List<List<String>> res;
            List<String> path;

            public List<List<String>> partition(String s) {
                this.res = new ArrayList<>();
                this.path = new ArrayList<>();

                backtrack(s, 0);
                return res;
            }

            private void backtrack(String s, int startIdx) {
                if (startIdx == s.length()) {
                    res.add(new ArrayList<>(path));
                    return;
                }

                for (int curIdx = startIdx; curIdx < s.length(); curIdx++) {
                    String sub = s.substring(startIdx, curIdx + 1);
                    if(!check(sub))
                        continue;
                    path.add(sub);
                    backtrack(s,curIdx + 1);
                    path.removeLast();

                }

            }

            private boolean check(String t) {
                int lo = 0, hi = t.length() - 1;
                while (lo < hi) {
                    if (t.charAt(lo) != t.charAt(hi))
                        return false;
                    lo++;
                    hi--;
                }
                return true;
            }
        }
    }
}
