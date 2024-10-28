package 代码随想录.贪心;

/**
 * @Author: ZJX
 * @Date: 2024/10/19
 * @Description:
 */
public class a376摆动序列 {
    class Solution {
        //dp[i][0]表示，到当前位置，以升序结尾的摆动数组的最长子序列的长度
        //dp[i][1]表示，到当前位置，以降序结尾的摆动数组的最长子序列的长度
        //所以如果当前是升序的话，则当前位置的升序结尾的最长子序列的长度可以由之前的降序最长子序列的长度加1，此时的降序继续继承前一个状态的长度。
        //若当前是降序同理
        public int wiggleMaxLength(int[] nums) {
            //双指针
            int n = nums.length;
            if (n == 1)
                return 1;
            int[][] f = new int[n][2];
            //base case
            f[0][0] = f[0][1] = 1;
            for (int i = 1; i < n; i++) {
                int diff = nums[i] - nums[i - 1];
                //升序
                if (diff > 0) {
                    f[i][1] = f[i - 1][1];
                    f[i][0] = f[i - 1][1] + 1;
                }
                //降序
                else if (diff < 0) {
                    f[i][0] = f[i - 1][0];
                    f[i][1] = f[i - 1][0] + 1;
                }
                //平
                else {
                    f[i][0] = f[i - 1][0];
                    f[i][1] = f[i - 1][1];
                }
            }
            return Math.max(f[n - 1][0], f[n - 1][1]);
        }
    }
}
