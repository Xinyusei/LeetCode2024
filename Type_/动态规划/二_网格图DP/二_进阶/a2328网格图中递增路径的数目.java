package Type_.动态规划.二_网格图DP.二_进阶;

/**
 * @Author: ZJX
 * @Date: 2024/12/03
 * @Description:
 */
public class a2328网格图中递增路径的数目 {
    class Solution {
        public static final int mod = (int) 1e9 + 7;
        int[][] f;
        public final static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int countPaths(int[][] s) {
            int m = s.length, n = s[0].length;
            f = new int[m][n];
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res = (res + dfs(i, j, s)) % mod;
                }
            }
            return res;
        }

        private int dfs(int x, int y, int[][] s) {
            //找到以x,y为起始点的LIS
            if (f[x][y] != 0)
                return f[x][y];

            int res = 1;
            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                //指明方向 往 合法 且 大于当前值的方向移动
                if (valid(nx, ny, s) && s[nx][ny] > s[x][y]) {
                    res = (res % mod + dfs(nx, ny, s) % mod) % mod;
                }
            }
            return f[x][y] = res;
        }

        private boolean valid(int x, int y, int[][] s) {

            int m = s.length, n = s[0].length;
            //不合法
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
}
