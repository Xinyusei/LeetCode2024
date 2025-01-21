package Type_.动态规划.四_经典线性DP.一_最长公共子序列LCS;

/**
 * <a href="https://leetcode.cn/problems/uncrossed-lines/">1035. 不相交的线</a>
 */
public class a1035不相交的线 {
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int m = nums1.length,n = nums2.length;
            int[][] f = new int[m + 1][n + 1];

            int res = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if(nums1[i - 1] == nums2[j - 1])
                        f[i][j] = f[i - 1][j - 1] + 1;
                    else
                        f[i][j] = Math.max(f[i - 1][j],f[i][j - 1]);
                    res = Math.max(res,f[i][j]);
                }
            }
            return res;
        }
    }
}
