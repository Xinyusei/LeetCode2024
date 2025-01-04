package 面试必刷;

import Common.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/04
 * @Description:
 */
public class a173二叉搜索树迭代器 {
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
        class BSTIterator {
            List<TreeNode> stack;


            public BSTIterator(TreeNode root) {
                stack = new ArrayList<>();
                pushLeftBranch(root);
            }

            //将左侧树枝都加入栈中
            private void pushLeftBranch(TreeNode p) {
                while (p != null) {
                    stack.addLast(p);
                    p = p.left;
                }
            }

            //7 3
            public int next() {
                TreeNode node = stack.removeLast();
                pushLeftBranch(node.right);
                return node.val;
            }

            public boolean hasNext() {
                return !stack.isEmpty();
            }
        }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
    }
}
