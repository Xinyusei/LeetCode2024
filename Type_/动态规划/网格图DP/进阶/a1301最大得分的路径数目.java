package Type_.动态规划.二_网格图DP.进阶;

import java.util.List;

/**
 * 1301. 最大得分的路径数目
 * https://leetcode.cn/problems/number-of-paths-with-max-score/description/
 */
public class a1301最大得分的路径数目 {
    class Solution {
        static final int MOD = (int) 1e9 + 7;
        static int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

        //E,2,3
        //2,X,2
        //1,2,S
        public int[] pathsWithMaxScore(List<String> board) {
            int n = board.size();
            int[][][] f = new int[n][n][2];
            //f[x][y][0] 表示达到x,y的最大得分,f[x][y][1]表示得到该得分的方案数
            f[n - 1][n - 1][0] = 0;
            f[n - 1][n - 1][1] = 1;
            for (int i = n - 2; i >= 0 && board.get(i).charAt(n - 1) != 'X'; i--) {
                f[i][n - 1][0] = f[i + 1][n - 1][0] + (board.get(i).charAt(n - 1) - '0');
                f[i][n - 1][1] = 1;
            }
            for (int j = n - 2; j >= 0 && board.get(n - 1).charAt(j) != 'X'; j--) {
                f[n - 1][j][0] = f[n - 1][j + 1][0] + (board.get(n - 1).charAt(j) - '0');
                f[n - 1][j][1] = 1;
            }
            //E,2,3
            //2,X,2
            //1,2,S
            for (int i = n - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    char c = board.get(i).charAt(j);
                    if (c == 'X')
                        continue;
                    int prevMax = 0;
                    for (int[] d : dirs)
                        prevMax = Math.max(prevMax, f[i + d[0]][j + d[1]][0]);
                    for (int[] d : dirs) {
                        if (prevMax == f[i + d[0]][j + d[1]][0]) {
                            f[i][j][1] = (f[i][j][1] + f[i + d[0]][j + d[1]][1]) % MOD;
                        }
                    }
                    if (f[i][j][1] > 0) {
                        //Character.isDigit(c) 是 Java 语言中 Character 类的一个静态方法
                        //用于判断指定的字符是否为数字字符。这里的 c 是你需要检查的字符。
                        int curr = Character.isDigit(c) ? c - '0' : 0;
                        f[i][j][0] = prevMax + curr;
                    }
                }
            }
            //E,X
            //X,S

            //5,1  5,1,  5,1
            //3,1 -1,-1, 2,1
            //3,1  2,1   0,0
            //System.out.println(Arrays.deepToString(f));
            return f[0][0];
        }
    }
}
