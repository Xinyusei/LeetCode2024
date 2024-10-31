package 代码随想录.动态规划.背包问题.完全背包;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/10/31
 * @Description: <a href="https://leetcode.cn/problems/combination-sum-iv/description/">377组合总和Ⅳ</a>
 */
public class a377组合总和Ⅳ {
    class Solution1 {
        int[] memo;

        public int combinationSum4(int[] nums, int target) {
            this.memo = new int[target];
            Arrays.fill(memo, -1);
            return dfs(nums, target);
        }

        public int dfs(int[] nums, int target) {
            if (target == 0)
                return 1;
            if (memo[target] != -1)
                return memo[target];
            int result = 0;
            for (int num : nums) {
                if (target >= num)
                    result += dfs(nums, target - num);
            }
            return memo[target] = result;
        }
    }

    class Solution2 {
        //二维DP
        public int combinationSum4(int[] nums, int target) {

            //nums[i] 最小为1,所以len最长为target
            int len = target;
            int[][] f = new int[len + 1][target + 1];
            //f[i][j] 表示 组合长度为 i 其和为j 的元素组合的个数
            //base case
            f[0][0] = 1;
            int result = 0;
            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= target; j++) {
                    for (int num : nums) {
                        f[i][j] = f[i - 1][j];
                        if (j >= num)
                            f[i][j] += f[i - 1][j - num];
                    }
                }
                result += f[i][target];
            }
            return result;
        }
    }
    class Solution2_1{
        //一维
        public int combinationSum4(int[] nums, int target) {
            int[] f = new int[target + 1];
            //f[i] 表示 从 nums中凑成 其和为i 的元素组合的个数
            //f[i] 由 f[i - nums[j]] 推导出来的。
            //base case
            f[0] = 1;

            for (int i = 0; i <= target; i++) {
                for (int num : nums) {
                    if (i >= num)
                        f[i] += f[i - num];
                }
            }
            //System.out.println(Arrays.toString(f));
            return f[target];
        }
    }

}
