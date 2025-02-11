package Type_.链表.合并链表;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a2两数相加 {
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
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                int up = 0;
                ListNode dummy = new ListNode(-1,null),p = dummy;
                for (ListNode p1 = l1, p2 = l2; p1 != null || p2 != null || up != 0; ) {
                    int cur = up;
                    if(p1 != null){
                        cur += p1.val;
                        p1 = p1.next;
                    }
                    if(p2 != null){
                        cur += p2.val;
                        p2 = p2.next;
                    }
                    p.next = new ListNode(cur % 10);
                    p = p.next;
                    up = cur / 10;
                }
                return dummy.next;
            }
        }
    }
}
