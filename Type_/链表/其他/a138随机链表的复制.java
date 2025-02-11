package Type_.链表.其他;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a138随机链表的复制 {
    class S1 {
        // Definition for a Node.
        class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }

        class Solution {
            public Node copyRandomList(Node head) {
                //建立旧节点与新节点的映射
                Map<Node, Node> record = new HashMap<>();
                // 第一次遍历，先把所有节点克隆出来
                for (Node p = head; p != null; p = p.next) {
                    if (!record.containsKey(p))
                        record.put(p, new Node(p.val));
                    p = p.next;
                }
                // 第二次遍历，把克隆节点的结构连接好
                for (Node p = head; p != null; p = p.next) {
                    Node cur = record.get(p);
                    cur.next = record.get(p.next);
                    cur.random = record.get(p.random);
                }
                return record.get(head);
            }
        }
    }
}
