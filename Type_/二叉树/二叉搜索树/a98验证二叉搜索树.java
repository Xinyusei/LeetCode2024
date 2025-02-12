package Type_.二叉树.二叉搜索树;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/12
 * @Description:
 */
public class a98验证二叉搜索树 {
    /**
     * 中序遍历
     * 边遍历边判断
     * 特点：BST的中序遍历是一个单调递增的序列，记录上一个节点即可
     */
    class S1 {
        class Solution {
            Integer pre = null;

            public boolean isValidBST(TreeNode root) {
                if (root == null)
                    return true;
                boolean leftValid = isValidBST(root.left);
                if (!leftValid)
                    return false;
                if (pre != null && pre >= root.val)
                    return false;
                pre = root.val;
                return isValidBST(root.right);
            }
        }
    }

    /**
     * 后序遍历
     * 先遍历后判断
     * 将节点的值向上传递，自底向上
     */
    class S2 {
        class Solution {
            public boolean isValidBST(TreeNode root) {
                return traverse(root)[1] != Long.MAX_VALUE;
            }

            public long[] traverse(TreeNode node) {
                //Long.MIN_VALUE < node && node < Long.MAX_VALUE
                if (node == null)
                    return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
                long[] left = traverse(node.left);
                long[] right = traverse(node.right);
                long x = node.val;
                //node 应该大于 left的最大值，小于right的最小值
                //即 node > left[1] && node < right[0]
                //不满足，则向上传递 false信号，这里即
                long l_min = left[0];
                long l_max = left[1];
                long r_min = right[0];
                long r_max = right[1];
                if (x <= l_max || x >= r_min)
                    //表示 false
                    return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};

                return new long[]{Math.min(l_min, x), Math.max(r_max, x)};
            }
        }
    }

    /**
     * 前序遍历
     * 先判断，再遍历
     * 重点在于：往左子树/右子树走的时候其左/右子树的最大/最小值会发生改变。
     */
    class S3 {
        class Solution {
            public boolean isValidBST(TreeNode root) {
                return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
            }

            public boolean isValidBST(TreeNode node, long min, long max) {
                if (node == null)
                    return true;
                long x = node.val;
                return x > min && x < max &&
                        isValidBST(node.left, min, x) &&
                        isValidBST(node.right, x, max);
            }
        }
    }
}
