package Hot100.链表;

import Common.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/23
 * @Description:
 */
public class a148排序链表 {
    class Solution {
        //1. 提取为数组 排序再还原 空间复杂度为0(logN)
        public ListNode sortList(ListNode head) {
            ArrayList<Integer> ls = new ArrayList<>();
            ListNode p = head;
            while (p != null) {
                ls.add(p.val);
                p = p.next;
            }
            ls.sort(Comparator.comparingInt(o -> o));
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            p = dummy;
            for (int l : ls) {
                p.next = new ListNode(l);
                p = p.next;
            }
            return dummy.next;
        }
    }

    class Solution2 {
        //考虑时间复杂度O(logN) 空间复杂度为O(1)的算法：归并排序 、 快速排序 、堆排序 只有归并排序适用于链表


        //这种是 递归版本的归并排序 ，空间复杂度为0(logN)
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
            ListNode slow = dummy, fast = dummy;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            //对head->slow tmp->fast这两部分分别进行归并排序
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            //ListNode node = mergeSort(left, right,true);
            ListNode node = mergeSort(left, right);
            return node;
        }
        /**
         * 迭代版本实现的两链表合并
         *
         * @param node1
         * @param node2
         * @return
         * @author ZJX
         * @date 2024/11/23
         */
        public ListNode mergeSort(ListNode node1, ListNode node2, boolean bottom2up) {
            ListNode dummy = new ListNode(0);
            ListNode p = node1, q = node2, r = dummy;
            while (p != null && q != null) {
                if (p.val < q.val) {
                    r.next = p;
                    p = p.next;
                } else {
                    r.next = q;
                    q = q.next;
                }
                r = r.next;
            }
            r.next = p == null ? q : p;
            return dummy.next;
        }

        /**
         * 递归版本实现的两链表合并
         *
         * @param node1
         * @param node2
         * @return
         * @author ZJX
         * @date 2024/11/23
         */
        public ListNode mergeSort(ListNode node1, ListNode node2) {
            if (node1 == null)
                return node2;
            if (node2 == null)
                return node1;
            if (node1.val < node2.val) {
                node1.next = mergeSort(node1.next, node2);
                return node1;
            } else {
                node2.next = mergeSort(node1, node2.next);
                return node2;
            }
        }
    }

    class Solution3 {

        //这种是 迭代版本的归并排序 ，空间复杂度为0(1)
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            // 获取链表长度
            int length = getLength(head);

            // 哑节点，方便处理边界情况
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            // subLen 表示每次合并的子链表的长度
            for (int subLen = 1; subLen < length; subLen <<= 1) {
                ListNode prev = dummy, curr = dummy.next;

                while (curr != null) {
                    // 找到第一个子链表的头
                    ListNode head1 = curr;
                    // 找到第二个子链表的头
                    ListNode head2 = split(head1, subLen);
                    // 找到下一个子链表的头
                    curr = split(head2, subLen);
                    // 合并两个子链表
                    prev.next = mergeSort(head1, head2);
                    // 移动 prev 到已合并部分的末尾
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                }
            }
            return dummy.next;
        }

        /**
         * 分割链表 - 将链表从当前位置进行分割
         * @author ZJX
         * @date 2024/11/23
         * @param head 链表的头节点
         * @param n 要分割的子链表长度
         * @return 第二部分链表的头节点
         */
        private ListNode split(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            for (int i = 1; head.next != null && i < n; i++) {
                head = head.next;
            }
            ListNode second = head.next;
            head.next = null;
            return second;
        }
        /**
         * 获取链表长度
         * @author ZJX
         * @date 2024/11/23
         * @param head 链表头
         * @return 链表长度
         */
        private int getLength(ListNode head){
            int length = 0;
            while (head != null) {
                length++;
                head = head.next;
            }
            return length;
        }
        /**
         * 迭代版本实现的两链表合并
         *
         * @param node1 链表1的头结点
         * @param node2 链表2的头结点
         * @return 合并后新链表的头结点
         * @author ZJX
         * @date 2024/11/23
         */
        public ListNode mergeSort(ListNode node1, ListNode node2) {
            ListNode dummy = new ListNode(0);
            ListNode p = node1, q = node2, r = dummy;
            while (p != null && q != null) {
                if (p.val < q.val) {
                    r.next = p;
                    p = p.next;
                } else {
                    r.next = q;
                    q = q.next;
                }
                r = r.next;
            }
            r.next = p == null ? q : p;
            return dummy.next;
        }
    }
}
