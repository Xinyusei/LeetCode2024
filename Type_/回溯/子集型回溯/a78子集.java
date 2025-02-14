package Type_.回溯.子集型回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/14
 * @Description:
 */
public class a78子集 {
    class S1 {
        class Solution {
            List<Integer> path;

            List<List<Integer>> res;

            public List<List<Integer>> subsets(int[] nums) {
                path = new ArrayList<>();
                res = new ArrayList<>();

                backtrack(nums, 0);

                return res;
            }

            public void backtrack(int[] nums, int idx) {
                //节点
                res.add(new ArrayList<>(path));

                for (int i = idx; i < nums.length; i++) {
                    //选择 - 树枝
                    path.add(nums[i]);
                    backtrack(nums, i + 1);
                    //撤销选择 -
                    path.removeLast();
                }
            }
        }
    }
}
