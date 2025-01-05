package 面试必刷;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/01/05
 * @Description:
 */
public class a230二叉搜索树中第K小的元素 {
    class S1 {
        class Solution {
            int rank = 0;

            int res = -1;

            public int kthSmallest(TreeNode root, int k) {
                traverse(root, k);
                return res;
            }

            public void traverse(TreeNode node, int k) {
                if (node == null || res != -1)
                    return;

                traverse(node.left, k);
                rank++;
                if (rank == k){
                    res = node.val;
                    return;
                }
                traverse(node.right, k);
            }
        }
    }
}
