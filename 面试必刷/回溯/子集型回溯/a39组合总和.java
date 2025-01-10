package 面试必刷.回溯.子集型回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/09
 * @Description:
 */
public class a39组合总和 {
    class S1 {
        class Solution {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            int sum = 0;
            int target;


            public List<List<Integer>> combinationSum(int[] candidates, int target) {
                this.target = target;

                dfs(candidates, 0);

                return res;
            }

            private void dfs(int[] candidates, int idx) {
                if (sum == target) {
                    res.add(new ArrayList<>(path));
                    return;
                }

                for (int i = idx; i < candidates.length; i++) {
                    int v = candidates[i];
                    if (v + sum > target)
                        continue;
                    sum += v;
                    path.add(v);
                    dfs(candidates, i);

                    sum -= v;
                    path.removeLast();
                }
            }


        }
    }
}
