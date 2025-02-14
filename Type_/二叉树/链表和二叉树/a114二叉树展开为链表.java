package Type_.二叉树.链表和二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/12
 * @Description:
 */
public class a114二叉树展开为链表 {
    /**
     * 递归
     */
    class S1 {
        class Solution {
            //flatten 函数：将root为根的二叉树展开为链表（与先序遍历相同）
            public void flatten(TreeNode root) {
                if (root == null)
                    return;

                //1. 把 左子树 拉直
                flatten(root.left);

                //2. 把 右子树 拉直
                flatten(root.right);

                TreeNode left = root.left;
                if(left == null)
                    return;
                while (left.left != left.right) {
                    left = left.right;
                }

                left.right = root.right;
                root.right = root.left;
                root.left = null;

            }
        }
    }


    class S2{
        class Solution {
            public void flatten(TreeNode root) {
                List<TreeNode> stack = new LinkedList<>();
                List<TreeNode> nodeList = new ArrayList<>();
                while(root != null || !stack.isEmpty()){
                    //左
                    while(root != null){
                        nodeList.add(root);
                        stack.add(root);
                        root = root.left;
                    }
                    //根
                    root = stack.removeLast();
                    //右
                    root = root.right;
                }
                for (int i = 1; i < nodeList.size(); i++) {
                    TreeNode prev = nodeList.get(i - 1);
                    TreeNode cur = nodeList.get(i);
                    prev.left = null;
                    prev.right = cur;
                }
            }
        }
    }
}
