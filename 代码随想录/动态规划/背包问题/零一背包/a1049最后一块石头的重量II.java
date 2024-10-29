package 代码随想录.动态规划.背包问题.零一背包;

/**
 * @Author: ZJX
 * @Date: 2024/10/29
 * @Description: <a href="https://leetcode.cn/problems/last-stone-weight-ii/description/">1049最后一块石头的重量II</a>
 */
public class a1049最后一块石头的重量II {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            //思路:
            int s = 0, n = stones.length;
            for (int w : stones) {
                s += w;
            }
            int t = s >> 1;
            int[][] f = new int[n + 1][t + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= t; j++) {
                    if (j >= stones[i - 1])
                        f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - stones[i - 1]] + stones[i - 1]);
                    else
                        f[i][j] = f[i - 1][j];
                }
            }
            return s - f[n][t] * 2;
        }
    }
}
