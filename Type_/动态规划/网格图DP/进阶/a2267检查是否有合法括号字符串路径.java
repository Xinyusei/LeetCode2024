package Type_.动态规划.二_网格图DP.进阶;

/**
 * @Author: ZJX
 * @Date: 2024/12/06
 * @Description:
 */
public class a2267检查是否有合法括号字符串路径 {
    class Solution {
        int m, n;
        char[][] grid;
        boolean[][][] vis;

        public boolean hasValidPath(char[][] grid) {
            this.m = grid.length;
            this.n = grid[0].length;
            this.grid = grid;
            this.vis = new boolean[m][n][(m + n)];
            if (((m + n) & 1) == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
                return false;
            return dfs(0, 0, 0);
        }


        //表示 从 0,0 开始遍历到 x,y ，是否存在合法的括号路径
        private boolean dfs(int x, int y, int c) {
            //1.排除不合法的坐标
            if (x < 0 || x >= m || y < 0 || y >= n)
                return false;
            //2.
            if (x == m - 1 && y == n - 1) {
                return c == 1;
            }
            if (vis[x][y][c])
                return false;
            vis[x][y][c] = true;
            c += grid[x][y] == '(' ? 1 : -1;
            if (c >= 0) {
                return dfs(x + 1, y, c) || dfs(x, y + 1, c);
            }
            return false;
        }
    }

    class S2 {
        class Solution {
            public boolean hasValidPath(char[][] grid) {
                int m = grid.length, n = grid[0].length;
                if (((m + n) & 1) == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
                    return false;
                int mx_cnt = (m + n + 1) >> 1;
                //f[i][j][c] 代表以grid[i][j]结尾,当前'('剩余个数为c ， 是否是合法字符串
                //相当于 遍历到'(' c + 1, 遍历到')' c - 1。
                boolean[][][] f = new boolean[m][n][mx_cnt];
                f[0][0][1] = true;

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == 0 && j == 0)
                            continue;
                        int t = grid[i][j] == '(' ? 1 : -1;
                        for (int k = 0; k < mx_cnt; k++) {
                            if (k < t || k - t >= mx_cnt)
                                continue;
                            if (i == 0)
                                f[i][j][k] = f[i][j - 1][k - t];
                            else if (j == 0)
                                f[i][j][k] = f[i - 1][j][k - t];
                            else
                                f[i][j][k] = f[i][j - 1][k - t] || f[i - 1][j][k - t];
                        }
                    }
                }
                return f[m - 1][n - 1][0];
            }
        }
    }
}
