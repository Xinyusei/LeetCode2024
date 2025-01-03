package 面试必刷;

/**
 * @Author: ZJX
 * @Date: 2024/12/28
 * @Description:
 */
public class a36有效的数独 {

    /**
     * 哈希表计数 - todo
     */
    class S2 {
        class Solution {
            public boolean isValidSudoku(char[][] board) {
                int n = board.length;
                int[][] rowCnt = new int[n][10];
                int[][] colCnt = new int[n][10];
                int[][][] subCnt = new int[n / 3][n / 3][10];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (board[i][j] == '.')
                            continue;
                        int v = board[i][j] - '0';
                        rowCnt[i][v]++;
                        colCnt[j][v]++;
                        subCnt[i / 3][j / 3][v]++;
                        if (rowCnt[i][v] > 1 || colCnt[j][v] > 1 || subCnt[i / 3][j / 3][v] > 1)
                            return false;
                    }
                }
                return true;
            }
        }
    }

    /**
     * 朴素解法
     */
    class S1 {
        class Solution {
            public boolean isValidSudoku(char[][] board) {
                int n = board.length;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        char v = board[i][j];
                        //判断规则1是否满足
                        if (!checkRow(v, board, i))
                            return false;
                        System.out.println("通过规则1");
                        //判断规则2是否满足
                        if (!checkCol(v, board, j))
                            return false;
                        System.out.println("通过规则2");

                        if (!checkMatrix(v, board, i, j))
                            return false;
                        System.out.println("通过规则3");
                        //判断规则3是否满足
                    }
                }
                return true;
            }

            private boolean checkRow(char v, char[][] g, int row) {
                int cnt = 0;
                for (char c : g[row]) {
                    if (c != '.' && c == v)
                        cnt++;
                    if (cnt > 1)
                        return false;
                }
                return true;
            }

            private boolean checkCol(char v, char[][] g, int col) {
                int cnt = 0;
                for (char[] cs : g) {
                    if (cs[col] != '.' && cs[col] == v)
                        cnt++;
                    if (cnt > 1)
                        return false;
                }
                return true;
            }

            private boolean checkMatrix(int v, char[][] g, int i, int j) {
                int startRow = i / 3, startCol = j / 3, cnt = 0;
                for (int row = startRow * 3; row < startRow * 3 + 3; row++) {
                    for (int col = startCol * 3; col < startCol * 3 + 3; col++) {
                        if (g[row][col] != '.' && g[row][col] == v)
                            cnt++;
                        if (cnt > 1)
                            return false;
                    }
                }
                return true;
            }
        }
    }
}
