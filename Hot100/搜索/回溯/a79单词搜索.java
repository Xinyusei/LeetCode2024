package Hot100.搜索.回溯;

/**
 * @Author: ZJX
 * @Date: 2024/11/27
 * @Description:
 */
public class a79单词搜索 {
    class Solution {
        int m, n, idx;
        String s;
        boolean[][] visited;
        int[][] dir;
        boolean flag = false;

        public boolean exist(char[][] board, String word) {
            this.m = board.length;
            this.n = board[0].length;
            this.idx = 0;
            this.s = word;
            this.visited = new boolean[m][n];
            this.dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    backtrack(i, j, board, idx);
                    if (flag)
                        return true;
                }
            return false;
        }

        private void backtrack(int x, int y, char[][] board, int idx) {
            if (flag || idx == s.length()) {
                flag = true;
                return;
            }
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y])
                return;
            if (board[x][y] != s.charAt(idx))
                return;
            for (int[] d : dir) {
                visited[x][y] = true;
                idx++;
                backtrack(x + d[0], y + d[1], board, idx);
                visited[x][y] = false;
                idx--;
            }
        }
    }
}
