package 代码随想录.动态规划.背包问题.零一背包;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/10/28
 * @Description:
 */
public class a416分割等和子集 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length, t = 0;
            for (int num : nums) {
                t += num;
            }
            if ((t & 1) == 1)
                return false;
            t >>= 1;
            boolean[][] f = new boolean[n + 1][t + 1];
            for (int i = 0; i <= n; i++)
                f[i][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= t; j++) {
                    if (j >= nums[i - 1])
                        f[i][j] = f[i - 1][j] || f[i - 1][j - nums[i - 1]];
                    else
                        f[i][j] = f[i - 1][j];
                }
            }
            //System.out.println(Arrays.deepToString(f));
            return f[n][t];
        }
    }
}
