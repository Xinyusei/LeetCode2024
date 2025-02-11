package Type_.二叉树.遍历二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a144二叉树的前序遍历 {
    /**
     * 二叉树的前序遍历
     */
    class S1{
        class Solution {
            public List<Integer> preorderTraversal(TreeNode root) {
                List<Integer> res = new ArrayList<>();
                List<TreeNode> stack = new LinkedList<>();
                while(root != null || !stack.isEmpty()){
                    while(root != null){
                        res.add(root.val);
                        stack.add(root);
                        root = root.left;
                    }
                    root = stack.removeLast();
                    root = root.right;
                }
                return res;
            }
        }
    }

    /**
     * 二叉树的中序遍历
     */
    class S2{
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode() {}
         *     TreeNode(int val) { this.val = val; }
         *     TreeNode(int val, TreeNode left, TreeNode right) {
         *         this.val = val;
         *         this.left = left;
         *         this.right = right;
         *     }
         * }
         */
        class Solution {
            public List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> res = new ArrayList<>();
                List<TreeNode> stack = new LinkedList<>();
                while(root != null || !stack.isEmpty()){
                    while(root != null){
                        stack.add(root);
                        root = root.left;
                    }
                    root = stack.removeLast();
                    res.add(root.val);
                    root = root.right;
                }
                return res;
            }
        }
    }

    /**
     * 二叉树的后序遍历
     */
    class S3{
        class Solution {
            TreeNode prev = null;
            public List<Integer> postorderTraversal(TreeNode root) {
                List<Integer> res = new ArrayList<>();
                List<TreeNode> stack = new LinkedList<>();
                while(root != null || !stack.isEmpty()){
                    while(root != null){
                        stack.add(root);
                        root = root.left;
                    }
                    root = stack.removeLast();
                    if(root.right == null || root.right == prev){
                        res.add(root.val);
                        prev = root;
                        root = null;
                    }
                    else {
                        stack.add(root);
                        root = root.right;
                    }
                }
                return res;
            }
        }
    }
}
