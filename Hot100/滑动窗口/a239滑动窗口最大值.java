package Hot100.滑动窗口;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2024/11/21
 * @Description:
 */
public class a239滑动窗口最大值 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue();
            int n = nums.length;
            int[] f = new int[n + 1 - k];
            for (int i = 0; i < nums.length; i++) {
                if(i < k - 1 ){
                    // 先填满窗口的前 k - 1
                    window.push(nums[i]);
                }else{
                    // 加入新元素
                    window.push(nums[i]);
                    f[i + 1 - k] = window.getMax();
                    window.pop(nums[i + 1 - k]);
                }
            }
            return f;
        }

        //单调队列
        //5 3 0 -1
        class MonotonicQueue {
            private final List<Integer> queue = new LinkedList<>();
            public void push(int val) {
                //将小于 val 的元素全部移除
                while (!queue.isEmpty() && val > queue.getLast())
                    queue.removeLast();
                //将val 插入尾部
                queue.addLast(val);
            }
            public void pop(int val) {
                if (val == queue.getFirst())
                    queue.removeFirst();
            }

            public int getMax() {
                return queue.getFirst();
            }
        }
    }
}
