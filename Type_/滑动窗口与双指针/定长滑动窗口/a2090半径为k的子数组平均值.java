package Type_.滑动窗口与双指针.定长滑动窗口;

import java.util.Arrays;

/**
 * 2090. 半径为 k 的子数组平均值
 * <a href="https://leetcode.cn/problems/k-radius-subarray-averages/description/">...</a>
 */
public class a2090半径为k的子数组平均值 {
    class Solution {
        public int[] getAverages(int[] nums, int k) {
            int n = nums.length;
            int[] arr = new int[n];
            Arrays.fill(arr, -1);
            if(2 * k >= n)
                return arr;
            long avg = 0,num = k * 2L + 1;
            for (int i = 0; i < n && i <= 2 * k; i++) {
                avg += nums[i];
            }
            arr[k] = (int)(avg / num);
            for (int i = k + 1; i < n - k; i++) {
                avg += nums[i + k];
                avg -= nums[i - k - 1];
                arr[i] = (int)(avg / num);
            }
            return arr;
        }
    }
}
