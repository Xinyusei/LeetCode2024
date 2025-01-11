package 面试必刷;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/11
 * @Description:
 */
public class a108将有序数组转换为二叉搜索树 {
    /**
     * 二叉树的构建问题遵循固定的套路，构造整棵树可以分解成：先构造根节点，然后构建左右子树。
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
            public TreeNode sortedArrayToBST(int[] nums) {
                return build(nums, 0, nums.length - 1);
            }

            public TreeNode build(int[] nums, int lo, int hi) {
                if (lo > hi)
                    return null;
                if (lo == hi)
                    return new TreeNode(nums[lo]);
                int mid = (hi - lo) / 2 + lo, val = nums[mid];
                TreeNode root = new TreeNode(val);
                root.left = build(nums, lo, mid - 1);
                root.right = build(nums, mid + 1, hi);

                return root;
            }
        }
    }
}
