package Hot100.堆;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: ZJX
 * @Date: 2024/11/29
 * @Description:
 */
public class a295数据流的中位数 {
    class MedianFinder {
        final Queue<Integer> l;
        final Queue<Integer> r;

        public MedianFinder() {
            //l为大顶堆 - 对应倒三角形 - 从下往上增加 ,即维护数据流的左半边数据,从左往右增加
            l = new PriorityQueue<>(Comparator.reverseOrder());
            //r为小顶堆 - 对应梯形,从下往上减少 ,即维护数据流的右半边数据,从右向左减少
            r = new PriorityQueue<>();


        }


        //当数据流元素数量为偶数：l 和 r 大小相同，此时动态中位数为两者堆顶元素的平均值；
        //当数据流元素数量为奇数：l 比 r 多一，此时动态中位数为 l 的堆顶元素。
        public double findMedian() {
            int sz1 = l.size(), sz2 = r.size();
            if (sz1 == sz2)
                return (l.peek() + r.peek()) / 2.0;
            else
                return l.peek();
        }

        public void addNum(int num) {
            int sz1 = l.size(), sz2 = r.size();
            //插入前两者大小相同，说明插入前数据流元素个数为偶数，插入后变为奇数。期望操作完达到「l 的数量为 r 多一，同时双堆维持有序」
            //同时双堆维持有序 - 各个堆自身的有序性由优先队列维持，但是 r的peek()必须>=l.peek(),即右侧元素的最小值必须大于等于左侧元素的最大值
            if (sz1 == sz2) {
                //如果 r 为空，说明当前插入的是首个元素，直接添加到 l 即可；
                //如果 r 不为空，且 num <= r.peek()，说明 num 的插入位置不会在后半部分（不会在 r 中），直接加到 l 即可；
                //如果 r 不为空，且 num > r.peek()，说明 num 的插入位置在后半部分，此时将 r 的堆顶元素放到 l 中，再把 num 放到 r（相当于从 r 中置换一位出来放到 l 中）。
                if (r.isEmpty() || r.peek() >= num)
                    l.add(num);
                else {
                    l.add(r.poll());
                    r.add(num);
                }
            } else {
                //插入前两者大小不同,说明插入前数据流元素个为奇数。期望操作完达到「l 和 r 数量相等，同时双堆维持有序」
                //如果 num >= l.peek()，说明 num 的插入位置不会在前半部分（不会在 l 中），直接添加到 r 即可。
                if (num >= l.peek()) {
                    r.add(num);
                }
                //如果 num < l.peek()，说明 num 的插入位置在前半部分，此时将 l 的堆顶元素放到 r 中，再把 num 放入 l 中（相等于从 l 中替换一位出来当到 r 中）。
                else {
                    r.add(l.poll());
                    l.add(num);
                }
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
