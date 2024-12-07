package Type_.动态规划.二_网格图DP.进阶;

/**
 * @Author: ZJX
 * @Date: 2024/12/03
 * @Description:
 */
public class a329矩阵中的最长递增路径 {
    class Solution {
        public final static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public int[][] memo;

        public int longestIncreasingPath(int[][] s) {
            int m = s.length, n = s[0].length;
            if (s == null || m == 0 || n == 0)
                return 0;
            memo = new int[m][n];
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, dfs(i, j, s));
                }
            }
            return res;
        }

        private int dfs(int x, int y, int[][] s) {
            //找到以x,y为起始点的LIS
            //已经遍历过,返回
            if (memo[x][y] != 0)
                return memo[x][y];

            int res = 1;
            for (int[] d : dir) {
                int nxtX = x + d[0], nxtY = y + d[1];
                //这里指明了方向 ，往合法且递增的方向移动
                if (valid(nxtX, nxtY, s) && s[x][y] < s[nxtX][nxtY]) {
                    res = Math.max(res, dfs(nxtX, nxtY, s) + 1);
                }
            }
            return memo[x][y] = res;
        }

        private boolean valid(int x, int y, int[][] s) {
            //找到以x,y为起始点的LIS
            int m = s.length, n = s[0].length;
            //不合法
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
}
