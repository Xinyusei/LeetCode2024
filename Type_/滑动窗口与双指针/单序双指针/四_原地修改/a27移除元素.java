package Type_.滑动窗口与双指针.单序双指针.四_原地修改;

/**
 * @Author: ZJX
 * @Date: 2025/01/26
 * @Description:
 */
public class a27移除元素 {
    class S1 {
        class Solution {
            public int removeElement(int[] nums, int val) {
                int slow = 0, fast = 0;
                for (; fast < nums.length; fast++) {
                    if (nums[fast] != val) {
                        swap(nums, slow, fast);
                        slow++;
                    }
                }
                return slow;
            }

            private void swap(int[] nums, int lo, int hi) {
                int temp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = temp;
            }
        }
    }
}
