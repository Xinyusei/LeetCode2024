package Type_.二叉树.最近公共祖先;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/14
 * @Description:
 */
public class a236二叉树的最近公共祖先 {
    class S1 {
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         * int val;
         * TreeNode left;
         * TreeNode right;
         * TreeNode(int x) { val = x; }
         * }
         */
        class Solution {
            //对于 根为 root 的节点，返回 p 、q 两个节点的最近公共祖先
            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                if (root == null || root == p || root == q)
                    return root;

                TreeNode left = lowestCommonAncestor(root.left, p, q);

                TreeNode right = lowestCommonAncestor(root.right, p, q);

                //p、q分散在root的两侧
                if (left != null && right != null)
                    return root;
                //p、q分散在root的同侧
                return left != null ? left : right;
            }
        }
    }
}
