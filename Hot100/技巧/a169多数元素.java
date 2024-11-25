package Hot100.技巧;

/**
 * @Author: ZJX
 * @Date: 2024/11/26
 * @Description:
 */
public class a169多数元素 {
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 1;
            int type = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    type = nums[i];
                    count = 1;
                } else {
                    if (nums[i] == type)
                        count++;
                    else
                        count--;
                }
            }
            return type;
        }
    }
}
