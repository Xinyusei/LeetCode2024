package 代码随想录.动态规划.背包问题.零一背包;

/**
 * @Author: ZJX
 * @Date: 2024/10/28
 * @Description:
 */
public class a494目标和 {
    class Solution {
        public int findTargetSumWays(int[] nums, int t) {
            //x + y = sum;
            //x - y = t;
            //x = (sum + t) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int s = sum + t, n = nums.length;
            if (s < 0 || (s & 1) != 0)
                return 0;
            s >>= 1;
            int[][] f = new int[n + 1][s + 1];
            //base case
            //定义：f[i][w] 的定义如下：对于前 i 个数，恰为好满足和为w 的方案数为 f[i][w]。
            f[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= s; w++) {
                    //肯定不能选当前的数
                    if (w < nums[i - 1])
                        f[i][w] = f[i - 1][w];
                        //可以选,考虑两种情况，不选 / 选
                    else
                        f[i][w] = f[i - 1][w] + f[i - 1][w - nums[i - 1]];
                }
            }
            return f[n][s];
        }
    }
}
