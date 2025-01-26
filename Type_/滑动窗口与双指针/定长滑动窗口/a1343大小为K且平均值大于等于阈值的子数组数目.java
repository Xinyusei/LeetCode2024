package Type_.滑动窗口与双指针.定长滑动窗口;

/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 * https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
 */
public class a1343大小为K且平均值大于等于阈值的子数组数目 {
    class Solution {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int window = 0;
            for (int i = 0; i < k; i++)
                window += arr[i];
            int ans = window >= k * threshold ? 1 : 0;
            for (int hi = k; hi < arr.length; hi++) {
                window += arr[hi];
                window -= arr[hi - k];
                if (window >= k * threshold)
                    ans++;
            }
            return ans;
        }
    }
}
