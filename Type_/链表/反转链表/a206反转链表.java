package Type_.链表.反转链表;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a206反转链表 {
    /**
     * 遍历，头插法 反转
     */
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
            public ListNode reverseList(ListNode head) {
                ListNode dummy = new ListNode(-1, null);
                while (head != null) {
                    ListNode nxt = head.next;
                    head.next = dummy.next;
                    dummy.next = head;
                    head = nxt;
                }
                return dummy.next;
            }
        }
    }

    /**
     * 递归反转
     */
    class S2 {
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
            //1. 明确 reverseList 表示反转后链表的头结点
            public ListNode reverseList(ListNode head) {
                if (head == null || head.next == null)
                    return head;
                ListNode newHead = reverseList(head.next);

                ListNode next = head.next;
                next.next = head;
                head.next = null;

                return newHead;
            }
        }
    }
}
