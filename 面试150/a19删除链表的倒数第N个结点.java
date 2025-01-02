package 面试150;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/02
 * @Description:
 */
public class a19删除链表的倒数第N个结点 {
    class S1 {
        class Solution {
            public ListNode removeNthFromEnd(ListNode head, int n) {
                if (head == null || head.next == null)
                    return null;
                ListNode dummy = new ListNode(-1, head), slow = dummy, fast = dummy;
                for (int i = 0; i < n; i++) {
                    fast = fast.next;
                }
                while (fast.next != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
                //slow指向倒数第 n + 1个结点
                //slow 后面那个节点就是要删除的节点
                slow.next = slow.next.next;
                return dummy.next;
            }
        }
    }
}
