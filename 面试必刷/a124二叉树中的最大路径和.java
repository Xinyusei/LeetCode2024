package 面试必刷;

import Common.TreeNode;

import javax.crypto.MacSpi;
import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2025/01/04
 * @Description:
 */
public class a124二叉树中的最大路径和 {
    class S1 {
        class Solution {
            int mx = Integer.MIN_VALUE;

            public int maxPathSum(TreeNode root) {
                if (root == null)
                    return 0;

                oneSideMax(root);

                return mx;
            }

            // // 定义：计算以 node节点 为起点的最大单边路径和
            public int oneSideMax(TreeNode node) {
                if (node == null)
                    return 0;

                int leftPath = Math.max(oneSideMax(node.left), 0);
                int rightPath = Math.max(oneSideMax(node.right), 0);

                // 后序遍历位置，顺便更新最大路径和
                int pathMax = node.val + leftPath + rightPath;

                // 计算单边路径和时顺便计算最大路径和
                mx = Math.max(mx, pathMax);
                // 实现函数定义，左右子树的最大单边路径和加上根节点的值
                // 就是从根节点 root 为起点的最大单边路径和
                return node.val + Math.max(leftPath, rightPath);
            }
        }
    }
}
