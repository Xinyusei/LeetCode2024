package 面试必刷;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/05
 * @Description:
 */
public class a530二叉搜索树的最小绝对差 {

    /**
     * 递归 中序遍历
     */
    class S3 {
        class Solution {
            //非法值
            int pre = -1, res = Integer.MAX_VALUE;

            public int getMinimumDifference(TreeNode root) {
                traverse(root);
                return res;
            }

            public void traverse(TreeNode node) {
                if (node == null)
                    return;

                traverse(node.left);
                if (pre != -1) {
                    res = Math.min(res, node.val - pre);
                }
                pre = node.val;

                traverse(node.right);

            }
        }
    }

    /**
     * 迭代 中序遍历
     */
    class S2 {
        class Solution {
            public int getMinimumDifference(TreeNode root) {
                int pre = -1; //非法值
                List<TreeNode> stack = new ArrayList<>();
                int res = Integer.MAX_VALUE;
                while (root != null || !stack.isEmpty()) {
                    while (root != null) {
                        stack.add(root);
                        root = root.left;
                    }
                    root = stack.removeLast();
                    if (pre != -1) {
                        //最小值 赋值
                        res = Math.min(res, root.val - pre);
                    }
                    pre = root.val;
                    root = root.right;
                }
                return res;
            }
        }
    }

    /**
     * 转化 为数组判断
     */
    class S1 {
        class Solution {
            int res = Integer.MAX_VALUE;

            List<Integer> ls = new ArrayList<>();

            public int getMinimumDifference(TreeNode root) {
                traverse(root);
                for (int i = 1; i < ls.size(); i++) {
                    res = Math.min(res, ls.get(i) - ls.get(i - 1));
                }
                return res;
            }

            public void traverse(TreeNode root) {
                if (root == null)
                    return;

                traverse(root.left);
                ls.add(root.val);

                traverse(root.right);
            }
        }
    }
}
