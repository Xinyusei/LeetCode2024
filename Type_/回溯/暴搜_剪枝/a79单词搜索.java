package Type_.回溯.暴搜_剪枝;

/**
 * @Author: ZJX
 * @Date: 2025/02/15
 * @Description:
 */
public class a79单词搜索 {
    class S1 {
        class Solution {
            private final static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            private boolean[][] vis;
            int m, n;
            boolean find;

            public boolean exist(char[][] board, String word) {
                this.m = board.length;
                this.n = board[0].length;
                this.vis = new boolean[m][n];
                this.find = false;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        dfs(board, i, j, word, 0);
                        if (find)
                            return true;
                    }
                }
                return false;
            }

            public void dfs(char[][] g, int x, int y,
                            String word, int idx) {
                if (idx == word.length()) {
                    find = true;
                    return;
                }
                if(find)
                    return;

                if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y])
                    return;

                if (g[x][y] != word.charAt(idx))
                    return;

                vis[x][y] = true;
                for (int[] d : dir) {
                    dfs(g, d[0] + x, d[1] + y, word, idx + 1);
                }
                vis[x][y] = false;

            }

        }
    }
}
