package Type_.网格图.网格图.DFS基础;

/**
 * <a href="https://leetcode.cn/problems/battleships-in-a-board/description/?envType=daily-question&envId=2024-07-09">419. 棋盘上的战舰</a>
 */
public class a419棋盘上的战舰 {
    class Solution {

        public int countBattleships(char[][] board) {
            int row = board.length, col = board[0].length;
            int ans = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    //找到一个舰队的起点
                    if (board[i][j] == 'X') {
                        board[i][j] = '.';
                        for (int k = j + 1; k < col && board[i][k] == 'X'; k++) {
                            board[i][j] = '.';
                        }
                        for (int k = i + 1; k < row && board[k][j] == 'X'; k++)
                            board[k][j] = '.';
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}