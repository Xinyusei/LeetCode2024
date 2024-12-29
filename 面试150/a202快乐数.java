package 面试150;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/12/29
 * @Description:
 */
public class a202快乐数 {

    /**
     * 快慢指针 - 需要掌握，类似与 链表判断是否有环
     */
    class S2 {
        class Solution {
            public boolean isHappy(int n) {
                int slow = n;
                int fast = getNext(n);
                while (fast != 1 && slow != fast) {
                    slow = getNext(slow);
                    fast = getNext(getNext(fast));

                }
                return fast == 1;
            }

            private int getNext(int n) {
                int next = 0;
                while (n > 0) {
                    int x = n % 10;
                    next += x * x;
                    n /= 10;
                }
                return next;
            }

        }
    }

    /**
     * 用集合来判断是否有环
     */
    class S1 {
        class Solution {
            public boolean isHappy(int n) {
                Set<Integer> seen = new HashSet<>();
                while (n != 1 && !seen.contains(n)) {
                    n = getNext(n);
                    seen.add(n);
                }
                return n == 1;
            }

            private int getNext(int n) {
                int next = 0;
                while (n > 0) {
                    int x = n % 10;
                    next += x * x;
                    n /= 10;
                }
                return next;
            }
        }
    }

}
