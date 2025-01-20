package Type_.动态规划.三_背包问题.一_零一背包;

import java.util.Arrays;
import java.util.List;

/**
 * 2915. 和为目标值的最长子序列的长度
 * https://leetcode.cn/problems/length-of-the-longest-subsequence-that-sums-to-target/description/
 */
public class a2915和为目标值的最长子序列的长度 {
    /**
     * 1. 状态表示: dp[i][j] 表示考虑前i个元素, 并且当前和为j时, 此时子序列长度的最大值.如果前 i 个元素不能组成元素和等于 j 的子序列则 dp[i][j]= -1
     * 2. 状态转移方程: 对于第i个元素, 有选或不选两种选择.选: dp[i][j] = dp[i - 1][j - nums[i]] / 不选: dp[i][j] = dp[i - 1][j]
     * 然后上面两种情况取一个max即可
     * <p>
     * 3. 初始化: 添加一行的辅助节点, 第一行dp[0][0] 初始化为0, 其余位置都是非法, 初始化为负无穷大
     * 4. 填表顺序: 从上到下, 从左到右
     * 5. 返回值: return dp[n][target]
     */

    class Solution1 {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            int n = nums.size();
            int[][] f = new int[n + 1][target + 1];
            //当 i=0没有任何元素，子序列的元素和一定是 0，子序列的长度一定是 0，不存在元素和大于 0 的子序列，因此动态规划的边界情况是
            Arrays.fill(f[0], Integer.MIN_VALUE);
            f[0][0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= target; j++) {
                    int num = nums.get(i - 1);
                    if (j >= num)
                        f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - num] + 1);
                    else
                        f[i][j] = f[i - 1][j];
                }
            }
            return f[n][target] < 0 ? -1 : f[n][target];
        }
    }

    class Solution2 {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            int n = nums.size();
            int[] f = new int[target + 1];
            //当 i=0没有任何元素，子序列的元素和一定是 0，子序列的长度一定是 0，不存在元素和大于 0 的子序列，因此动态规划的边界情况是
            Arrays.fill(f, -1);
            f[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = target; j >= nums.get(i - 1); j--) {
                    f[j] = Math.max(f[j], f[j - nums.get(i - 1)] + 1);
                }
            }
            return f[target] < 0 ? -1 : f[target];
        }
    }


    class Solution3 {
        List<Integer> nums;
        int target;
        int[][] f;

        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            this.nums = nums;
            this.target = target;
            f = new int[nums.size() + 1][target + 1];
            for (int[] d : f) {
                Arrays.fill(d, -1);
            }
            int ans = dfs(nums.size() - 1,target);
            return ans < 0 ? -1 : ans;
        }

        private int dfs(int idx, int t) {
            if (t == 0)
                return 0;
            //不可能凑成
            if(idx < 0 || t < 0)
                return Integer.MIN_VALUE;
            //重复遍历
            if (f[idx][t] != Integer.MIN_VALUE)
                return f[idx][t];
            return f[idx][t] = Math.max(dfs(idx - 1, t - nums.get(idx)) + 1, dfs(idx - 1, t));
        }
    }
}
