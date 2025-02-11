package Type_.链表.反转链表;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a24两两交换链表中的节点 {
    // 1. 递归 - 先翻转后面的再翻转前面的
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
            public ListNode swapPairs(ListNode head) {
                if (head == null || head.next == null)
                    return head;

                ListNode others = swapPairs(head.next.next);

                ListNode second = head.next;

                head.next = others;
                second.next = head;

                return second;
            }
        }
    }

    //2. 递归 - 先翻转前面的，再翻转后面的
    class S1_2 {
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
            public ListNode swapPairs(ListNode head) {
                if (head == null || head.next == null)
                    return head;
                ListNode first = head;
                ListNode second = head.next;
                ListNode others = head.next.next;

                second.next = first;
                first.next = swapPairs(others);

                return second;
            }
        }
    }
}
