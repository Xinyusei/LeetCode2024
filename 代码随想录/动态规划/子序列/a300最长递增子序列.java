package 代码随想录.动态规划.子序列;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/11/17
 * @Description:
 */
public class a300最长递增子序列 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            //f[i] 表示 以nums[i]结尾的最长递增子序列长度
            Arrays.fill(f, 1);
            int ret = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j])
                        f[i] = Math.max(f[i], f[j] + 1);
                }
                ret = Math.max(f[i], ret);
            }
            System.out.println(Arrays.toString(f));
            return ret;
        }
    }
}
