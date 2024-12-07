package Type_.动态规划.二_网格图DP.基础;

import java.util.*;

/**
 * 120. 三角形最小路径和
 * https://leetcode.cn/problems/triangle/description/
 */
public class a120三角形最小路径和 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new int[triangle.get(i).size()];
            }


            //1,0 1,1
            //2,0 2,1 2,2
            //3,0 3,1 3,2 3,3
            int res = Integer.MAX_VALUE;
            dp[0][0] = triangle.getFirst().getFirst();
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (j == 0)
                        dp[i][j] = dp[i - 1][j];
                    else if (j == dp[i].length - 1)
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);

                    dp[i][j] += triangle.get(i).get(j);
                }
            }
            for (int j = 0; j < dp[n - 1].length; j++) {
                res = Math.min(res, dp[n - 1][j]);
            }
            return res;
        }
    }
}
