package Type_.网格图;

import java.util.LinkedList;
import java.util.List;

/**
 * 1020. 飞地的数量
 * https://leetcode.cn/problems/number-of-enclaves/description/
 */
public class a1020飞地的数量 {
    class Solution1 {
        int row, col;
        int[][] dir;

        public int numEnclaves(int[][] board) {
            this.row = board.length;
            this.col = board[0].length;
            this.dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    //找到与边界直接或者间接相连接的1 将其标记为2
                    if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && board[i][j] == 1) {
                        board[i][j] = 2;
                        BFS(board, i, j);
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 2)
                        result++;
                }
            }
            return result;
        }


        //找到与边界直接或者间接相连接的'O' 将其标记为'T'
        public void BFS(int[][] board, int x, int y) {
            List<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});

            while (!queue.isEmpty()) {
                int[] p = queue.removeFirst();
                for (int[] d : dir) {
                    int nx = p[0] + d[0], ny = p[1] + d[1];
                    if (nx < 0 || nx >= row || ny < 0 || ny >= col || board[nx][ny] != 1)
                        continue;
                    board[nx][ny] = 2;
                    queue.addLast(new int[]{nx, ny});
                }
            }
        }
    }
}
