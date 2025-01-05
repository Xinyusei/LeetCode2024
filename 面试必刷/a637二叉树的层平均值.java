package 面试必刷;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/05
 * @Description:
 */
public class a637二叉树的层平均值 {
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            List<TreeNode> q = new ArrayList<>();
            q.addLast(root);
            while (!q.isEmpty()) {
                int sz = q.size();
                long sum = 0;
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.removeFirst();
                    sum += cur.val;
                    if (cur.left != null)
                        q.addLast(cur.left);
                    if (cur.right != null)
                        q.addLast(cur.right);
                }
                res.add(sum * 1.0 / sz);
            }
            return res;
        }
    }
}
