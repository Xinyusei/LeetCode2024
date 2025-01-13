package Type_.二分算法.其他;

/**
 * @Author: ZJX
 * @Date: 2025/01/13
 * @Description:
 */
public class a153寻找旋转排序数组中的最小值 {
    class S1 {
        class Solution {
            public int findMin(int[] nums) {
                int lo = 0, hi = nums.length;
                while (lo < hi) {
                    //找最大值
                    int mid = ((hi - lo) >> 1) + lo, cur = nums[mid];
                    if (nums[0] <= cur)
                        lo = mid + 1;
                    else
                        hi = mid;
                }
                return nums[(lo + 1) % nums.length];
            }
        }
    }
}
