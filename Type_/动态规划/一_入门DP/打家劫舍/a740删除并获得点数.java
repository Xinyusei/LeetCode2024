package Type_.动态规划.一_入门DP.打家劫舍;

/**
 * 740. 删除并获得点数
 * https://leetcode.cn/problems/delete-and-earn/description/
 */
public class a740删除并获得点数 {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            //删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素，

            //直观：统计每个元素出现次数 -> 某个元素被删除了,相当于这个元素对应的元素和不能选了
            //将 nums[i] - 1  nums[i]  nums[i] + 1 转化为横轴,就变成了打家劫舍问题
            int maxVal = 0;
            //计算最大值
            for (int num : nums)
                maxVal = Math.max(maxVal, num);
            int[] sum = new int[maxVal + 1];
            //计算 每个元素的和
            for (int num : nums)
                sum[num] += num;
            int[] f = new int[maxVal + 1];
            //f[i] 表示nums[0 - i] 删除某点数获得的最大值 ,相当于选了f[i] 不能选 f[i - 1] 和 f[i + 1];
            f[0] = sum[0];
            f[1] = Math.max(sum[0], sum[1]);
            //0 0 2 3 4
            for (int i = 2; i < f.length; i++) {
                f[i] = Math.max(f[i - 1],f[i - 2] + sum[i]);
            }
            return f[maxVal];
        }
    }
}
