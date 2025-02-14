package Type_.二叉树.直径;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/14
 * @Description:
 */
public class a124二叉树中的最大路径和 {
    class S1 {
        class Solution {
            private int res;

            public int maxPathSum(TreeNode root) {
                this.res = Integer.MIN_VALUE;

                traverse(root);
                return res;
            }

            //经过node的最大路径和
            public int traverse(TreeNode node) {
                if (node == null)
                    return 0;

                int leftMax = Math.max(traverse(node.left), 0);
                int rightMax = Math.max(traverse(node.right), 0);

                res = Math.max(res, leftMax + rightMax + node.val);

                return Math.max(leftMax, rightMax) + node.val;
            }
        }
    }
}
