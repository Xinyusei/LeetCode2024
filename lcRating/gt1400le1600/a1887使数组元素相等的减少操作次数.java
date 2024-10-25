package lcRating.gt1400le1600;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/10/25
 * @Description:
 */
public class a1887使数组元素相等的减少操作次数 {
    class Solution {
        public int reductionOperations(int[] nums) {
            //1,3,5
            Arrays.sort(nums);
            int ret = 0;
            int cnt = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    cnt += 1;
                }
                ret += cnt;
            }
            return ret;
        }
    }

    class Solution2 {
        public int reductionOperations(int[] nums) {
            //1,3,5
            int minValue = Integer.MAX_VALUE;
            int[] cnt = new int[50001];
            for (int num : nums) {
                cnt[num]++;
                minValue = Math.min(minValue, num);
            }
            int ret = 0;
            int sum = 0;
            for (int i = cnt.length - 1; i >= 0; i--) {
                if (cnt[i] != 0 && i != minValue) {
                    sum += cnt[i];
                    ret += sum;
                }
            }
            //2,2 3,1
            return ret;
        }
    }
}
