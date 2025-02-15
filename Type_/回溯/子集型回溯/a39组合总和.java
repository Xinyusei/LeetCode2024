package Type_.回溯.子集型回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/15
 * @Description:
 */
public class a39组合总和 {
    class S1 {
        class Solution {
            private List<Integer> path;

            private List<List<Integer>> res;

            private int target;

            private int pathSum;

            public List<List<Integer>> combinationSum(int[] candidates, int target) {
                this.path = new ArrayList<>();
                this.res = new ArrayList<>();
                this.target = target;
                this.pathSum = 0;
                Arrays.sort(candidates);
                backtrack(candidates, 0);
                return res;
            }

            private void backtrack(int[] nums, int idx) {
                if (idx == nums.length || nums[idx] > target || pathSum > target)
                    return;
                if (pathSum == target) {
                    res.add(new ArrayList<>(path));
                    return;
                }

                for (int curIdx = idx; curIdx < nums.length; curIdx++) {
                    int v = nums[curIdx];
                    path.add(v);
                    pathSum += v;
                    backtrack(nums, curIdx);
                    pathSum -= v;
                    path.removeLast();
                }
            }

        }
    }
}
