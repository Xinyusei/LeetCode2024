package Type_.链表.反转链表;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a25K个一组翻转链表 {
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
            public ListNode reverseKGroup(ListNode head, int k) {
                if (head == null || head.next == null)
                    return head;
                int len = size(head);
                ListNode dummy = new ListNode(-1, head);
                ListNode p0 = dummy, pre = null, cur = head;

                for (; len >= k; len -= k) {
                    //翻转k个链表
                    for (int i = 0; i < k; i++) {
                        ListNode next = cur.next;
                        cur.next = pre;
                        pre = cur;
                        cur = next;
                    }
                    //pre指向翻转这一段的末尾，也就是翻转后的头结点
                    //cur指向原链表上的后续一个节点
                    ListNode next = p0.next;
                    p0.next.next = cur;
                    p0.next = pre;
                    p0 = next;
                    //下一轮
                }
                return dummy.next;
            }

            public int size(ListNode head) {
                int len = 0;
                while (head != null) {
                    head = head.next;
                    len++;
                }
                return len;
            }
        }
    }
}
