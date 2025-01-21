package Type_.动态规划.二_网格图DP.一_基础;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2025/01/21
 * @Description:
 */
public class a64最小路径和 {
    /**
     * DP TABLE
     */

    class S1_1 {
        class Solution {
            public int minPathSum(int[][] grid) {
                int m = grid.length, n = grid[0].length;
                int[][] f = new int[m][n];
                f[0][0] = grid[0][0];
                for (int j = 1; j < n; j++)
                    f[0][j] = f[0][j - 1] + grid[0][j];
                for (int i = 1; i < m; i++)
                    f[i][0] = f[i - 1][0] + grid[i][0];
                //f[i][j] 表示从 0,0到 i，j  的最小路径和
                for (int i = 1; i < m; i++) {
                    for (int j = 1; j < n; j++) {
                        f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + grid[i][j];
                    }
                }
                return f[m - 1][n - 1];
            }
        }
    }

    class S1_2 {
        class Solution {
            public int minPathSum(int[][] grid) {
                int m = grid.length, n = grid[0].length;
                int[][] f = new int[m + 1][n + 1];
                f[0][0] = grid[0][0];
                Arrays.fill(f[0], Integer.MAX_VALUE);
                //f[i][j] 表示从 0,0到 i - 1，j - 1 的最小路径和
                f[0][1] = 0;
                for (int i = 0; i < m; i++) {
                    f[i + 1][0] = Integer.MAX_VALUE;
                    for (int j = 0; j < n; j++) {
                        f[i + 1][j + 1] = Math.min(f[i][j + 1], f[i + 1][j]) + grid[i][j];
                    }
                }
                return f[m][n];
            }
        }
    }

    /**
     * 记忆化搜索 - 从 0,0 到 i，j 的最小路径和
     */
    class S2_1 {
        class Solution {
            int[][] memo;

            public int minPathSum(int[][] grid) {
                int m = grid.length;
                int n = grid[0].length;
                this.memo = new int[m][n];
                for (int[] row : memo) {
                    //-1 代表没有遍历过
                    Arrays.fill(row, -1);
                }
                return dfs(grid, m - 1, n - 1);
            }

            //dfs(g,i,j) 表示从 0,0 到 i，j 的最小路径和
            private int dfs(int[][] g, int i, int j) {
                if (i == 0 && j == 0)
                    return g[0][0];
                if (i < 0 || j < 0) {
                    return Integer.MAX_VALUE;
                }
                if (memo[i][j] != -1)
                    return memo[i][j];

                return memo[i][j] = Math.min(dfs(g, i - 1, j), dfs(g, i, j - 1)) + g[i][j];

            }
        }
    }

    /**
     * 记忆化搜索 - 从i,j 到 右下角的最小路径和
     */
    class S2_2 {
        class Solution {
            int[][] memo;

            public int minPathSum(int[][] grid) {
                int m = grid.length;
                int n = grid[0].length;
                this.memo = new int[m][n];
                for (int[] row : memo) {
                    //-1 代表没有遍历过
                    Arrays.fill(row, -1);
                }
                return dfs(grid, 0, 0);
            }

            //dfs(g,i,j) 表示从i,j 到 m - 1,n - 1(右下角)的最小路径和
            private int dfs(int[][] g, int i, int j) {
                int m = g.length, n = g[0].length;
                if (i == m - 1 && j == n - 1)
                    return g[i][j];
                if (i >= m || j >= n) {
                    return Integer.MAX_VALUE;
                }
                if (memo[i][j] != -1)
                    return memo[i][j];

                return memo[i][j] = Math.min(dfs(g, i + 1, j), dfs(g, i, j + 1)) + g[i][j];

            }
        }
    }


}
