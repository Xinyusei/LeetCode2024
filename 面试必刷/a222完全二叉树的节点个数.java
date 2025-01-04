package 面试必刷;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/04
 * @Description:
 */
public class a222完全二叉树的节点个数 {


    /**
     * 利用 树高 去计算
     */
    class S2 {
        class Solution {
            public int countNodes(TreeNode root) {
                TreeNode l = root, r = root;
                //记录 左 、 右 子树高度
                int hl = 0, hr = 0;
                while (l != null) {
                    l = l.left;
                    hl++;
                }
                while (r != null) {
                    r = r.right;
                    hr++;
                }
                // 如果左右子树的高度相同，则是一棵满二叉树
                if (hl == hr) {
                    return (int) Math.pow(2, hl) - 1;
                }
                // 如果左右高度不同，则按照普通二叉树的逻辑计算
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        }
    }

    /**
     * BFS - 效率低
     */
    class S1 {
        class Solution {
            public int countNodes(TreeNode root) {
                int res = 0;
                if (root == null)
                    return res;
                List<TreeNode> queue = new ArrayList<>();
                queue.addLast(root);

                while (!queue.isEmpty()) {
                    int sz = queue.size();
                    res += sz;
                    for (int i = 0; i < sz; i++) {
                        TreeNode first = queue.removeFirst();
                        if (first.left != null)
                            queue.addLast(first.left);
                        if (first.right != null)
                            queue.addLast(first.right);
                    }
                }
                return res;
            }
        }
    }
}
