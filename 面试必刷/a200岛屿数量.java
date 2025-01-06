package 面试必刷;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/06
 * @Description:
 */
public class a200岛屿数量 {
    /**
     * DFS -
     */
    class S1 {
        class Solution {

            boolean[][] visited;
            private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            public int numIslands(char[][] grid) {
                int m = grid.length, n = grid[0].length;
                visited = new boolean[m][n];
                int res = 0;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!visited[i][j] && grid[i][j] == '1') {
                            dfs(grid, i, j);
                            res++;
                        }
                    }
                }
                return res;
            }

            public void dfs(char[][] g, int x, int y) {
                int m = g.length, n = g[0].length;
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || g[x][y] == '0')
                    return;

                visited[x][y] = true;
                for (int[] d : dir) {
                    int nx = x + d[0], ny = y + d[1];
                    dfs(g, nx, ny);
                }
            }
        }
    }

    /**
     * BFS
     */
    class S2 {
        class Solution {
            private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int m, n;

            public int numIslands(char[][] grid) {
                this.m = grid.length;
                this.n = grid[0].length;
                int res = 0;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '1') {
                            res++;
                            List<int[]> q = new ArrayList<>();
                            q.addLast(new int[]{i, j});
                            grid[i][j] = '0';
                            bfs(grid, q);
                        }
                    }
                }
                return res;
            }

            private void bfs(char[][] grid, List<int[]> q) {
                while (!q.isEmpty()) {
                    int[] pos = q.removeFirst();
                    int x = pos[0], y = pos[1];
                    for (int[] d : dir) {
                        int nx = x + d[0], ny = y + d[1];
                        if (validGround(grid, nx, ny)) {
                            q.add(new int[]{nx, ny});
                            //置为0，表示已经遍历过
                            grid[nx][ny] = '0';
                        }
                    }
                }
            }

            private boolean validGround(char[][] grid, int x, int y) {
                return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '0';
            }
        }
    }

    /**
     * 并查集 - todo
     */
    class S3 {

    }
}
