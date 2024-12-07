package Type_.动态规划.经典线性DP.最长递增子序列LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 300. 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 * 2024-6-17
 */
public class a300最长递增子序列 {
    /**
     * 枚举选哪一个的做法
     */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            //f[i] 表示以nums[0~i]的子序列且以nums[i]结尾的最长递增子序列的长度
            Arrays.fill(f, 1);
            int ret = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j])
                        f[i] = Math.max(f[i], f[j] + 1);
                }
                ret = Math.max(ret, f[i]);
            }
            System.out.println(Arrays.toString(f));
            return ret;
        }
    }

    /**
     * 贪心 + 二分查找
     */
    class Solution2 {
        class Solution {
            public int lengthOfLIS(int[] nums) {
                //g[i] 的 定义为 : 长度为 i + 1 的 递增子序列的 末尾元素的最小值
                List<Integer> g = new ArrayList<>();
                for (int x : nums) {
                    int j = lowerBound(g, x);
                    if (j == g.size())
                        g.add(x);
                    else
                        g.set(j, x);
                }
                return g.size();
            }


            //大于等于 target 的最小元素下标
            private int lowerBound(List<Integer> g, int target) {
                int left = 0, right = g.size();
                while (left < right) {
                    int mid = (right - left) / 2 + left;
                    //[left,mid) mid [mid,right)
                    if (g.get(mid) >= target)
                        right = mid;
                    else
                        left = mid + 1;
                }
                return right;
            }
        }
    }


}
