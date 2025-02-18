package Type_.数据结构.堆_优先队列.第K小or大;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: ZJX
 * @Date: 2025/02/18
 * @Description:
 */
public class a347前K个高频元素 {
    class S1 {
        class Solution {
            public int[] topKFrequent(int[] nums, int k) {
                Map<Integer, Integer> keyToCnt = new HashMap<>();
                for (int x : nums) {
                    keyToCnt.merge(x, 1, Integer::sum);
                }
                //1:3,2:2,3:1
                PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(keyToCnt::get));

                for (Map.Entry<Integer, Integer> e : keyToCnt.entrySet()) {
                    pq.add(e.getKey());
                    if (pq.size() > k)
                        pq.poll();
                }
                int[] res = new int[k];
                for (int i = 0; i < k; i++) {
                    res[i] = pq.poll();
                }
                return res;
            }
        }
    }

    //基于快速排序的思想
    class S2{

    }
}
