package Type_.数据结构.堆.第K小or大;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: ZJX
 * @Date: 2025/01/14
 * @Description:
 */
public class a373查找和最小的K对数字 {
    class S1 {
        //
        class Solution {
            public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
                // 存储三元组 (num1[i], nums2[i], i)
                // i 记录 nums2 元素的索引位置，用于生成下一个节点
                PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[0] + o[1])));


                //就像 23. 合并 K 个升序链表 一样，将每个链表的头结点加入队列
                //1,2,0 -> 1,4,1 -> 1,6,2
                //7,2,0 -> 7,4,1 -> 7,6,1
                //11,2,0
                for (int j : nums1) {
                    pq.offer(new int[]{j, nums2[0], 0});
                }

                List<List<Integer>> res = new ArrayList<>();
                while (!pq.isEmpty() && k > 0) {
                    int[] cur = pq.poll();
                    k--;
                    int next_index = cur[2] + 1;
                    if (next_index < nums2.length) {
                        pq.add(new int[]{cur[0], nums2[next_index], next_index});
                    }

                    res.add(List.of(cur[0], cur[1]));
                }
                return res;
            }
        }
    }
}
