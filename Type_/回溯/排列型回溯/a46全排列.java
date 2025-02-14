package Type_.回溯.排列型回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/14
 * @Description:
 */
public class a46全排列 {
    class S1 {
        class Solution {

            List<List<Integer>> res = new ArrayList<>();

            List<Integer> path = new ArrayList<>();
            boolean[] used;

            public List<List<Integer>> permute(int[] nums) {
                used = new boolean[nums.length];
                backtrack(nums);

                return res;
            }

            public void backtrack(int[] nums) {
                if (path.size() == nums.length) {
                    res.add(new ArrayList<>(path));
                    return;
                }

                for (int i = 0; i < nums.length; i++) {
                    if (used[i])
                        continue;
                    path.add(nums[i]);
                    used[i] = true;
                    backtrack(nums);
                    path.removeLast();
                    used[i] = false;
                }
            }
        }
    }
}
