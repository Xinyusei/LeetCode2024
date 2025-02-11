package Type_.链表.反转链表;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a92反转链表II {
    class S1 {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         * int val;
         * ListNode next;
         * ListNode() {}
         * ListNode(int val) { this.val = val; }
         * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public ListNode reverseBetween(ListNode head, int left, int right) {
                if (head == null || head.next == null)
                    return head;
                ListNode dummy = new ListNode(-1, head);
                ListNode p = dummy;
                for (int i = 0; i < left - 1; i++) {
                    p = p.next;
                }
                int k = right - left + 1;
                ListNode pre = null, cur = p.next;
                //翻转
                for (int i = 0; i < k; i++) {
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                //翻转完后 pre翻转这一段的末尾cur cur指向next节点
                p.next.next = cur;
                p.next = pre;

                return dummy.next;
            }
        }
    }
}
