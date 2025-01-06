package 面试必刷;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/06
 * @Description:
 */
public class a133克隆图 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * DFS
     */
    class S1 {
        class Solution {
            // 记录原节点到克隆节点的映射
            HashMap<Node, Node> record = new HashMap<>();

            public Node cloneGraph(Node node) {
                if (node == null)
                    return null;
                return traverse(node);
            }

            Node traverse(Node node) {
                if (node == null)
                    return null;
                if (record.containsKey(node))
                    return record.get(node);

                Node cloneNode = new Node(node.val, new ArrayList<>());
                record.put(node, cloneNode);

                for (Node neighbor : node.neighbors) {
                    Node cloneNeighborNode = traverse(neighbor);
                    cloneNode.neighbors.add(cloneNeighborNode);
                }

                return cloneNode;
            }
        }

    }

    /**
     * BFS
     */
    class S2 {
        class Solution {
            public Node cloneGraph(Node node) {
                if (node == null)
                    return null;
                HashMap<Node, Node> record = new HashMap<>();
                List<Node> queue = new ArrayList<>();
                queue.add(node);
                // 克隆第一个节点并存储到哈希表中
                record.put(node, new Node(node.val, new ArrayList<>()));
                //bfs
                while (!queue.isEmpty()) {
                    //取出队列头结点
                    Node first = queue.removeFirst();
                    for (Node neighbor : first.neighbors) {
                        //如果当前 节点没有访问过
                        if (!record.containsKey(neighbor)) {
                            // 如果没有被访问过，就克隆并存储在哈希表中
                            Node cloneNeighborNode = new Node(neighbor.val, new ArrayList<>());
                            record.put(neighbor, cloneNeighborNode);
                            //将 领居节点添加到队列中
                            queue.add(neighbor);
                        }
                        // 更新当前克隆节点的邻居列表
                        record.get(first).neighbors.add(record.get(neighbor));
                    }
                }
                return record.get(node);
            }
        }
    }
}
