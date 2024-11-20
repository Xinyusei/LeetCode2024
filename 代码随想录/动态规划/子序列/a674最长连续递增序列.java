package 代码随想录.动态规划.子序列;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/11/17
 * @Description:
 */
public class a674最长连续递增序列 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            //f[i] 表示 以nums[i]结尾的最长递增子序列长度
            f[0] = 1;
            int ret = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1])
                    f[i] = Math.max(f[i], f[i - 1] + 1);
                else
                    f[i] = 1;
                ret = Math.max(f[i], ret);
            }
            //System.out.println(Arrays.toString(f));
            return ret;
        }
    }
}
