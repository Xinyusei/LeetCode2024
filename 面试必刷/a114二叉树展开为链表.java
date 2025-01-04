package 面试必刷;

import Common.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/04
 * @Description:
 */
public class a114二叉树展开为链表 {
    /**
     * 递归 来做
     */
    class S1 {
        class Solution {
            public void flatten(TreeNode root) {
                if (root == null)
                    return;
                //1
                //2 3 4
                //5 6
                flatten(root.left);
                flatten(root.right);

                if (root.left == null)
                    return;
                TreeNode last = root.left;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }

    /**
     * 迭代版本的 前序遍历来做
     */
    class S2 {
        class Solution {
            public void flatten(TreeNode root) {
                if (root == null)
                    return;
                preorderTraverse(root);
            }

            public void preorderTraverse(TreeNode root) {
                List<TreeNode> list = new ArrayList<>();
                List<TreeNode> stack = new ArrayList<>();
                TreeNode node = root;
                while (node != null || !stack.isEmpty()) {
                    //左子树
                    while (node != null) {
                        list.addLast(node);
                        stack.addLast(node);
                        node = node.left;
                    }
                    //根
                    node = stack.removeLast();
                    //右子树
                    node = node.right;
                }
                for (int i = 1; i < list.size(); i++) {
                    TreeNode prev = list.get(i - 1), cur = list.get(i);
                    prev.left = null;
                    prev.right = cur;
                }
            }
        }
    }
}
