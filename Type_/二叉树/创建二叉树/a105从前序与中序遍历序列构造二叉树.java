package Type_.二叉树.创建二叉树;

import Common.TreeNode;

import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2025/02/12
 * @Description:
 */
public class a105从前序与中序遍历序列构造二叉树 {
    class S1 {
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         * int val;
         * TreeNode left;
         * TreeNode right;
         * TreeNode() {}
         * TreeNode(int val) { this.val = val; }
         * TreeNode(int val, TreeNode left, TreeNode right) {
         * this.val = val;
         * this.left = left;
         * this.right = right;
         * }
         * }
         */
        class Solution {
            HashMap<Integer, Integer> inorderRecord = new HashMap<>();

            public TreeNode buildTree(int[] preorder, int[] inorder) {
                for (int i = 0; i < inorder.length; i++) {
                    inorderRecord.put(inorder[i], i);
                }
                return doBuildTree(preorder, 0, preorder.length - 1,
                        inorder, 0, inorder.length - 1);
            }

            public TreeNode doBuildTree(int[] preorder, int preStart, int preEnd,
                                        int[] inorder, int inStart, int inEnd) {
                //1. 非法情况，返回null
                if (preStart > preEnd)
                    return null;
                //2. 只有一个节点
                if (preStart == preEnd)
                    return new TreeNode(preorder[preStart]);

                //3. 构建根节点
                int val = preorder[preStart];
                TreeNode root = new TreeNode(val);

                int inorderIdx = inorderRecord.get(val);
                int leftCnt = inorderIdx - inStart;

                //3.1 构建左子树
                root.left = doBuildTree(preorder, preStart + 1, preStart + leftCnt,
                        inorder, inStart, inorderIdx - 1);

                root.right = doBuildTree(preorder, preStart + leftCnt + 1, preEnd,
                        inorder, inorderIdx + 1, inEnd);

                //返回
                return root;
            }
        }
    }
}
