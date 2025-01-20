package Type_.动态规划.三_背包问题.一_零一背包;

/**
 * 494. 目标和
 * https://leetcode.cn/problems/target-sum/description/
 */
public class a494目标和 {
    class Solution {
        public int findTargetSumWays(int[] nums, int t) {
            //x , sum - x
            //x - sum + x = target
            //x = (sum + target) / 2
            int sum = 0;
            int n = nums.length;
            for (int num : nums)
                sum += num;
            int target = sum + t;
            if (target < 0 || target % 2 != 0)
                return 0;
            target >>= 1;
            //f[i][w] 表示从前 i 个数中选出几个数,其和为 w 的方法数
            int[][] f = new int[n + 1][target + 1];
            f[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= target; w++) {
                    //第i个数选：子问题变为从前i - 1个数中选出几个数,其和为w-nums[i - 1]的方法数
                    //第i个数不选:子问题变为从前i - 1个数中选出几个数,其和为w的方法数
                    if (w < nums[i - 1])
                        f[i][w] = f[i - 1][w];
                    else
                        f[i][w] = f[i - 1][w - nums[i - 1]] + f[i - 1][w];
                }
            }
            return f[n][target];
        }
    }
}
