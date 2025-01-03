package 面试必刷;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/01
 * @Description:
 */
public class a61旋转链表 {
    /**
     * 基于连接成环再断掉的思路 -  相对来说好写一些
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
            public ListNode rotateRight(ListNode head, int k) {
                // 1 2 3 4 5
                // 4 5 1 2 3
                if (head == null || head.next == null)
                    return head;
                int step = 0;
                ListNode p = head;
                for (; p.next != null; p = p.next)
                    step++;
                //此时 p 指向 最后一个节点
                int len = step + 1;
                if (k % len == 0)
                    return head;
                k %= len;
                //让链表成环
                p.next = head;
                ListNode slow = p, fast = head;
                for (int i = 0; i < len - k; i++) {
                    slow = slow.next;
                    fast = fast.next;
                }
                slow.next = null;
                return fast;
            }
        }
    }


    /**
     * 基于翻转的思路 - 说实话有点难写
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
            public ListNode rotateRight(ListNode head, int k) {
                // 5 4 3 2 1
                // 4 5 1 2 3
                // 1.全部翻转
                // 2.翻转前k个
                // 3.翻转后len-k个
                if (head == null || head.next == null)
                    return head;
                int len = 0;
                ListNode p = head;
                while (p != null) {
                    len++;
                    p = p.next;
                }
                k %= len;
                if (k == 0)
                    return head;
                ListNode newHead = doRotateOfRange(head, len);
                //前k个数翻转，后len-k个数翻转
                int step = k;
                ListNode p2 = newHead;
                for (int i = 0; i < step; i++) {
                    p2 = p2.next;
                }
                ListNode node1 = doRotateOfRange(newHead, k);
                ListNode node2 = doRotateOfRange(p2, len - k);
                p = node1;
                while (p.next != null) {
                    p = p.next;
                }
                p.next = node2;
                return node1;
            }

            /**
             * 从 start 节点开始，翻转 n 个 节点
             *
             * @param start 要翻转的链表的头结点
             * @param n     要翻转的节点的个数
             * @return 翻转后的链表的头结点 和 尾节点
             * @author ZJX
             * @date 2025/01/01
             */
            public ListNode doRotateOfRange(ListNode start, int n) {
                ListNode dummy = new ListNode(-1, null), p = start;
                while (n > 0 && p != null) {
                    ListNode nxt = p.next;
                    p.next = dummy.next;
                    dummy.next = p;
                    p = nxt;
                    n--;
                }
                return dummy.next;
            }

            public void printList(ListNode p) {
                ListNode cur = p;
                while (cur != null) {
                    System.out.print(cur.val + " ");
                    cur = cur.next;
                }
                System.out.println();
            }
        }
    }


}
