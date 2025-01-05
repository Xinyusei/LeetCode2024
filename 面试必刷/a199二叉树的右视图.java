package 面试必刷;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/05
 * @Description:
 */
public class a199二叉树的右视图 {
    /**
     * DFS - 要思考
     */
    class S1 {
        class Solution {
            List<Integer> res = new ArrayList<>();
            int depth = 0;

            public List<Integer> rightSideView(TreeNode root) {
                traverse(root);
                return res;
            }

            public void traverse(TreeNode node) {
                if (node == null)
                    return;

                depth++;
                if (res.size() < depth)
                    res.add(node.val);
                traverse(node.right);
                traverse(node.left);
                depth--;
            }
        }
    }

    /**
     * BFS - 模版
     */
    class S2 {
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
}
