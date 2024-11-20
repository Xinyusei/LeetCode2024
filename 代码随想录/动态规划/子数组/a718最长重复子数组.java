package 代码随想录.动态规划.子数组;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/11/17
 * @Description:
 */
public class a718最长重复子数组 {
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length;
            int[][] f = new int[n1 + 1][n2 + 1];
            int ret = 0;
            //f[i][j] 表示 nums1[i - 1]结尾与nums2[j - 1] 结尾公共的长度最长的子数组的长度
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    if (nums1[i - 1] == nums2[j - 1])
                        f[i][j] = f[i - 1][j - 1] + 1;
                    ret = Math.max(ret, f[i][j]);
                }

            }
            System.out.println(Arrays.deepToString(f));
            return ret;
        }
    }
}
