package Type_.动态规划.经典线性DP.二_最长递增子序列LIS;

import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/07
 * @Description:
 */
public class a2826将三个组排序 {
    class Solution {
        public int minimumOperations(List<Integer> nums) {
            //找到最长非递减序列长度
            int n = nums.size();
            int[] f = new int[n];
            //f[i] 表示 以 nums[i] 结尾的 非递减序列的 最大值
            f[0] = 1;
            int l = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    f[i] = Math.max(f[i], 1 + (nums.get(i) >= nums.get(j) ? f[j] : 0));
                }
                l = Math.max(l, f[i]);
            }
            return n - l;
        }
    }
}
