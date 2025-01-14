package Hot100.堆;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: ZJX
 * @Date: 2024/11/28
 * @Description:
 */
public class a215数组中的第K个最大元素 {
    class Solution1 {
        //包超时的。 不如直接排序 + 选择
        public int findKthLargest(int[] nums, int k) {
            List<Integer> queue = new ArrayList<>();

            for (int v : nums) {
                if (queue.isEmpty() || queue.getLast() <= v)
                    queue.addLast(v);
                else {
                    List<Integer> tmp = new ArrayList<>();
                    while (!queue.isEmpty() && queue.getLast() > v) {
                        tmp.addLast(queue.removeLast());
                    }
                    tmp.addLast(v);
                    while (!tmp.isEmpty()) {
                        queue.addLast(tmp.removeLast());
                    }
                }
            }
            //System.out.println(queue);
            return queue.get(queue.size() - k);
        }
    }

    class Solution2 {
        static final Random r = new Random();
        int k;

        //快速排序的核心包括“哨兵划分” 和 “递归” 。

        //哨兵划分： 以数组某个元素（一般选取首元素）为基准数，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边。
        //递归： 对 左子数组 和 右子数组 递归执行 哨兵划分，直至子数组长度为 1 时终止递归，即可完成对整个数组的排序。

        //题目问「第 k 个最大的元素」，相当于数组升序排序后「排名第 n - k 的元素」，为了方便表述，后文另 k' = n - k。
        //快速排序的 partition 函数会将 nums[p] 排到正确的位置，使得 nums[lo..p-1] < nums[p] < nums[p+1..hi]：
        //这时候，虽然还没有把整个数组排好序，但我们已经让 nums[p] 左边的元素都比 nums[p] 小了，也就知道 nums[p] 的排名了。
        //那么我们可以把 p 和 k' 进行比较，如果 p < k' 说明第 k' 大的元素在 nums[p+1..hi] 中，如果 p > k' 说明第 k' 大的元素在 nums[lo..p-1] 中。
        public int findKthLargest(int[] nums, int k) {
            this.k = k;
            List<Integer> numList = new ArrayList<>(nums.length);
            for (int v : nums)
                numList.add(v);
            return quickSelect(numList, k);
        }

        private int quickSelect(List<Integer> nums, int k) {
            int pivot = nums.get(r.nextInt(nums.size()));
            // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
            List<Integer> big = new ArrayList<>(), equal = new ArrayList<>(), small = new ArrayList<>();
            for (Integer num : nums) {
                if (num > pivot) big.add(num);
                else if (num < pivot) small.add(num);
                else equal.add(num);
            }
            //如果第k大的元素在 big中,递归进行划分 - 比基准数大的元素有big.size个 如果big.size >= k 说明这个元素肯定落在big中
            if (big.size() >= k)
                return quickSelect(big, k);
                //1 2 3 4 4 5
                //2 1 3
            else if (k > nums.size() - small.size())
                return quickSelect(small, k + small.size() - nums.size());
            else return pivot;
        }
    }

    class Solution3 {
        static final Random r = new Random();
        int k;

        //题目问「第 k 个最大的元素」，相当于数组升序排序后「排名第 n - k 的元素」，为了方便表述，后文另 k' = n - k。
        //快速排序的 partition 函数会将 nums[p] 排到正确的位置，使得 nums[lo..p-1] < nums[p] < nums[p+1..hi]：
        //这时候，虽然还没有把整个数组排好序，但我们已经让 nums[p] 左边的元素都比 nums[p] 小了，也就知道 nums[p] 的排名了。
        //那么我们可以把 p 和 k' 进行比较，如果 p < k' 说明第 k' 大的元素在 nums[p+1..hi] 中，如果 p > k' 说明第 k' 大的元素在 nums[lo..p-1] 中。
        public int findKthLargest(int[] nums, int k) {
            this.k = k;
            int n = nums.length, idx = n - k, lo = 0, hi = n - 1;
            while (lo < hi) {
                int p = partition(nums, lo, hi);
                if (p == idx)
                    return nums[p];
                else if (p > idx) {
                    hi = p - 1;
                } else
                    lo = p + 1;
            }
            return nums[lo];
        }

        private int partition(int[] nums, int lo, int hi) {
            if (lo >= hi)
                return nums[lo];
            int pivotIdx = lo + r.nextInt(hi - lo + 1);
            swap(nums, lo, pivotIdx);
            int pivot = nums[lo];

            int left = lo, right = hi;
            //3 2 1 5 6 4 p = 5
            //4 2 1 3 5 6
            while (true) {
                while (left < right && nums[right] > pivot) right--;
                while (left < right && nums[left] <= pivot) left++;
                if (left >= right)
                    break;
                swap(nums, left, right);
            }
            swap(nums, lo, left);
            return left;
        }

        private void swap(int[] nums, int lo, int pivotIdx) {
            int t = nums[lo];
            nums[lo] = nums[pivotIdx];
            nums[pivotIdx] = t;
        }
    }
}
