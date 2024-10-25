package lcRating.gt1400le1600;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2024/10/25
 * @Description:
 */
public class a1669合并两个链表 {
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
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            //找到 索引 a - 1 和 b + 1
            int lo = 0, hi = 0;
            ListNode p = list1, q = list1;
            while (lo < a - 1) {
                p = p.next;
                lo++;
            }
            //现在 p 指向 a - 1
            while (hi < b) {
                q = q.next;
                hi++;
            }
            //现在q 指向 b

            //让 p / a - 1 指向 list2
            p.next = list2;

            // p 遍历到 list2 尾部
            while (p.next != null) {
                p = p.next;
            }

            //p 现在指向 list2 尾部, list2 尾部 指向 b 的下一个节点
            p.next = q.next;
            //b 的 next 置空
            q.next = null;

            return list1;
        }
    }
}
