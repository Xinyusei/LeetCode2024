package Type_.二叉树.直径;

import Common.TreeNode;

import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2025/02/12
 * @Description:
 */
public class a543二叉树的直径 {

    /**
     * 高效
     */
    class S2{
        class Solution {
            int maxDiameter = 0;
            public int diameterOfBinaryTree(TreeNode root) {
                int maxDepth = maxDepth(root);
                return maxDiameter;

            }
            //改造求最大深度的函数
            public int maxDepth(TreeNode node){
                if(node == null)
                    return 0;

                int leftMax = maxDepth(node.left);
                int rightMax = maxDepth(node.right);

                // 后序遍历位置顺便计算最大直径
                maxDiameter = Math.max(maxDiameter,leftMax + rightMax);

                return 1 + Math.max(leftMax , rightMax);
            }
        }
    }
    /**
     * 低效
     */
    class S1 {

        class Solution {
            int res = 0;

            public int diameterOfBinaryTree(TreeNode root) {
                traverse(root);
                return res;
            }

            public void traverse(TreeNode root) {
                if (root == null)
                    return;

                int left = depth(root.left);
                int right = depth(root.right);
                res = Math.max(res, left + right);
                traverse(root.left);
                traverse(root.right);
            }

            public int depth(TreeNode node) {
                if (node == null)
                    return 0;
                return Math.max(depth(node.left), depth(node.right)) + 1;
            }
        }
    }
}
