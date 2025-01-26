package Type_.滑动窗口与双指针.单序双指针.四_原地修改;

/**
 * @Author: ZJX
 * @Date: 2025/01/26
 * @Description:
 */
public class a283移动零 {
    class S1 {
        class Solution {
            public void moveZeroes(int[] nums) {
                int slow = 0, fast = 0;
                while (fast < nums.length) {
                    if (nums[fast] != 0) {
                        swap(nums, slow, fast);
                    }
                    fast++;
                }
            }

            private void swap(int[] nums, int lo, int hi) {
                int temp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = temp;
            }
        }
    }

    class S2 {
        class Solution {
            public void moveZeroes(int[] nums) {
                int slow = 0, fast = 0;
                while (fast < nums.length) {
                    if (nums[fast] != 0) {
                        nums[slow] = nums[fast];
                        slow++;
                    }
                    fast++;
                }
                while (slow < nums.length) {
                    nums[slow] = 0;
                    slow++;
                }
            }
        }
    }
}
