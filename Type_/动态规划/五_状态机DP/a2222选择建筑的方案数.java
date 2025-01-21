package Type_.动态规划.五_状态机DP;

/**
 * @Author: ZJX
 * @Date: 2024/12/18
 * @Description:
 */
public class a2222选择建筑的方案数 {
    class Solution {
        public long numberOfWays(String s) {
            char[] cs = s.toCharArray();
            int k = 3;
            long[][][] f = new long[cs.length + 1][k + 1][2];
            //f[i][j][0/1] 表示从前 i 个数中进行选择，选择 j 栋建筑 且以'0'/'1'结尾的有效方案数

            for (int i = 1; i <= cs.length; i++) {
                //base case 边界条件, 0 栋建筑 方案数为 1
                f[i - 1][0][0] = 1;
                f[i - 1][0][1] = 1;
                for (int j = 1; j <= k; j++) {
                    if (cs[i - 1] == '1') {
                        f[i][j][1] = f[i - 1][j - 1][0] + f[i - 1][j][1];
                        f[i][j][0] = f[i - 1][j][0];
                    } else {
                        f[i][j][0] += f[i - 1][j - 1][1] + f[i - 1][j][0];
                        f[i][j][1] = f[i - 1][j][1];
                    }
                }
            }
            return f[cs.length][k][0] + f[cs.length][k][1];
        }
    }
}
