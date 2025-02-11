package Type_.二叉树.自底向上DFS;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/11
 * @Description:
 */
public class a226翻转二叉树 {
    /**
     * 自底向上 -后序遍历
     */
    class S1{
        class Solution {
            public TreeNode invertTree(TreeNode root) {
                if(root == null)
                    return null;

                TreeNode left = invertTree(root.left);
                TreeNode right = invertTree(root.right);

                root.left = right;
                root.right = left;

                return root;
            }
        }
    }

    class S2{

        class Solution {
            public TreeNode invertTree(TreeNode root) {
                if(root == null)
                    return null;

                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;

                root.left = invertTree(root.left);
                root.right = invertTree(root.right);

                return root;
            }
        }
    }
}
