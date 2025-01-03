package 面试必刷;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2025/01/03
 * @Description:
 */
public class a138随机链表的复制 {
    class Node {
        int val;
        Node next, random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 一个 哈希表 -
     */
    class S2 {
        class Solution {
            public Node copyRandomList(Node head) {
                Map<Node, Node> record = new HashMap<>();
                Node dummy = new Node(-1);
                for (Node p = head, q = dummy; p != null; p = p.next, q = q.next) {
                    Node newNode = new Node(p.val);
                    q.next = newNode;
                    record.put(p, newNode);
                }
                //修改random
                for (Node p = head, q = dummy.next; p != null; p = p.next, q = q.next) {
                    Node randomNode = p.random;
                    if (randomNode != null) {
                        q.random = record.get(randomNode);
                    } else {
                        q.random = null;
                    }
                }
                return dummy.next;
            }
        }
    }

    /**
     * 两个哈希表 分别记录 原来的Node ： index 和 新的 index ： Node
     * 两次遍历
     */
    class S1 {

        class Solution {
            public Node copyRandomList(Node head) {
                HashMap<Node, Integer> oldRecord = new HashMap<>();
                HashMap<Integer, Node> newRecord = new HashMap<>();
                int index = 0;
                Node p = head, dummy = new Node(-1), q = dummy;
                // 一次遍历,记录 两个映射关系
                while (p != null) {
                    oldRecord.put(p, index);
                    q.next = new Node(p.val);
                    p = p.next;
                    q = q.next;
                    newRecord.put(index, q);
                    index++;
                }
                q = dummy.next;
                p = head;
                //设置random
                while (p != null) {
                    Node random = p.random;
                    if (random == null) {
                        q.random = null;
                    } else {
                        int idx = oldRecord.get(random);
                        q.random = newRecord.get(idx);
                    }
                    p = p.next;
                    q = q.next;
                }
                return dummy.next;
            }
        }
    }
}
