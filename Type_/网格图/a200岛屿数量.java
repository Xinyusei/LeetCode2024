package Type_.网格图;

import java.util.LinkedList;
import java.util.List;

/**
 * 200. 岛屿数量
 * <a href="https://leetcode.cn/problems/number-of-islands/description/">...</a>
 */
public class a200岛屿数量 {
    private class BFS {
        boolean[][] visited;
        int row, col, result = 0;

        int[][] dir;

        public int numIslands(char[][] grid) {
            this.row = grid.length;
            this.col = grid[0].length;
            this.dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        bfs(grid, i, j);
                        result++;
                    }
                }
            }

            return result;
        }

        public void bfs(char[][] grid, int x, int y) {
            List<int[]> queue = new LinkedList<>();
            queue.addLast(new int[]{x, y});
            visited[x][y] = true;
            while (!queue.isEmpty()) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    int[] p = queue.removeFirst();
                    int curX = p[0], curY = p[1];
                    for (int[] d : dir) {
                        int nextX = curX + d[0];
                        int nextY = curY + d[1];
                        if (nextX < 0 || nextX >= col || nextY < 0 || nextY >= row) continue;
                        if (grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                            queue.add(new int[]{nextX, nextY});
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }


    }

    private class DFS {
        boolean[][] visited;
        int row, col, result = 0;
        int[][] dir;

        public int numIslands(char[][] grid) {
            this.row = grid.length;
            this.col = grid[0].length;
            this.dir = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
            visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        dfs(grid, i, j);
                        result++;
                    }
                }
            }

            return result;
        }

        public void dfs(char[][] g, int x, int y) {
            this.row = g.length;
            this.col = g[0].length;
            if (x < 0 || x >= row || y < 0 || y >= col)
                return;
            if (visited[x][y] || g[x][y] == '0')
                return;

            visited[x][y] = true;
            for (int[] d : dir) {
                dfs(g, x + d[0], y + d[1]);
            }
        }
    }
}
