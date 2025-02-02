package Type_.滑动窗口与双指针.定长滑动窗口;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2025/02/02
 * @Description:
 */
public class a239滑动窗口最大值 {

    /**
     * 优化为一个队列
     */
    class S2 {
        class Solution {
            class MaxQueue {
                List<Integer> maxQ = new LinkedList<>();

                private void push(int val) {
                    // 移除maxQ中所有小于新元素val的元素
                    while (!maxQ.isEmpty() && maxQ.getLast() < val) {
                        maxQ.removeLast();
                    }
                    maxQ.add(val);
                }

                private int getMax() {
                    return maxQ.getFirst();
                }

                private void poll(int val) {
                    if (val == maxQ.getFirst())
                        maxQ.removeFirst();
                }
            }

            public int[] maxSlidingWindow(int[] nums, int k) {
                int n = nums.length;
                MaxQueue maxQueue = new MaxQueue();
                int[] res = new int[n - k + 1];

                for (int i = 0; i < n; i++) {
                    if (i < k - 1) {
                        maxQueue.push(nums[i]);
                    } else {
                        maxQueue.push(nums[i]);
                        res[i - k + 1] = maxQueue.getMax();
                        maxQueue.poll(nums[i - k + 1]);
                    }
                }

                return res;
            }
        }

    }

    class S1 {
        class Solution {
            class MaxQueue {
                List<Integer> realQ = new LinkedList<>();
                List<Integer> maxQ = new LinkedList<>();

                private void push(int val) {
                    realQ.add(val);
                    // 移除maxQ中所有小于新元素val的元素
                    while (!maxQ.isEmpty() && maxQ.getLast() < val) {
                        maxQ.removeLast();
                    }
                    maxQ.add(val);
                }

                private int getMax() {
                    return maxQ.getFirst();
                }

                private void poll() {
                    if (realQ.getFirst().equals(maxQ.getFirst())) {
                        maxQ.removeFirst();
                    }
                    realQ.removeFirst();
                }
            }

            public int[] maxSlidingWindow(int[] nums, int k) {
                int n = nums.length;
                MaxQueue maxQueue = new MaxQueue();
                int[] res = new int[n - k + 1];

                for (int i = 0; i < n; i++) {
                    if (i < k - 1) {
                        maxQueue.push(nums[i]);
                    } else {
                        maxQueue.push(nums[i]);
                        res[i - k + 1] = maxQueue.getMax();
                        maxQueue.poll();
                    }
                }

                return res;
            }
        }

    }
}
