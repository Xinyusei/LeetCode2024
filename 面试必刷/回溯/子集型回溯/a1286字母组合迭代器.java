package 面试必刷.回溯.子集型回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/08
 * @Description:
 */
public class a1286字母组合迭代器 {
    class S1 {
        class CombinationIterator {
            private final List<String> res = new ArrayList<>();
            private final StringBuilder path = new StringBuilder();
            int len;
            private int curIdx = 0;

            public CombinationIterator(String characters, int combinationLength) {
                this.len = combinationLength;

                dfs(characters, 0);

                System.out.println("res = " + res);
            }

            private void dfs(String cs, int startIndex) {
                if (path.length() == len) {
                    res.add(path.toString());
                    return;
                }

                for (int i = startIndex; i < cs.length(); i++) {
                    path.append(cs.charAt(i));
                    dfs(cs, i + 1);
                    path.deleteCharAt(path.length() - 1);
                }

            }

            public String next() {
                return res.get(curIdx++);
            }

            public boolean hasNext() {
                return curIdx != res.size();
            }
        }

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
    }
}
