package Type_.二分算法.二分查找;

public class a34在排序数组中查找元素的第一个和最后一个位置 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return new int[]{-1, -1};
            int[] ans = new int[2];
            ans[0] = leftBound(nums, target);
            ans[1] = rightBound(nums, target);
            return ans;
        }


        //大于等于target的最小索引 - 在有序数组中找到第一个大于等于target的元素索引。
        public int leftBound(int[] nums, int target) {
            int lo = 0, hi = nums.length;
            while (lo < hi) {
                int mid = ((hi - lo) >> 1) + lo;
                //[lo, mid) mid (mid + 1,hi)
                if (nums[mid] >= target)
                    //范围缩小到 [lo,mid)
                    hi = mid;
                else
                    //范围缩小到 [mid+1,hi)
                    lo = mid + 1;
            }
            if (lo == nums.length || nums[lo] != target)
                return -1;
            return lo;
        }

        //小于等于target的最大索引 - 在有序数组中找到小于等于目标值 (target) 的最大索引
        public int rightBound(int[] nums, int target) {
            int lo = 0, hi = nums.length;
            while (lo < hi) {
                int mid = ((hi - lo) >> 1) + lo;
                //[lo, mid) mid (mid + 1,hi)
                if (nums[mid] <= target)
                    //范围缩小到 [mid+1,hi)
                    lo = mid + 1;
                else
                    //范围缩小到[lo,mid)
                    hi = mid;
            }
            int idx = lo - 1;
            //这样想:在缩小区间的时候,mid = lo - 1
            if (idx == nums.length || idx < 0 || nums[idx] != target)
                return -1;
            return idx;
        }
    }
}
