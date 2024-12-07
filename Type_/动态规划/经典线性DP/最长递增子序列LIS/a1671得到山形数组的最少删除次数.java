package Type_.动态规划.经典线性DP.最长递增子序列LIS;

/**
 * @Author: ZJX
 * @Date: 2024/12/07
 * @Description:
 */
public class a1671得到山形数组的最少删除次数 {
    class Solution {
        //找出最长 山形子序列的长度
        public int minimumMountainRemovals(int[] nums) {
            //定义 pre[] suf[]
            int n = nums.length;
            int res = 0;
            int[] lis = lis(nums);
            int[] lds = lds(nums);
            for (int i = 1; i < nums.length - 1; i++) {
                int pre = lis[i], suf = lds[i];
                //去找以 索引为 i,即 值为 x的数 结尾的最长递增子序列长度 和 以x开头的最长递减子序列长度
                if (pre >= 2 && suf >= 2) {
                    res = Math.max(pre + suf - 1, res);
                }
            }
            return n - res;
        }


        private int[] lis(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            f[0] = 1;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j])
                        f[i] = Math.max(f[i], f[j]);
                }
                f[i]++;
            }
            return f;
        }

        private int[] lds(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            f[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] > nums[j])
                        f[i] = Math.max(f[i], f[j]);
                }
                f[i]++;
            }
            return f;
        }
    }
}
