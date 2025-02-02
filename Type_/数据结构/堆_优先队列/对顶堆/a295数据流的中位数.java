package Type_.数据结构.堆_优先队列.对顶堆;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ZJX
 * @Date: 2025/01/15
 * @Description:
 */
public class a295数据流的中位数 {

    class S1 {
        class MedianFinder {
            PriorityQueue<Integer> large;
            PriorityQueue<Integer> small;
            public MedianFinder() {
                //大顶堆 - 倒三角形
                small = new PriorityQueue<>(Comparator.reverseOrder());
                //小顶堆 - 梯形
                large = new PriorityQueue<>();
                //保证
                // 1、二者元素个数只差不超过1
                // 2、倒三角形-大顶堆的最大元素-peek 小于 梯形的-小顶堆的最小元素 - peek
            }
            public void addNum(int num) {
                if (small.size() >= large.size()) {
                    small.offer(num);
                    large.offer(small.poll());
                } else {
                    large.offer(num);
                    small.offer(large.poll());
                }
            }

            public double findMedian() {
                // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
                if (large.size() < small.size())
                    return small.peek();
                else if (large.size() > small.size())
                    return large.size();
                else
                    return 0.5 * (small.peek() + large.peek());
            }
        }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
    }
}
