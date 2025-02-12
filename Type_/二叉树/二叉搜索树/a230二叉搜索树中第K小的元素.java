package Type_.二叉树.二叉搜索树;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/12
 * @Description:
 */
public class a230二叉搜索树中第K小的元素 {
    class S1 {
        class Solution {
            int res = -1; //初始化为非法值
            int rank = 0;
            int targetRank;

            public int kthSmallest(TreeNode root, int k) {
                this.targetRank = k;
                traverse(root);

                return res;
            }

            public void traverse(TreeNode node) {
                if (node == null || res != -1)
                    return;
                //中序遍历
                traverse(node.left);
                rank++;
                if (rank == targetRank) {
                    res = node.val;
                    return;
                }
                traverse(node.right);
            }

        }
    }
}
