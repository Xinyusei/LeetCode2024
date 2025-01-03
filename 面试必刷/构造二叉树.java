package 面试必刷;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2025/01/03
 * @Description:
 */
public class 构造二叉树 {
    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
     */
    class S1_Type1 {
        /**
         * 优化点 - 用Map提前存下 inorder的val - index 记录
         */
        class Solution {
            //使用Map来优化： 存储 inorder 中值到索引的映射
            Map<Integer, Integer> inorderRecord = new HashMap<>();

            //preorder 前序
            //inorder 中序
            public TreeNode buildTree(int[] preorder, int[] inorder) {
                for (int i = 0; i < inorder.length; i++) {
                    inorderRecord.put(inorder[i], i);
                }
                return constructNode(preorder, 0, preorder.length - 1,
                        inorder, 0, inorder.length - 1);
            }


            // 定义：前序遍历数组为 preorder[preStart..preEnd]
            // 中序遍历数组为 inorder[inStart..inEnd]
            // 构造这个二叉树并返回该二叉树的根节点
            public TreeNode constructNode(int[] preorder, int preStart, int preEnd,
                                          int[] inorder, int inStart, int inEnd) {
                if (preStart > preEnd || inStart > inEnd)
                    return null;
                int rootVal = preorder[preStart];
                TreeNode root = new TreeNode(rootVal);
                /*int idx;
                for (idx = inStart; idx < inEnd; idx++) {
                    if (inorder[idx] == rootVal)
                        break;
                }*/
                int idx = inorderRecord.get(rootVal);
                //int idx = inorderRecord.get(rootVal);
                //3 9 10 20 15 7
                //9 10 3 15 20 7
                int leftTreeCnt = idx - inStart, righTreeCnt = inEnd - idx;
                //索引 + 个数
                //对于 preorder : preStart preStart + 1 preEnd
                root.left = constructNode(preorder, preStart + 1, preStart + leftTreeCnt,
                        inorder, inStart, idx - 1);
                root.right = constructNode(preorder, preEnd - righTreeCnt + 1, preEnd,
                        inorder, idx + 1, inEnd);
                return root;
            }
        }
    }


    /**
     * 106. 从中序与后序遍历序列构造二叉树
     * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
     */
    class S2_Type2 {
        class Solution {
            Map<Integer, Integer> inorderRecord = new HashMap<>();

            public TreeNode buildTree(int[] inorder, int[] postorder) {
                for (int i = 0; i < inorder.length; i++) {
                    inorderRecord.put(inorder[i], i);
                }
                return construct(postorder, 0, postorder.length - 1,
                        inorder, 0, inorder.length - 1);
            }

            public TreeNode construct(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
                //base case
                if (postStart > postEnd || inStart > inEnd)
                    return null;

                int rootVal = postorder[postEnd];
                int idx = inorderRecord.get(rootVal);
                int rightTreeCnt = inEnd - idx, leftTreeCnt = idx - inStart;

                TreeNode root = new TreeNode(rootVal);

                root.right = construct(postorder, postEnd - rightTreeCnt, postEnd - 1,
                        inorder, idx + 1, inEnd);
                root.left = construct(postorder, postStart, postStart + leftTreeCnt,
                        inorder, inStart, idx - 1);

                return root;
            }
        }
    }
}
