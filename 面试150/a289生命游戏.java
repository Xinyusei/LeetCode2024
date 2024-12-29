package 面试150;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/29
 * @Description:
 */
public class a289生命游戏 {
    class S1 {
        class Solution {
            int m, n;
            private final static int[][] dir = new int[][]{
                    {1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}
            };
            private final static int LiveToLive = 5;
            private final static int LiveToDie = 4;
            private final static int diedToDie = 3;
            private final static int diedToLive = 2;

            //活细胞 死亡条件 ： 周围八个位置的活细胞 少于2个或者超过3个 < 2 || > 3
            //死细胞 复活条件 ： 周围八个位置的活细胞 恰好为3个 == 3
            public void gameOfLife(int[][] board) {
                this.m = board.length;
                this.n = board[0].length;

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        check(board, i, j);
                    }
                }
                //System.out.println(Arrays.deepToString(board));
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (board[i][j] == LiveToLive || board[i][j] == diedToLive)
                            board[i][j] = 1;
                        else
                            board[i][j] = 0;
                    }
                }
            }

            private void check(int[][] board, int i, int j) {
                int cntLive = 0;
                for (int[] d : dir) {
                    int x = i + d[0], y = j + d[1];
                    if (validPos(x, y) && (board[x][y] == 1 || board[x][y] == LiveToDie || board[x][y] == LiveToLive))
                        cntLive++;
                }
                //死细胞状态
                if (board[i][j] == 0) {
                    //死细胞 可以复活
                    if (cntLive == 3)
                        board[i][j] = diedToLive;
                    else
                        board[i][j] = diedToDie;
                }
                //活细胞
                if (board[i][j] == 1) {
                    //仍然为活的
                    if (cntLive == 3 || cntLive == 2)
                        board[i][j] = LiveToLive;
                    else
                        board[i][j] = LiveToDie;
                }
            }

            private boolean validPos(int x, int y) {
                return x >= 0 && y >= 0 && x < m && y < n;
            }
        }
    }
}
