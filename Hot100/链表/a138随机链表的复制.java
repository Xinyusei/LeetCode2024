package Hot100.链表;/*
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
*/

import java.util.HashMap;
import java.util.Map;

class a138随机链表的复制 {
    class Solution1 {
        public Node copyRandomList(Node head) {
            Node dummy = new Node(Integer.MIN_VALUE);
            Node p = head, q = dummy;
            Map<Node, Integer> originalRecord = new HashMap<>();
            Map<Integer, Node> crtRecord = new HashMap<>();
            int idx = 0;
            while (p != null) {
                originalRecord.put(p, idx);
                Node node = new Node(p.val);
                p = p.next;
                q.next = node;
                q = q.next;
                crtRecord.put(idx, q);
                idx++;
            }
            p = head;
            q = dummy.next;
            //设置random
            while (p != null) {
                Node rnode = p.random;
                if (rnode == null)
                    q.random = null;
                else {
                    idx = originalRecord.get(rnode);
                    q.random = crtRecord.get(idx);
                }
                p = p.next;
                q = q.next;
            }
            return dummy.next;
        }
    }

    class Solution2 {
        public Node copyRandomList(Node head) {
            Node p = head;
            Map<Node, Node> record = new HashMap<>();
            while (p != null) {
                // 第一次遍历，先把所有节点克隆出来
                record.put(p, new Node(p.val));
                p = p.next;
            }
            p = head;
            while (p != null) {
                // 第二次遍历，把克隆节点的结构连接好
                record.get(p).next = record.get(p.next);
                record.get(p).random = record.get(p.random);
                p = p.next;
            }
            // 返回克隆之后的头结点
            return record.get(head);
        }
    }

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
}