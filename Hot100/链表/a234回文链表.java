package Hot100.链表;

import Common.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/23
 * @Description:
 */
public class a234回文链表 {
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
    class Solution1 {
        //用字符串来保存
        public boolean isPalindrome(ListNode head) {
            StringBuilder sb = new StringBuilder();

            while (head != null) {
                sb.append(head.val);
                head = head.next;
            }
            //System.out.println(sb);
            for (int lo = 0, hi = sb.length() - 1; lo <= hi; lo++, hi--) {
                if (sb.charAt(lo) != sb.charAt(hi))
                    return false;
            }
            return true;
        }
    }

    class Solution2 {
        //用数组保存
        public boolean isPalindrome(ListNode head) {
            List<Integer> s = new ArrayList<>();
            while (head != null) {
                s.add(head.val);
                head = head.next;
            }
            //System.out.println(sb);
            for (int lo = 0, hi = s.size() - 1; lo <= hi; lo++, hi--) {
                if (s.get(lo) != s.get(hi))
                    return false;
            }
            return true;
        }
    }

    class Solution3 {
        //0(1)复杂度解法 ： 快慢指针 + 反转一半链表
        public boolean isPalindrome(ListNode head) {
            int len = 0;
            ListNode slow = head, fast = head;
            while (slow != null) {
                len++;
                slow = slow.next;
            }

            //快慢指针
            int step = (len - 1) >> 1;
            while (step > 0) {
                fast = fast.next;
                step--;
            }
            reverseHalfList(fast);
            printList(head);
            slow = head;
            fast = fast.next;
            while (slow != null && fast != null) {
                if (slow.val != fast.val)
                    return false;
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }

        private void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val + ",");
                head = head.next;
            }
        }

        //对node之后的节点进行翻转,用头插法的方式吧
        void reverseHalfList(ListNode node) {
            ListNode head = node, p = node.next;
            head.next = null;
            //头插法进行插入
            while (p != null) {
                ListNode r = p.next;
                p.next = head.next;
                head.next = p;
                p = r;
            }
        }
    }
}
