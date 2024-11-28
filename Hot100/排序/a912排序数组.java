package Hot100.排序;

import java.util.Random;

/**
 * @Author: ZJX
 * @Date: 2024/11/28
 * @Description:
 */
public class a912排序数组 {
    class Solution {
        private final static Random r = new Random();

        private void sort(int[] nums, int lo, int hi) {
            if (lo >= hi)
                return;
            int idx = partition1(nums, lo, hi);
            sort(nums, lo, idx - 1);
            sort(nums, idx + 1, hi);
        }


        /**
         * 基于交换的思想
         *
         * @param nums
         * @param lo
         * @param hi
         * @return
         * @author ZJX
         * @date 2024/11/28
         */
        private int partition1(int[] nums, int lo, int hi) {
            // 随机选择一个枢纽值，并将其与起始位置的元素交换
            int idx = r.nextInt(lo, hi), pivot = nums[idx];
            swap(nums, idx, lo);
            // 左指针和右指针初始化
            int left = lo, right = hi;
            //pivot左边的元素都应该 <=pivot [lo,left)<=pivot
            //右边的元素都应该 >pivot  (right,hi] > pivot
            while (left < right) {
                while (left < right && nums[right] > pivot) right--;
                // 左指针向右移动，直到找到大于枢纽值的元素
                while (left < right && nums[left] <= pivot) left++;
                // 右指针向左移动，直到找到小于或等于枢纽值的元素
                if (left < right)
                    swap(nums, left, right);
            }
            // 将枢纽值放置到正确的位置
            //left = right
            swap(nums, lo, left);
            // 返回枢纽值的索引
            return left;
        }

        /**
         * 基于填空的思想
         *
         * @param nums
         * @param lo
         * @param hi
         * @return
         * @author ZJX
         * @date 2024/11/28
         */
        private int partition2(int[] nums, int lo, int hi) {
            // 随机选择一个枢纽值，并将其与起始位置的元素交换
            int idx = r.nextInt(lo, hi), pivot = nums[idx];
            swap(nums, idx, lo);
            // 左指针和右指针初始化
            int left = lo, right = hi;
            while (left < right) {
                // 从右向左找小于pivot的元素
                while (left < right && nums[right] > pivot) right--;
                if (left < right) nums[left] = nums[right];
                while (left < right && nums[left] <= pivot) left++;
                if (left < right) nums[right] = nums[left];
            }
            // 将枢纽值放置到正确的位置
            nums[left] = pivot;
            // 返回枢纽值的索引
            return left;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        public int[] sortArray(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return nums;
        }
    }
}
