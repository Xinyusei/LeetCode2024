package Type_.二叉树.回溯;

import Common.TreeNode;

import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2025/02/12
 * @Description:
 */
public class a437路径总和III {
    //todo
    /**
     * 朴素DFS
     */
    class S1 {
        class Solution {
            int target;
            int res = 0;

            public int pathSum(TreeNode root, int targetSum) {
                this.target = targetSum;

                traverse(root);

                return res;
            }

            public void traverse(TreeNode node) {
                if (node == null)
                    return;

                backtrack(node, 0);
                traverse(node.left);
                traverse(node.right);
            }

            public void backtrack(TreeNode node, long val) {
                if (node == null)
                    return;
                val += node.val;
                if (val == target)
                    res++;
                backtrack(node.left, val);
                backtrack(node.right, val);
            }
        }
    }

    /**
     * 前缀和
     */
    class S2 {
        class Solution {
            // 记录前缀和
            // 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
            HashMap<Long, Integer> preSumCount = new HashMap<>();

            long pathSum, targetSum;
            int res = 0;

            public int pathSum(TreeNode root, int targetSum) {
                if (root == null)
                    return 0;
                this.targetSum = targetSum;
                this.pathSum = 0;
                this.preSumCount.put(0L, 1);
                traverse(root);

                return res;
            }

            public void traverse(TreeNode root) {
                if (root == null)
                    return;
                //前序位置
                pathSum += root.val;
                // 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
                res += preSumCount.getOrDefault(pathSum - targetSum, 0);
                // 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
                preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);
                traverse(root.left);
                traverse(root.right);
                preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
                pathSum -= root.val;
            }
        }
    }
}
