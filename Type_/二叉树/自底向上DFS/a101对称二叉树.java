package Type_.二叉树.自底向上DFS;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/12
 * @Description:
 */
public class a101对称二叉树 {
    class S1 {
        class Solution {
            public boolean isSymmetric(TreeNode root) {
                return traverse(root.left, root.right);
            }

            public boolean traverse(TreeNode p1, TreeNode p2) {
                if (p1 == null)
                    return p2 == null;
                if (p2 == null)
                    return false;
                if (p1.val != p2.val)
                    return false;
                return traverse(p1.left, p2.right) && traverse(p1.right, p2.left);
            }
        }
    }

    class S2 {
        class Solution {
            public boolean isSymmetric(TreeNode root) {
                return traverse(root.left, root.right);
            }

            public boolean traverse(TreeNode p1, TreeNode p2) {
                if (p1 == null)
                    return p2 == null;
                if (p2 == null)
                    return false;

                boolean left = traverse(p1.left, p2.right);
                boolean right = traverse(p1.right, p2.left);
                if (!left || !right)
                    return false;
                return p1.val == p2.val;
            }
        }
    }
}
