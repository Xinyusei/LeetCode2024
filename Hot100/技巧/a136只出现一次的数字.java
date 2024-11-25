package Hot100.技巧;

/**
 * @Author: ZJX
 * @Date: 2024/11/25
 * @Description:
 */
public class a136只出现一次的数字 {
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;
        }
    }
}
