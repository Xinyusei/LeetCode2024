package Type_.链表.双指针;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a160相交链表 {
    /**
     * 双指针对齐长度
     */
    class S1 {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         * int val;
         * ListNode next;
         * ListNode(int x) {
         * val = x;
         * next = null;
         * }
         * }
         */
        public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                int lenA = size(headA);
                int lenB = size(headB);
                if (lenA > lenB) {
                    for (int i = 0; i < lenA - lenB; i++)
                        headA = headA.next;
                } else {
                    for (int i = 0; i < lenB - lenA; i++)
                        headB = headB.next;
                }
                while (headA != headB) {
                    headA = headA.next;
                    headB = headB.next;
                }
                return headA;
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

    /**
     * 不求实际的长度
     */
    class S2 {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         * int val;
         * ListNode next;
         * ListNode(int x) {
         * val = x;
         * next = null;
         * }
         * }
         */
        public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                // p1 指向 A 链表头结点，p2 指向 B 链表头结点
                ListNode p1 = headA, p2 = headB;
                while (p1 != p2) {
                    if (p1 == null)
                        p1 = headB;
                    else
                        p1 = p1.next;
                    if (p2 == null)
                        p2 = headA;
                    else
                        p2 = p2.next;
                }
                return p1;
            }
        }
    }
}
