package Type_.链表.分治;

import Common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ZJX
 * @Date: 2025/01/12
 * @Description:
 */
public class a23合并K个升序链表 {
    /**
     * 两两合并 - 递归（归并）版本
     */
    class S1_1 {
        class Solution {
            public ListNode mergeKLists(ListNode[] lists) {
                if (lists == null || lists.length == 0)
                    return null;
                return doMergeKLists(lists, 0, lists.length - 1);
            }

            private ListNode doMergeKLists(ListNode[] lists, int start, int end) {
                if (start == end)
                    return lists[start];

                int mid = (end + start) >> 1;

                ListNode head1 = doMergeKLists(lists, start, mid);
                ListNode head2 = doMergeKLists(lists, mid + 1, end);

                return mergeTwoLists(head1, head2);
            }

            public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
                ListNode dummy = new ListNode(-1), curr = dummy;
                while (head1 != null && head2 != null) {
                    if (head1.val < head2.val) {
                        curr.next = head1;
                        head1 = head1.next;
                    } else {
                        curr.next = head2;
                        head2 = head2.next;
                    }
                    curr = curr.next;
                }
                curr.next = head1 != null ? head1 : head2;
                return dummy.next;
            }
        }
    }

    /**
     * 两两合并 - 迭代版本
     */
    class S1_2 {
        class Solution {
            public ListNode mergeKLists(ListNode[] lists) {
                if (lists == null || lists.length == 0)
                    return null;

                //外层控制循环合并的轮次, 每轮间隔翻倍
                for (int step = 1; step < lists.length; step *= 2) {
                    //i 表示遍历到第几个链表了
                    for (int i = 0; i + step < lists.length; i += step * 2) {
                        lists[i] = mergeTwoLists(lists[i], i + step < lists.length ? lists[i + step] : null);
                    }
                }
                return lists[0];

            }


            public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
                ListNode dummy = new ListNode(-1), curr = dummy;
                while (head1 != null && head2 != null) {
                    if (head1.val < head2.val) {
                        curr.next = head1;
                        head1 = head1.next;
                    } else {
                        curr.next = head2;
                        head2 = head2.next;
                    }
                    curr = curr.next;
                }
                curr.next = head1 != null ? head1 : head2;
                return dummy.next;
            }
        }
    }

    /**
     * 优先队列
     */
    class S2 {
        class Solution {
            public ListNode mergeKLists(ListNode[] lists) {
                if (lists == null || lists.length == 0)
                    return null;
                // 虚拟头结点
                ListNode dummy = new ListNode(-1), curr = dummy;
                // 优先级队列, 最小堆
                PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

                for (ListNode list : lists) {
                    if (list != null)
                        pq.add(list);
                }

                while (!pq.isEmpty()) {
                    // 逐步从优先队列中取出最小节点并加入结果链表
                    ListNode node = pq.poll();
                    curr.next = node;
                    curr = curr.next;
                    // 将取出节点的下一个节点加入优先队列

                    if (node.next != null) {
                        pq.add(node.next);
                    }

                }
                return dummy.next;
            }
        }
    }
}
