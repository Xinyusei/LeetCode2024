package Type_.二分算法.其他;

/**
 * @Author: ZJX
 * @Date: 2025/01/13
 * @Description:
 */
public class a162寻找峰值 {
    class S1 {
        class Solution {
            public int findPeakElement(int[] nums) {
                if (nums.length == 1)
                    return 0;
                int lo = 0, hi = nums.length;
                while (lo < hi) {
                    int mid = (hi - lo) / 2 + lo ;
                    // 此时 mid 可能不为峰值,mid + 1有可能为峰值
                    if (mid + 1 < nums.length && nums[mid] < nums[mid + 1])
                        lo = mid + 1;
                    else
                        //要么 mid为峰值，要么mid左侧存在峰值
                        hi = mid;
                }
                return lo;
            }
        }
    }
}
