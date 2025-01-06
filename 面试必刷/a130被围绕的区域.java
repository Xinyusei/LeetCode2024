package 面试必刷;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/06
 * @Description:
 */
public class a130被围绕的区域 {

    /**
     * DFS
     */
    class S1 {
        class Solution {
            private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            int m, n;

            public void solve(char[][] g) {
                this.m = g.length;
                this.n = g[0].length;


                //于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O ,将其标记为 T
                for (int i = 0; i < m; i++) {
                    dfs(g, i, 0);
                    dfs(g, i, n - 1);


                }
                for (int j = 0; j < n; j++) {
                    dfs(g, 0, j);
                    dfs(g, m - 1, j);
                }

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        //如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。
                        if (g[i][j] == 'O')
                            g[i][j] = 'X';
                            //如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
                        else if (g[i][j] == 'T')
                            g[i][j] = 'O';
                    }
                }
            }


            //
            private void dfs(char[][] g, int x, int y) {
                if (x < 0 || x >= m || y < 0 || y >= n || g[x][y] != 'O')
                    return;
                g[x][y] = 'T';

                for (int[] d : dir) {
                    dfs(g, x + d[0], y + d[1]);
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

            public void solve(char[][] g) {
                this.m = g.length;
                this.n = g[0].length;

                //于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O ,将其标记为 T
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (g[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1)){
                            bfs(g, i, j);
                            g[i][j] = 'T';
                        }
                    }
                }


                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        //如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。
                        if (g[i][j] == 'O')
                            g[i][j] = 'X';
                            //如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
                        else if (g[i][j] == 'T')
                            g[i][j] = 'O';
                    }
                }
            }

            //找到与边界直接或者间接相连接的'O' 将其标记为'T'
            private void bfs(char[][] board, int x, int y) {
                List<int[]> queue = new ArrayList<>();
                queue.add(new int[]{x, y});
                while (!queue.isEmpty()) {
                    int[] p = queue.removeFirst();
                    for (int[] d : dir) {
                        int nx = p[0] + d[0], ny = p[1] + d[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n || board[nx][ny] != 'O')
                            continue;
                        board[nx][ny] = 'T';
                        queue.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
    }


    /**
     * 并查集 - todo
     */
    class S3{

    }

}
