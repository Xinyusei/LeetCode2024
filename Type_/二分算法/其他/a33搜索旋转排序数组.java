package Type_.二分算法.其他;

/**
 * @Author: ZJX
 * @Date: 2025/01/13
 * @Description:
 */
public class a33搜索旋转排序数组 {
    /**
     * 1. 先二分一次 找到旋转的点 再二分一次找target - ac
     */
    class S1 {
        class Solution {
            public int search(int[] nums, int target) {
                int lo = 0, hi = nums.length;
                //先找转折点
                while (lo < hi) {
                    int mid = ((hi - lo) >> 1) + lo;
                    if (nums[0] > nums[mid])
                        hi = mid;
                    else
                        lo = mid + 1;
                }
                int maxIdx = lo - 1;
                System.out.println("最大值为 = " + nums[maxIdx]);
                lo = 0;
                hi = nums.length;
                if (target >= nums[0])
                    hi = maxIdx + 1;
                else
                    lo = maxIdx + 1;
                while (lo < hi) {
                    int mid = ((hi - lo) >> 1) + lo;
                    if (nums[mid] == target)
                        return mid;
                    else if (nums[mid] > target)
                        hi = mid;
                    else
                        lo = mid + 1;
                }
                return -1;
            }
        }
    }

    /**
     * 不找旋转的点 根据条件在二分的时候判断 -todo
     */
    class S2 {
        class Solution {
            public int search(int[] nums, int target) {
                int lo = 0, hi = nums.length;
                while (lo < hi) {
                    int mid = ((hi - lo) >> 1) + lo, cur = nums[mid];
                    if (cur == target)
                        return mid;
                    //mid 指向前半部分
                    if (cur >= nums[0]) {
                        //如果此时 target也在上半且小于当前值
                        if (target >= nums[0] && cur > target) {
                            hi = mid;
                        } else
                            //1.target也在上半且大于当前值 2. target在下半
                            lo = mid + 1;
                        //mid 指向后半部分
                    } else {
                        //target 也在下半 且 大于当前值
                        if (target < nums[0] && cur < target) {
                            lo = mid + 1;
                        } else {
                            //1. target 也在下半 且 小于当前值 2.target在上半
                            hi = mid;
                        }
                    }
                }
                return -1;
            }
        }
    }
}
