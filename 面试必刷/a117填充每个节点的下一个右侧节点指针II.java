package 面试必刷;

import Common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/04
 * @Description:
 */
public class a117填充每个节点的下一个右侧节点指针II {
    /**
     * BFS - 队列
     */
    class S1 {
        class Solution {
            public Node connect(Node root) {
                if (root == null)
                    return null;
                List<Node> queue = new ArrayList<>();
                queue.add(root);

                while (!queue.isEmpty()) {
                    int sz = queue.size();
                    for (int i = 0; i < sz; i++) {
                        Node node = queue.removeFirst();
                        if (i != sz - 1) {
                            node.next = queue.isEmpty() ? null : queue.getFirst();
                        }
                        if (node.left != null)
                            queue.add(node.left);
                        if (node.right != null)
                            queue.add(node.right);
                    }
                }
                return root;
            }
        }
    }
}
