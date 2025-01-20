package Type_.动态规划.三_背包问题.一_零一背包;

/**
 * 416. 分割等和子集
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class a416分割等和子集 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0, n = nums.length;
            for (int num : nums)
                sum += num;
            if ((sum & 1) != 0)
                return false;
            int target = sum >> 1;
            //是否可以从输入数组中挑选出一些正整数，使得这些数的和 等于 整个数组元素的和的一半。
            boolean[][] f = new boolean[n + 1][target + 1];
            //f[i][j] 表示 : 从nums数组的[0,i]这个区间挑选一些正整数,每个数选/不选,使得这些数的和恰好等于j

            //base case
            for (int i = 0; i <= n; i++)
                f[i][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= target; j++) {
                    if (nums[i - 1] <= j) {
                        f[i][j] = f[i - 1][j - nums[i - 1]] || f[i - 1][j];
                    } else
                        f[i][j] = f[i - 1][j];
                }
            }
            return f[n][target];
        }
    }
}
