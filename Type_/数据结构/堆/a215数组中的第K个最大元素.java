package Type_.数据结构.堆;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author: ZJX
 * @Date: 2025/01/14
 * @Description:
 */
public class a215数组中的第K个最大元素 {
    /**
     * 堆
     */
    class S1 {
        class Solution {
            public int findKthLargest(int[] nums, int k) {
                //创建小顶堆
                PriorityQueue<Integer> pq = new PriorityQueue<>(k);
                for (int pivot : nums) {
                    if (pq.size() < k)
                        pq.offer(pivot);
                    else if (pivot > pq.peek()) {
                        pq.poll();
                        pq.offer(pivot);
                    }
                }
                return pq.peek();
            }
        }
    }


    /**
     * 快速选择
     */
    class S2 {

        class Solution {
            private final static Random random = new Random(System.currentTimeMillis());

            public int findKthLargest(int[] nums, int k) {
                int n = nums.length;
                int targetIdx = n - k;

                int lo = 0;
                int hi = nums.length - 1;
                while (true) {
                    int pivotIdx = partition(nums, lo, hi);
                    if (pivotIdx == targetIdx)
                        return nums[pivotIdx];
                    else if (pivotIdx < targetIdx)
                        lo = pivotIdx + 1;
                    else
                        hi = pivotIdx - 1;
                }
            }

            //对 nums[lo..hi] 进行切分
            private int partition(int[] nums, int l, int r) {
                int randomIdx = l + random.nextInt(r - l + 1);
                swap(nums, randomIdx, l);

                int pivot = nums[l], le = l + 1, ge = r;

                while (true) {
                    while (ge >= le && nums[ge] >= pivot) ge--;
                    while (le <= ge && nums[le] <= pivot) le++;

                    if (le > ge)
                        break;
                    swap(nums, le, ge);
                    ge--;
                    le++;
                }
                swap(nums, l, ge);

                return ge;
            }

            private void swap(int[] nums, int left, int right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }
}
