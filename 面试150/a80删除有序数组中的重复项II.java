package 面试150;

import java.util.HashMap;

/**
 * @Author: ZJX
 * @Date: 2024/12/19
 * @Description:
 */
public class a80删除有序数组中的重复项II {
    class Solution {
        public int removeDuplicates(int[] nums) {
            /**
             * 删除有序数组重复项的通解
             *
             */
            int k = 2;
            return doRemoveDupilicates(nums, k);
        }

        /**
         * 保留 k 位
         *
         * @param nums 已经排序的数组
         * @param k    保留的位数
         * @return 出现次数超过k次的元素只出现k次，删除后数组的新长度
         * @author ZJX
         * @date 2024/12/19
         */
        private int doRemoveDupilicates(int[] nums, int k) {
            if (nums.length <= k)
                return nums.length;
            int u = 0;
            for (int x : nums) {
                //u 小于 k - 先让前k位直接保留
                //nums[u - k] != x 对k后面的每一位继续遍历，能保留的前提是与  「当前位置的前面k个元素不同」
                if (u < k || nums[u - k] != x)
                    nums[u++] = x;
            }
            return u;
        }
    }
}
