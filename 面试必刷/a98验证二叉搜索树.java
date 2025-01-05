package 面试必刷;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/05
 * @Description:
 */
public class a98验证二叉搜索树 {

    /**
     * 必须掌握,比较容易想到的方法  - 中序遍历 ，利用BST的中序遍历是一个升序序列
     */
    class S1 {
        class Solution {
            TreeNode pre = null;

            Boolean valid = true;

            public boolean isValidBST(TreeNode root) {
                traverse(root);

                return valid;
            }

            public void traverse(TreeNode node) {
                if (node == null || !valid)
                    return;

                traverse(node.left);

                if (pre != null && pre.val >= node.val) {
                    valid = false;
                    return;
                }
                pre = node;
                traverse(node.right);
            }
        }
    }

    /**
     * 需要一些思考 - 前序遍历 + 辅助变量
     */
    class S2 {
        class Solution {
            public boolean isValidBST(TreeNode root) {
                return check(root, null, null);
            }

            // 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
            public boolean check(TreeNode node, TreeNode min, TreeNode max) {
                // base case
                if (node == null)
                    return true;
                // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
                if (min != null && min.val >= node.val) return false;
                if (max != null && max.val <= node.val) return false;

                // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
                return check(node.left, min, node)
                        && check(node.right, node, max);
            }
        }
    }
}
