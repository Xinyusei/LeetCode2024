package Type_.链表.前后指针;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a19删除链表的倒数第N个结点 {
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
            public ListNode removeNthFromEnd(ListNode head, int n) {
                ListNode dummy = new ListNode(-1, head);
                ListNode node = theLastKNode(dummy, n + 1);
                ListNode remNode = node.next;

                node.next = remNode.next;
                remNode.next = null;


                return dummy.next;
            }

            /**
             * 返回以head为头结点的倒数第k个结点
             *
             * @param head 头结点
             * @param k    倒数第几个数
             * @return 倒数第K个结点
             */
            public ListNode theLastKNode(ListNode head, int k) {
                ListNode fast = head;
                for (int i = 0; i < k; i++) {
                    fast = fast.next;
                }
                ListNode slow = head;
                while (fast != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
    }
}
