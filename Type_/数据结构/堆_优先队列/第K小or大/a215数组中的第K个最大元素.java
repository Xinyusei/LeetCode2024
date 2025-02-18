package Type_.数据结构.堆_优先队列.第K小or大;

import java.util.ArrayList;
import java.util.List;
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
     * 快速选择 - 1
     */
    class S2_1 {
        class Solution {
            private final static Random r = new Random();

            public int findKthLargest(int[] nums, int k) {
                int targetIdx = nums.length - k;
                int lo = 0, hi = nums.length - 1;

                while (true) {
                    int partition = partition(nums, lo, hi);
                    if (partition == targetIdx)
                        return nums[partition];
                    else if (partition < targetIdx)
                        lo = partition + 1;
                    else
                        hi = partition - 1;
                }
            }

            //将数组划分为 <=pivot pivot >= pivot
            public int partition(int[] nums, int lo, int hi) {
                int idx = lo + r.nextInt(hi - lo + 1);
                swap(nums, idx, lo);
                int pivot = nums[lo];
                int le = lo + 1, ge = hi;


                while (true) {
                    while (ge >= le && nums[ge] >= pivot) ge--;
                    while (le <= ge && nums[le] <= pivot) le++;

                    if(le > ge)
                        break;
                    swap(nums, le, ge);
                    le++;
                    ge--;

                }
                swap(nums, lo, ge);
                return ge;
            }

            public void swap(int[] nums, int lo, int hi) {
                int temp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = temp;
            }


        }
    }

    /**
     * 快速选择 - 2
     */
    class S2_2 {
        class Solution {
            private final static Random r = new Random();

            public int findKthLargest(int[] nums, int k) {
                List<Integer> ls = new ArrayList<>();
                for (int num : nums) {
                    ls.add(num);
                }
                return doFindKthLargest(ls, k);
            }

            public int doFindKthLargest(List<Integer> nums, int k) {
                if (nums == null || nums.isEmpty())
                    return 0;
                int idx = r.nextInt(0, nums.size());
                int pivot = nums.get(idx);

                List<Integer> lt = new ArrayList<>();
                List<Integer> gt = new ArrayList<>();

                for (Integer num : nums) {
                    if (num > pivot)
                        gt.add(num);
                    else if (num < pivot)
                        lt.add(num);
                }

                //lt eq gt
                //3 2 3
                if (gt.size() >= k)
                    return doFindKthLargest(gt, k);
                else if (lt.size() + k > nums.size())
                    return doFindKthLargest(lt, lt.size() + k - nums.size());
                else
                    return pivot;
            }
        }
    }


}
