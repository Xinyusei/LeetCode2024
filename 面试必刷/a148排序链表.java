package 面试必刷;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/11
 * @Description:
 */
public class a148排序链表 {
    /**
     * 归并排序 - (自顶向下)递归 + 分治
     * 时间 - O (NlogN）
     * 空间 - 递归栈 (logN)
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

            public ListNode sortList(ListNode head) {
                if (head == null || head.next == null)
                    return head;

                ListNode head2 = getMiddleHead(head);

                //分治
                head = sortList(head);
                head2 = sortList(head2);

                //合并
                return mergeTwoList(head, head2);
            }

            //找到链表的中间节点
            private ListNode getMiddleHead(ListNode head) {
                ListNode slow = head, fast = head;
                // 先找到链表的中间结点的【前一个节点】
                while (fast.next != null && fast.next.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
                ListNode mid = slow.next; // 下一个节点就是链表的中间结点 mid
                slow.next = null; // 下一个节点就是链表的中间结点 mid
                return mid;
            }

            //合并两个有序链表 - 双指针
            private ListNode mergeTwoList(ListNode p1, ListNode p2) {
                ListNode dummy = new ListNode(-1), curr = dummy;
                while (p1 != null && p2 != null) {
                    if (p1.val < p2.val) {
                        curr.next = p1;
                        p1 = p1.next;
                    } else {
                        curr.next = p2;
                        p2 = p2.next;
                    }
                    curr = curr.next;
                }
                curr.next = p1 == null ? p2 : p1;
                return dummy.next;
            }


        }
    }


    /**
     * 归并排序 - (自底向上)
     * 时间 - O (NlogN）
     * 空间 - O (1)
     */
    class S2 {
        class Solution {
            public ListNode sortList(ListNode head) {
                if (head == null || head.next == null)
                    return head;
                int size = getListLength(head);
                ListNode dummy = new ListNode(-1, head); //哨兵节点
                for (int step = 1; step < size; step *= 2) {
                    // 新链表的末尾 和 每轮循环的起始节点
                    ListNode newListTail = dummy, cur = dummy.next;
                    while (cur != null) {
                        // 从 cur 开始，分割出两段长为 step 的链表，头节点分别为 head1 和 head2

                        ListNode head1 = cur;
                        ListNode head2 = splitList(head1, step);
                        cur = splitList(head2, step); //下一轮循环的起始结点

                        //上面其实就是在 [归]

                        ListNode[] merged = mergeTwoList(head1, head2);
                        // 合并后的头节点 merged[0]，插到 newListTail 的后面
                        //上面就是在 [并]
                        newListTail.next = merged[0];
                        //现在是新链表的末尾
                        newListTail = merged[1];
                    }
                }

                return dummy.next;
            }

            // 获取链表长度
            private int getListLength(ListNode p) {
                int sz = 0;
                while (p != null) {
                    p = p.next;
                    sz++;
                }
                return sz;
            }


            // 分割链表
            // 如果链表长度 <= size，不做任何操作，返回空节点
            // 如果链表长度 > size，把链表的前 size 个节点分割出来（断开连接），并返回剩余链表的头节点
            private ListNode splitList(ListNode head, int size) {
                ListNode cur = head;
                for (int i = 0; i < size - 1 && cur != null; i++) {
                    cur = cur.next;
                }
                //如果链表长度 <= size
                if (cur == null || cur.next == null)
                    return null;

                ListNode nextHead = cur.next;
                cur.next = null;
                return nextHead;
            }


            // 合并两个有序链表（双指针）
            // 返回合并后的链表的头节点和尾节点
            private ListNode[] mergeTwoList(ListNode p1, ListNode p2) {
                ListNode dummy = new ListNode(-1), curr = dummy;
                while (p1 != null && p2 != null) {
                    if (p1.val < p2.val) {
                        curr.next = p1;
                        p1 = p1.next;
                    } else {
                        curr.next = p2;
                        p2 = p2.next;
                    }
                    curr = curr.next;
                }
                curr.next = p1 == null ? p2 : p1;

                while (curr.next != null)
                    curr = curr.next;

                return new ListNode[]{dummy.next, curr};
            }
        }
    }
}
