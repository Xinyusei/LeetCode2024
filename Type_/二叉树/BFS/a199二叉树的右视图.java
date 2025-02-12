package Type_.二叉树.BFS;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/12
 * @Description:
 */
public class a199二叉树的右视图 {
    /**
     * BFS 模版
     */
    class S1 {
        class Solution {
            public List<Integer> rightSideView(TreeNode root) {
                List<Integer> res = new ArrayList<>();
                if (root == null)
                    return res;
                List<TreeNode> q = new ArrayList<>();
                q.addLast(root);
                while (!q.isEmpty()) {
                    int sz = q.size();
                    for (int i = 0; i < sz; i++) {
                        TreeNode cur = q.removeFirst();
                        if (i == 0)
                            res.addLast(cur.val);
                        if (cur.right != null)
                            q.addLast(cur.right);
                        if (cur.left != null)
                            q.addLast(cur.left);
                    }
                }
                return res;
            }
        }
    }

    /**
     * DFS
     */
    class S2 {
        class Solution {
            List<Integer> res = new ArrayList<>();

            public List<Integer> rightSideView(TreeNode root) {
                traverse(root, 0);
                return res;
            }

            public void traverse(TreeNode node, int depth) {
                if (node == null)
                    return;
                if (res.size() == depth)
                    res.add(node.val);
                traverse(node.right, depth + 1);
                traverse(node.left, depth + 1);
            }
        }
    }
}
