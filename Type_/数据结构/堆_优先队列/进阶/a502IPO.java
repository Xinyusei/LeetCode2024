package Type_.数据结构.堆_优先队列.进阶;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ZJX
 * @Date: 2025/01/14
 * @Description:
 */
public class a502IPO {
    class S1 {
        class Solution {
            public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
                int n = profits.length;
                int[][] pair = new int[n][2];
                for (int i = 0; i < n; i++) {
                    pair[i][0] = capital[i];
                    pair[i][1] = profits[i];
                }
                Arrays.sort(pair, Comparator.comparingInt(o -> o[0]));
                PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                //[0,1] [1,2] [1,3]
                int i = 0;
                while (k > 0) {
                    while (i < n && pair[i][0] <= w) {
                        pq.offer(pair[i][1]);
                        i++;
                        k--;
                    }
                    if(pq.isEmpty())
                        break;
                    w += pq.poll();
                }
                return w;
            }
        }
    }
}
