package 面试必刷;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/04
 * @Description:
 */
public class a129求根节点到叶节点数字之和 {
    class S1 {
        class Solution {
            int res = 0;
            int path = 0;

            public int sumNumbers(TreeNode root) {
                traverse(root);

                return res;
            }

            public void traverse(TreeNode node) {
                if (node == null)
                    return;

                int v = node.val;
                path = path * 10 + v;

                if (node.left == node.right)
                    res += path;

                traverse(node.left);
                traverse(node.right);

                path = (path - v) / 10;
            }
        }
    }
}
