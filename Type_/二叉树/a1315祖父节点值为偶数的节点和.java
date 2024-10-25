package Type_.二叉树;

import Common.TreeNode;

/**
 * 1315. 祖父节点值为偶数的节点和
 * https://leetcode.cn/problems/sum-of-nodes-with-even-valued-grandparent/description/
 */
public class a1315祖父节点值为偶数的节点和 {

    class Solution {
        public int sum = 0;

        public int sumEvenGrandparent(TreeNode root) {
            //traverse1(root, null, null);
            traverse2(root);
            return sum;
        }

        /**
         * 往前面看
         *
         * @param root
         * @param parent
         * @param grandpa
         */
        public void traverse1(TreeNode root, TreeNode parent, TreeNode grandpa) {
            if (root == null) return;
            if (grandpa != null && (grandpa.val & 1) == 0) {
                sum += root.val;
            }
            traverse1(root.left, root, parent);
            traverse1(root.right, root, parent);
        }

        /**
         * 往后面看
         *
         * @param root
         */
        public void traverse2(TreeNode root) {
            if (root == null) return;
            if ((root.val & 1) == 0) {
                TreeNode lNode = root.left;
                if (lNode != null) {
                    TreeNode llNode = lNode.left;
                    TreeNode lrNode = lNode.right;
                    if (llNode != null) sum += llNode.val;
                    if (lrNode != null) sum += lrNode.val;
                }
                TreeNode rNode = root.right;
                if (rNode != null) {
                    TreeNode rlNode = rNode.left;
                    TreeNode rrNode = rNode.right;
                    if (rlNode != null) sum += rlNode.val;
                    if (rrNode != null) sum += rrNode.val;
                }
            }
            traverse2(root.left);
            traverse2(root.right);
        }
    }
}
