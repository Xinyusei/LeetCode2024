package Type_.动态规划.一_入门DP.最大子段和;

/**
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/description/
 */
public class a918环形子数组的最大和 {

    class S2 {
        class Solution {
            public int maxSubarraySumCircular(int[] nums) {
                int n = nums.length;
                //最大子数组和 ， 可以为空
                int maxCurr = Integer.MIN_VALUE;
                //最小子数组和 ， 可以为空
                int minCurr = 0;
                int maxPrev = 0, minPrev = 0, sum = 0;

                for (int x : nums) {
                    maxPrev = Math.max(0, maxPrev) + x;
                    maxCurr = Math.max(maxCurr, maxPrev);

                    minPrev = Math.min(0, minPrev) + x;
                    minCurr = Math.min(minCurr, minPrev);

                    sum += x;
                }
                return sum == minCurr ? maxCurr : Math.max(maxCurr, sum - minCurr);

            }
        }
    }

    class S1 {
        class Solution {
            public int maxSubarraySumCircular(int[] nums) {
                int n = nums.length;
                int[] fma = new int[n], fmi = new int[n];
                int ma = nums[0], mi = nums[0], sum = nums[0];

                for (int i = 1; i < n; i++) {
                    fma[i] = Math.max(0, fma[i - 1]) + nums[i];
                    ma = Math.max(ma, fma[i]);

                    fmi[i] = Math.min(0, fmi[i - 1]) + nums[i];
                    mi = Math.min(mi, fmi[i]);

                    sum += nums[i];
                }
                return sum == mi ? ma : Math.max(ma, sum - mi);

            }
        }
    }
}
