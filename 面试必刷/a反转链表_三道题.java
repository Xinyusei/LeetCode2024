package 面试必刷;

import Common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/01
 * @Description:
 */
public class a反转链表_三道题 {
    //206. 反转链表

    /**
     * 迭代反转全部链表 - todo - 更好理解的方法
     */
    class S1_Type1 {
        class Solution {
            public ListNode reverseList(ListNode head) {
                if (head == null || head.next == null)
                    return head;
                ListNode pre = null, cur = head, nxt = cur.next;
                while (cur != null) {
                    //逐个节点翻转
                    cur.next = pre;
                    //更新指针位置
                    pre = cur;
                    cur = nxt;
                    if (nxt != null)
                        nxt = nxt.next;
                }
                return pre;
            }
        }
    }

    /**
     * 递归翻转全部链表 - 未掌握 - todo
     */
    class S1_Type2 {
        class Solution {
            public ListNode reverseList(ListNode head) {
                return doReverse(head);
            }

            /**
             * 翻转以node为头结点的链表,返回翻转后的头结点
             *
             * @param node 返回翻转后的头结点
             * @return
             * @author ZJX
             * @date 2025/01/01
             */
            public ListNode doReverse(ListNode node) {
                if (node == null || node.next == null)
                    return node;
                ListNode head = doReverse(node.next);
                node.next.next = node;
                node.next = null;
                return head;
            }
        }
    }

    /**
     * 翻转链表的前N个结点 - 迭代
     */
    class S2_Type1 {
        class Solution {
            ListNode reverseN(ListNode head, int N) {
                if (head == null || head.next == null)
                    return head;
                ListNode pre = null, cur = head, nxt = cur.next;
                while (N > 0) {
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                    if (nxt != null)
                        nxt = nxt.next;
                    N--;
                }
                // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
                head.next = cur;
                // 此时的 pre 是反转后的头结点
                return pre;
            }
        }
    }

    /**
     * 翻转链表的前N个结点 - 递归
     */
    class S2_Type2 {
        class Solution {
            ListNode successor = null;

            ListNode reverseN(ListNode head, int N) {
                return doReverseN(head, N);
            }

            ListNode doReverseN(ListNode node, int N) {
                if (node == null || node.next == null || N == 0)
                    return node;
                if (N == 1) {
                    //记录第 N + 1 个结点
                    successor = node.next;
                    return node;
                }
                ListNode head = doReverseN(node.next, N - 1);

                node.next.next = node;
                node.next = successor;

                return head;
            }
        }
    }

    /**
     * 迭代反转 某个区间的链表 - 复用之前的翻转前N个结点
     */
    class S3_Type1 {
        class Solution {
            ListNode reverseN(ListNode head, int N) {
                if (head == null || head.next == null)
                    return head;
                ListNode pre = null, cur = head, nxt = cur.next;
                while (N > 0) {
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                    if (nxt != null)
                        nxt = nxt.next;
                    N--;
                }
                // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
                head.next = cur;
                // 此时的 pre 是反转后的头结点
                return pre;
            }

            public ListNode reverseBetween(ListNode head, int left, int right) {
                if (left == 1)
                    return reverseN(head, right);
                ListNode pre = head;
                for (int i = 1; i < left - 1; i++)
                    pre = pre.next;
                pre.next = reverseN(pre.next, right - left + 1);
                return head;
            }
        }
    }

    /**
     * 迭代反转 某个区间的链表 - 不复用,采用头插法
     * 记住一个性质 ：在反转结束后，从原链表上看，pre指向这一段的末尾，cur指向这一段的下一个结点
     * 把 反转这一段的上一个节点叫做p0
     * 这一段翻转完毕后，应该让 p0.next.next = cur,p0.next = cur
     */
    class S3_Type2 {
        class Solution {
            public ListNode reverseBetween(ListNode head, int left, int right) {
                ListNode dummy = new ListNode(-1, head), p0 = dummy;
                for (int i = 0; i < left - 1; i++)
                    p0 = p0.next;
                ListNode pre = null, cur = p0.next;
                for (int i = 0; i <= right - left; i++) {
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                p0.next.next = cur;
                p0.next = pre;
                return dummy.next;
            }
        }
    }

    /**
     * 反转 某个区间的链表 - 递归
     */
    class S3_Type3 {

        class Solution {
            ListNode successor = null;

            public ListNode reverseBetween(ListNode head, int left, int right) {
                if (left == 1)
                    return doReverseN(head, right);
                head.next = reverseBetween(head.next, left - 1, right - 1);
                return head;
            }

            ListNode doReverseN(ListNode node, int N) {
                if (node == null || node.next == null || N == 0)
                    return node;
                if (N == 1) {
                    //记录第 N + 1 个结点
                    successor = node.next;
                    return node;
                }
                ListNode head = doReverseN(node.next, N - 1);

                node.next.next = node;
                node.next = successor;

                return head;
            }
        }
    }

    /**
     * K个一组反转链表 - 栈  - 效率较低
     */
    class S4_Type1 {
        class Solution {
            public ListNode reverseKGroup(ListNode head, int k) {
                List<ListNode> stack = new ArrayList<>();
                ListNode dummy = new ListNode(-1), p = dummy, tmp = head;
                while (true) {
                    int count = 0;
                    while (tmp != null && count < k) {
                        stack.addLast(tmp);
                        tmp = tmp.next;
                        count++;
                    }
                    //此时 temp 为空
                    if (count != k) {
                        p.next = head;
                        break;
                    }
                    while (!stack.isEmpty()) {
                        p.next = stack.removeLast();
                        p = p.next;
                    }
                    head = tmp;
                    p.next = tmp;
                }
                return dummy.next;
            }
        }
    }


    /**
     * K个一组反转链表 - 迭代
     */
    class S4_Type2 {
        class Solution {
            public ListNode reverseKGroup(ListNode head, int k) {
                int n = 0;
                for (ListNode cur = head; cur != null; cur = cur.next)
                    n++;
                ListNode dummy = new ListNode(-1, head), pre = null, cur = head, p0 = dummy;
                //k个一组处理
                for (; n >= k; n -= k) {
                    for (int i = 0; i < k; i++) {
                        ListNode nxt = cur.next;
                        cur.next = pre;
                        pre = cur;
                        cur = nxt;
                    }

                    ListNode nxt = p0.next;
                    p0.next.next = cur;
                    p0.next = pre;
                    p0 = nxt;
                }
                return dummy.next;
            }

        }
    }


    /**
     *  K个一组反转链表 - 递归
     */
    class S4_Type3 {
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
            public ListNode reverseKGroup(ListNode head, int k) {
                ListNode fast = head;
                int n = k;
                while (n > 0) {
                    if (fast == null)
                        return head;
                    fast = fast.next;
                    n--;
                }
                ListNode newHead = reverseN(head, k);
                head.next = reverseKGroup(fast,k);
                return newHead;
            }

            public ListNode reverseN(ListNode node, int n) {
                if (node == null || node.next == null)
                    return node;
                ListNode dummy = new ListNode(-1, node);
                ListNode p0 = dummy, pre = null, cur = node;
                while (n > 0) {
                    ListNode nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                    n--;
                }
                p0.next.next = cur;
                p0.next = pre;

                return dummy.next;
            }
        }
    }
}
