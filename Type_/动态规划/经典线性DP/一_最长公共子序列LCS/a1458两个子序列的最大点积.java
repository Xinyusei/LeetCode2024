package Type_.动态规划.经典线性DP.一_最长公共子序列LCS;

import java.util.Arrays;

/**
 *
 * <a href="https://leetcode.cn/problems/max-dot-product-of-two-subsequences/description/">1458. 两个子序列的最大点积</a>
 */
public class a1458两个子序列的最大点积 {
    class Solution {
        //转换为最长公共子序列 选 / 不选
        public int maxDotProduct(int[] nums1, int[] nums2) {
            int m = nums1.length,n = nums2.length;
            int[][] f = new int[m + 1][n + 1];
            for(int i = 0 ;i <= m;i ++){
                Arrays.fill(f[i],Integer.MIN_VALUE / 2);
            }

            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    int dot = nums1[i - 1] * nums2[j - 1];
                    f[i][j] = Math.max(Math.max(Math.max(dot,dot + f[i - 1][j - 1]),f[i - 1][j]), f[i][j - 1]);
                }
            }
            System.out.println(Arrays.deepToString(f));
            return f[m][n];
        }
    }
}
