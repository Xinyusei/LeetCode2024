package 面试必刷;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/01
 * @Description:
 */
public class a141环形链表 {
    /**
     * 环形链表 - 判断是否有环
     */
    class S1 {
        public class Solution {
            public boolean hasCycle(ListNode head) {
                if (head == null || head.next == null)
                    return false;
                ListNode slow = head, fast = head.next;
                while (fast != null && fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                    if (fast != null)
                        fast = fast.next;
                }
                return fast != null;
            }
        }
    }

    /**
     * 找出有环的链表的入口 - todo
     */
    class S2 {
        public class Solution {
            public ListNode detectCycle(ListNode head) {
                if (head == null || head.next == null)
                    return null;
                ListNode slow = head, fast = head;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                    if (slow == fast)
                        break;
                }
                //step代表环的长度 此时slow 走了 step步,fast走了 2 * step步
                //此时 slow 与 fast没有相遇,说明没有环,返回null
                if (slow != fast)
                    return null;
                //此时 有环,
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
    }
}
