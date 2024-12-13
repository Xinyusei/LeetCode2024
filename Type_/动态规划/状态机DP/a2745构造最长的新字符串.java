package Type_.动态规划.状态机DP;

/**
 * @Author: ZJX
 * @Date: 2024/12/13
 * @Description:
 */
public class a2745构造最长的新字符串 {
    class Solution {
        public int longestString(int x, int y, int z) {
            //最后一维为0表示以AA结束的数量，最后一维为1表示以BB结束的数量，最后一维为2表示以AB结束的数量
            //定义一个4维动态规划数组dp[x+1][y+1][z+1][3], 最后一维为0表示以AA结束的最长长度，最后一维为1表示以BB结束的最长长度，最后一维为2表示以AB结束的最长长度，即：
            //dp[i][j][k][t] 表示最多使用 i 个 “AA"、j 个 “BB" 和 k 个 “AB"，且最后一个子串是类型 t 的子串时的新字符串的最大长度

            int[][][][] dp = new int[x + 1][y + 1][z + 1][3];
            for (int i = 0; i <= x; i++) {
                for (int j = 0; j <= y; j++) {
                    for (int k = 0; k <= z; k++) {
                        //处理当前以AA结束, 那么之前的字符串以BB或者AB结束
                        if (i > 0)
                            dp[i][j][k][0] = 2 + Math.max(dp[i - 1][j][k][1], dp[i - 1][j][k][2]);
                        //如果最后一个字符串是BB，那么之前的字符串以AA结束
                        if (j > 0)
                            dp[i][j][k][1] = 2 + dp[i][j - 1][k][0];
                        //如果最后一个字符串是AB，那么之前的字符串以BB或者AB结束
                        if (k > 0)
                            dp[i][j][k][2] = 2 + Math.max(dp[i][j][k - 1][1], dp[i][j][k - 1][2]);
                    }
                }
            }
            int res = Math.max(dp[x][y][z][0], dp[x][y][z][1]);
            res = Math.max(res, dp[x][y][z][2]);
            return res;
        }
    }
}
