package Type_.动态规划.经典线性DP.二_最长递增子序列LIS;

/**
 * @Author: ZJX
 * @Date: 2024/12/07
 * @Description:
 */
public class a673最长递增子序列的个数 {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            int[] f = new int[n], g = new int[n];
            //f[i] 表示以nums[0~i]的子序列且以nums[i]结尾的最长递增子序列的长度
            //g[i] 为考虑以 nums[i] 结尾的最长递增子序列的个数。
            int mx = 1;
            for (int i = 0; i < n; i++) {
                f[i] = g[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        //满足 f[i]<f[j]+1：说明 f[i] 会被 f[j]+1 直接更新，此时同步直接更新 g[i]=g[j] 即可；

                        //相当于 第一次得到f[i]
                        if (f[i] < f[j] + 1) {
                            f[i] = f[j] + 1;
                            g[i] = g[j];

                        } else if (f[i] == f[j] + 1) {
                            //满足 f[i]=f[j]+1：说明找到了一个新的符合条件的前驱，此时将值继续累加到方案数当中，即有 g[i]+=g[j]。
                            //相当于 并非第一次得到f[i]
                            g[i] += g[j];
                        }
                    }
                }
                mx = Math.max(mx, f[i]);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (f[i] == mx)
                    ans += g[i];
            }
            return ans;
        }
    }
}
