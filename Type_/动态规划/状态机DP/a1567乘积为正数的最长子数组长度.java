package Type_.动态规划.状态机DP;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/18
 * @Description:
 */
public class a1567乘积为正数的最长子数组长度 {
    class Solution {
        public int getMaxLen(int[] nums) {
            int n = nums.length;
            //f1/f2[i] 表示前 i 个数中选取且以nums[i]结尾,乘积为正数/负数的子数组的最大长度
            int[] f1 = new int[n], f2 = new int[n];
            if (nums[0] > 0)
                f1[0] = 1;
            else if (nums[0] < 0)
                f2[0] = 1;
            int ans = f1[0];
            for (int i = 1; i < n; i++) {
                int v = nums[i];
                if (v > 0) {
                    f1[i] = f1[i - 1] + 1;
                    f2[i] = f2[i - 1] == 0 ? 0 : f2[i - 1] + 1;
                } else if (v < 0) {
                    f1[i] = f2[i - 1] == 0 ? 0 : f2[i - 1] + 1;
                    f2[i] = f1[i - 1] + 1;
                } else {
                    f1[i] = 0;
                    f2[i] = 0;
                }
                ans = Math.max(ans, f1[i]);
            }
            return ans;
        }
    }
}
