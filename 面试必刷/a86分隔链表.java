package 面试必刷;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/02
 * @Description:
 */
public class a86分隔链表 {
    class S1 {
        class Solution {
            public ListNode partition(ListNode head, int x) {
                ListNode lo = new ListNode(-1024), hi = new ListNode(1024), p = lo, q = hi, cur = head;
                while (cur != null) {
                    if (cur.val < x) {
                        p.next = cur;
                        p = p.next;
                    } else {
                        q.next = cur;
                        q = q.next;
                    }
                    cur = cur.next;
                }
                q.next = null;
                p.next = hi.next;
                return lo.next;
            }
        }
    }
}
