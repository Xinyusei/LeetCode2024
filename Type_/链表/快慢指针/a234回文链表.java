package Type_.链表.快慢指针;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a234回文链表 {
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
            public boolean isPalindrome(ListNode head) {
                ListNode dummy = new ListNode(-1, head), slow = dummy, fast = dummy;
                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }

                fast = reverese(slow.next);
                //printList(dummy);
                slow = dummy.next;

                while (fast != null) {
                    if (slow.val != fast.val)
                        return false;
                    fast = fast.next;
                    slow = slow.next;
                }
                return true;

            }
            private void printList(ListNode node) {
                while (node != null) {
                    System.out.print(node.val + "->");
                    node = node.next;
                }
            }
            private ListNode reverese(ListNode head){
                ListNode pre = null,cur = head;
                while(cur != null){
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                return pre;
            }
        }
    }
}
