package Type_.链表.分治;

import Common.ListNode;
import com.sun.jdi.VMMismatchException;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a148排序链表 {
    // 自顶向下 - 归并排序
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
                ListNode mid = getMiddleNode(head);
                ListNode head2 = mid.next;
                mid.next = null;
                ListNode p1 = sortList(head);
                ListNode p2 = sortList(head2);
                //-1，3，5
                //0,4
                return mergeTwoLists(p1, p2);
            }

            //找到链表的中间节点
            public ListNode getMiddleNode(ListNode head) {
                ListNode dummy = new ListNode(-1, head), slow = dummy, fast = dummy;
                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }
                return slow;
            }

            // 合并两个升序链表
            public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
                ListNode dummy = new ListNode(-1, null), p = dummy;
                while (p1 != null && p2 != null) {
                    if (p1.val < p2.val) {
                        p.next = p1;
                        p1 = p1.next;
                    } else {
                        p.next = p2;
                        p2 = p2.next;
                    }
                    p = p.next;
                }
                p.next = p1 != null ? p1 : p2;
                return dummy.next;
            }
        }
    }

    // 自底向上 - 归并排序
    //首先，归并长度为 1 的子链表。例如 [4,2,1,3]，把第一个节点和第二个节点归并，第三个节点和第四个节点归并，得到 [2,4,1,3]。
    //然后，归并长度为 2 的子链表。例如 [2,4,1,3]，把前两个节点和后两个节点归并，得到 [1,2,3,4]。
    //然后，归并长度为 4 的子链表。
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            int len = size(head);
            ListNode dummy = new ListNode(0, head);
            //step 为步长，即参与合并的链表长度
            for (int step = 1; step < len; step <<= 1) {
                ListNode newListTail = dummy;
                ListNode cur = dummy.next;
                while (cur != null) {
                    // 从 cur 开始，分割出两段长为 step 的链表，头节点分别为 head1 和 head2
                    ListNode head1 = cur;
                    ListNode head2 = splitList(head1, step);
                    cur = splitList(head2, step); // 下一轮循环的起始节点
                    ListNode[] merged = mergeTwoLists(head1, head2);
                    // 合并后的头节点 merged[0]，插到 newListTail 的后面
                    newListTail.next = merged[0];
                    newListTail = merged[1];
                }
            }

            return dummy.next;
        }

        // 分割链表
        // 如果链表长度 <= size，不做任何操作，返回空节点
        // 如果链表长度 > size，把链表的前 size 个节点分割出来（断开连接），并返回剩余链表的头节点
        public ListNode splitList(ListNode head, int len) {
            ListNode cur = head;
            for (int i = 0; i < len - 1 && cur != null; i++) {
                cur = cur.next;
            }
            //链表长度 <= size
            if (cur == null || cur.next == null)
                return null;
            ListNode nextHead = cur.next;
            cur.next = null;
            return nextHead;
        }

        public int size(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }


        //合并两个升序链表
        //返回升序链表的头结点和尾结点
        public ListNode[] mergeTwoLists(ListNode p1, ListNode p2) {
            ListNode dummy = new ListNode(-1, null), p = dummy;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }
            p.next = p1 != null ? p1 : p2;
            while (p.next != null) {
                p = p.next;
            }
            return new ListNode[]{dummy.next, p};
        }
    }
}
