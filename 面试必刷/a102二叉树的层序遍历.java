package 面试必刷;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/05
 * @Description:
 */
public class a102二叉树的层序遍历 {
    /**
     * BFS - 模版
     */
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
            public List<List<Integer>> levelOrder(TreeNode root) {
                List<List<Integer>> res = new ArrayList<>();
                if (root == null)
                    return res;
                List<TreeNode> q = new ArrayList<>();
                q.addLast(root);
                while (!q.isEmpty()) {
                    int sz = q.size();
                    List<Integer> curLevel = new ArrayList<>();
                    for (int i = 0; i < sz; i++) {
                        TreeNode curNode = q.removeFirst();
                        if (curNode.left != null)
                            q.addLast(curNode.left);
                        if (curNode.right != null)
                            q.addLast(curNode.right);
                        curLevel.add(curNode.val);
                    }
                    res.add(curLevel);
                }
                return res;
            }
        }
    }
}
