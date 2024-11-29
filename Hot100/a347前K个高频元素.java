package Hot100;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/11/29
 * @Description:
 */
public class a347前K个高频元素 {
    class Solution1 {
        /**
         * 基于优先队列/堆来
         *
         * @param nums
         * @param k
         * @return
         * @author ZJX
         * @date 2024/11/29
         */
        //3,1 2,2 1,3
        public int[] topKFrequent(int[] nums, int k) {
            int n = nums.length;
            Map<Integer, Integer> valToFreq = new HashMap<>();
            //计数
            for (int v : nums) {
                valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
            }
            Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
            // 队列按照键值对中的值（元素出现频率）从小到大排序
            for (Map.Entry<Integer, Integer> e : valToFreq.entrySet()) {
                pq.offer(e);

                if (pq.size() > k)
                    pq.poll();
            }
            int[] res = new int[pq.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = pq.remove().getKey();
            }
            return res;
        }
    }

    class Solution2 {
        public int[] topKFrequent(int[] nums, int k) {
            int n = nums.length;
            Map<Integer, Integer> valToFreq = new HashMap<>();
            //计数
            for (int v : nums) {
                valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
            }
            int[] res = new int[valToFreq.size()];
            int index = 0;
            for (Map.Entry<Integer, Integer> e : valToFreq.entrySet()) res[index++] = e.getKey();

            //System.out.println(Arrays.toString(res));
            int lo = 0, hi = res.length - 1, idx = res.length - k;
            while (lo <= hi) {
                //p = 2 > 1
                int p = partition(res, lo, hi, valToFreq);
                //这一轮划分结束的数落在索引 p 上
                //左边全是频次小于等于p的，右边全是大于p的
                if (p == idx)
                    return Arrays.copyOfRange(res, p, res.length);
                else if (p > idx)
                    hi = p - 1;
                else
                    lo = p + 1;
            }
            //1 2 3
            return null;
        }

        private int partition(int[] nums, int lo, int hi, Map<Integer, Integer> valToFreq) {
            if (lo >= hi)
                return lo;
            int pivot = nums[lo];
            int left = lo, right = hi;

            while (left < right) {
                while (left < right && valToFreq.get(nums[right]) > valToFreq.get(pivot)) right--;
                if (left < right) nums[left] = nums[right];
                while (left < right && valToFreq.get(nums[left]) <= valToFreq.get(pivot)) left++;
                if (left < right) nums[right] = nums[left];

            }
            nums[left] = pivot;
            //System.out.println("pivot = " + pivot);
            //System.out.println("left = " + left);
            //System.out.println("nums = " + Arrays.toString(nums));
            return left;
        }
    }
}
