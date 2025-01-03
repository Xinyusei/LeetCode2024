package 面试必刷;

import Common.ListNode;

import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2025/01/02
 * @Description:
 */
public class a82删除排序链表中的重复元素II {

    /**
     * 83. 删除排序链表中的重复元素 - 删除所有重复的元素，使每个元素只出现一次
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
     */
    class S1 {
        class Solution {
            public ListNode deleteDuplicates(ListNode head) {
                ListNode dummy = new ListNode(-1000, head), slow = dummy, fast = head;
                while (fast != null) {
                    if (fast.val != slow.val) {
                        slow.next = fast;
                        slow = fast;
                    }
                    fast = fast.next;
                }
                slow.next = null;
                return dummy.next;
            }
        }
    }

    /**
     * 82. 删除排序链表中的重复元素 II - 删除原始链表中所有重复数字的节点，只留下不同的数字
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
     */


    // 双指针 - todo
    class S2_Type2 {
        class Solution {
            public ListNode deleteDuplicates(ListNode head) {
                if (head == null || head.next == null)
                    return head;
                ListNode dummy = new ListNode(-1024);
                ListNode p = dummy, q = head;
                //遍历原链表
                while (q != null) {
                    //存在重复元素
                    if (q.next != null && q.val == q.next.val) {
                        while (q.next != null && q.val == q.next.val) {
                            q = q.next;
                        }
                        q = q.next;
                        //此时q跳过了这一段的重复元素
                        if (q == null) {
                            break;
                        }
                        //
                    } else {
                        //此时q一定不是重复的，可以添加
                        p.next = q;
                        p = p.next;
                        q = q.next;
                    }
                }
                p.next = null;
                return dummy.next;
            }
        }
    }

    // 哈希表 - 不太好
    class S2_Type1 {
        class Solution {
            public ListNode deleteDuplicates(ListNode head) {
                if (head == null || head.next == null)
                    return head;
                HashMap<Integer, Integer> record = new HashMap<>();
                ListNode p = head;
                while (p != null) {
                    int v = p.val;
                    record.merge(v, 1, Integer::sum);
                    p = p.next;
                }
                ListNode dummy = new ListNode(-1000), cur = head;
                p = dummy;
                while (cur != null) {
                    if (record.get(cur.val) <= 1) {
                        p.next = cur;
                        p = p.next;
                    }
                    cur = cur.next;
                }
                return dummy.next;
            }
        }
    }
}
