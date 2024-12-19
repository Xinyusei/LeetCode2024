package Type_.动态规划.状态机DP;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/18
 * @Description:
 */
public class a2708一个小组的最大实力值 {
    class Solution {
        public long maxStrength(int[] nums) {
            int n = nums.length;
            //fmax[i] 表示遍历到 nums[i] 的时候可以取到的 最大 实力值
            //fmin[i] 表示遍历到 nums[i] 的时候可以取到的 最小 实力值
            long[] fmax = new long[n], fmin = new long[n];
            long ans = fmax[0] = fmin[0] = nums[0];
            for (int i = 1; i < n; i++) {
                long v = nums[i];
                long mx = fmax[i - 1] * v;
                long mn = fmin[i - 1] * v;
                fmax[i] = Math.max(Math.max(v, fmax[i - 1]), Math.max(mx, mn));
                fmin[i] = Math.min(Math.min(v, fmin[i - 1]), Math.min(mx, mn));
                ans = Math.max(ans, fmax[i]);
            }
            System.out.println("fmax = " + Arrays.toString(fmax));
            System.out.println("fmin = " + Arrays.toString(fmin));
            return ans;
        }
    }
}
