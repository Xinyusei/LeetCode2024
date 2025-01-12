package Type_.二分算法.二分查找;

/**
 * @Author: ZJX
 * @Date: 2025/01/12
 * @Description:
 */
public class a35搜索插入位置 {
    class S1 {
        class Solution {
            public int searchInsert(int[] nums, int target) {
                int lo = 0, hi = nums.length;
                while (lo < hi) {
                    int mid = ((hi - lo) >> 1) + lo;
                    //(lo,mid) mid [mid+1,hi)
                    if (nums[mid] < target)
                        lo = mid + 1;
                    else
                        hi = mid;
                }
                return lo;
            }
        }
    }
}
