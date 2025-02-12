package Type_.二叉树.创建二叉树;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2025/02/12
 * @Description:
 */
public class a108将有序数组转换为二叉搜索树 {
    class S1 {
        class Solution {
            public TreeNode sortedArrayToBST(int[] nums) {
                return buildBSFOfRange(nums, 0, nums.length - 1);
            }

            public TreeNode buildBSFOfRange(int[] nums, int start, int end) {
                if (start == end) {
                    return new TreeNode(nums[start]);
                }
                if (start > end)
                    return null;
                int mid = ((end - start) >> 1) + start;
                TreeNode root = new TreeNode(nums[mid]);

                root.left = buildBSFOfRange(nums, start, mid - 1);
                root.right = buildBSFOfRange(nums, mid + 1, end);

                return root;
            }
        }
    }
}
