package 面试必刷.回溯.爆搜_剪枝;

/**
 * @Author: ZJX
 * @Date: 2025/01/10
 * @Description:
 */
public class a79单词搜索 {
    class S1 {
        class Solution {
            private final static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            boolean find = false;
            boolean[][] vis;

            public boolean exist(char[][] board, String word) {
                int m = board.length, n = board[0].length;
                vis = new boolean[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        dfs(board, i, j, word, 0);
                        if (find)
                            return true;
                    }
                }
                return false;
            }

            private void dfs(char[][] board, int x, int y, String w, int startIndex) {
                if (startIndex == w.length()) {
                    // 整个 word 已经被匹配完，找到了一个答案
                    find = true;
                    return;
                }
                if (find)
                    // 已经找到了一个答案，不用再搜索了
                    return;
                int m = board.length, n = board[0].length;
                // 1. 不在矩阵内 2.已经遍历过 3.当前字符不匹配
                if (x < 0 || y < 0 || x >= m || y >= n || vis[x][y] || board[x][y] != w.charAt(startIndex))
                    return;


                for (int[] d : dir) {
                    vis[x][y] = true;
                    int nx = x + d[0], ny = y + d[1];
                    dfs(board, nx, ny, w, startIndex + 1);
                    vis[x][y] = false;
                }

            }
        }
    }
}
