package Type_.滑动窗口与双指针.定长滑动窗口;

/**
 * 643. 子数组最大平均数 I
 * https://leetcode.cn/problems/maximum-average-subarray-i/
 */
public class a643子数组最大平均数1 {
    public double findMaxAverage(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += nums[i];
        }
        //a1 a2 a3 a4
        //a2 a3 a4 a5
        for (int left = 1, right = k,cur = ans; right < nums.length; right++, left++) {
            cur -= nums[left - 1];
            cur += nums[right];
            if(ans < cur)
                ans = cur;
        }
        return 1.0 * ans / k;
    }
}
