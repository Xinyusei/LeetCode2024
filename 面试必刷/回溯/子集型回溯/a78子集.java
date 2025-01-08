package 面试必刷.回溯.子集型回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/08
 * @Description:
 */
public class a78子集 {
    /**
     * 答案的视角 - 枚举选哪个
     */
    class S1 {
        class Solution {
            private final List<Integer> path = new ArrayList<>();

            private final List<List<Integer>> res = new ArrayList<>();

            public List<List<Integer>> subsets(int[] nums) {
                backtrack(nums, 0);
                return res;
            }

            public void backtrack(int[] nums, int idx) {
                res.add(new ArrayList<>(path)); // 复制 path

                for (int i = idx; i < nums.length; i++) { // 枚举选择的数字
                    path.addLast(nums[i]);
                    backtrack(nums, i + 1);
                    path.removeLast(); // 恢复现场
                }
            }
        }
    }


    /**
     * 输入的视角（选或不选）
     */
    class S2 {
        class Solution {
            private final List<List<Integer>> ans = new ArrayList<>();
            private final List<Integer> path = new ArrayList<>();
            private int[] nums;

            public List<List<Integer>> subsets(int[] nums) {
                this.nums = nums;
                dfs(0);
                return ans;
            }

            private void dfs(int idx) {
                if (idx == nums.length) {
                    ans.add(new ArrayList<>(path));
                    return;
                }

                dfs(idx + 1); //不选

                //选
                path.add(nums[idx]);
                dfs(idx + 1);
                path.removeLast(); //恢复现场

            }
        }
    }
}
