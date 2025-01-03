package 面试必刷;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/01
 * @Description:
 */
public class a2两数相加 {
    /**
     * 递归 - todo
     */
    class S3 {
        class Solution {
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                return addTwo(l1, l2, 0);
            }
            private ListNode addTwo(ListNode p1, ListNode p2, int pre) {
                if (p1 == null && p2 == null)
                    return pre == 0 ? null : new ListNode(pre);

                //如果此时 p1为空，那么 p2一定非空
                if (p1 == null) {
                    p1 = p2;
                    p2 = null; //交换 p1 与 p2 ，保证p1非空，简化代码
                }
                int sum = pre + p1.val + (p2 == null ? 0 : p2.val);
                p1.val = sum % 10;
                p1.next = addTwo(p1.next, p2 == null ? null : p2.next, sum / 10);
                return p1;
            }
        }


    }

    /**
     * 迭代 - 2
     */
    class S2 {
        class Solution {
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode p1 = l1, p2 = l2, dummy = new ListNode(-1), r = dummy;
                int pre = 0;
                //有一个不是空节点, 或者还有 进位的话就继续迭代
                while (p1 != null || p2 != null || pre != 0) {
                    if (p1 != null) {
                        pre += p1.val;
                        p1 = p1.next;
                    }
                    if (p2 != null) {
                        pre += p2.val;
                        p2 = p2.next;
                    }
                    int cur = pre % 10;
                    pre /= 10;
                    r = r.next = new ListNode(cur);
                }
                return dummy.next;
            }
        }
    }

    /**
     * 迭代 - 1
     */
    class S1 {
        class Solution {
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode p1 = l1, p2 = l2, dummy = new ListNode(-1), r = dummy;
                int pre = 0;
                for (; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next, r = r.next) {
                    int v1 = p1.val, v2 = p2.val, sum = pre + v1 + v2;
                    int cur = sum % 10;
                    pre = sum / 10;
                    r.next = new ListNode(cur);
                }
                //如果 p2为空,则 p1 是已经走完,让 p1 指向 p2
                if (p2 != null)
                    p1 = p2;
                for (; p1 != null; p1 = p1.next, r = r.next) {
                    int v1 = p1.val, sum = pre + v1;
                    int cur = sum % 10;
                    pre = sum / 10;
                    r.next = new ListNode(cur);
                }
                r.next = pre == 0 ? null : new ListNode(pre);
                return dummy.next;
            }
        }
    }
}
