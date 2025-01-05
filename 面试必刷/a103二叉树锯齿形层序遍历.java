package 面试必刷;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/05
 * @Description:
 */
public class a103二叉树锯齿形层序遍历 {
    /**
     * 二叉树BFS模版
     */
    class S1 {
        class Solution {
            public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
                List<List<Integer>> res = new ArrayList<>();
                boolean flag = true;
                if (root == null)
                    return res;
                List<TreeNode> q = new ArrayList<>();
                q.addLast(root);
                while (!q.isEmpty()) {
                    int sz = q.size();
                    List<Integer> curLevel = new ArrayList<>();
                    for (int i = 0; i < sz; i++) {
                        TreeNode curNode = q.removeFirst();
                        if (curNode.left != null)
                            q.addLast(curNode.left);
                        if (curNode.right != null)
                            q.addLast(curNode.right);
                        if (flag)
                            curLevel.addLast(curNode.val);
                        else
                            curLevel.addFirst(curNode.val);
                    }
                    flag = !flag;
                    res.add(curLevel);
                }
                return res;
            }
        }
    }
}
