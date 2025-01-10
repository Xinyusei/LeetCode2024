package 面试必刷.回溯.排列型回溯;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/10
 * @Description:
 */
public class a52N皇后两道 {
    /**
     * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的 数量 。
     */
    class S1 {
        class Solution {
            private char[][] g;
            private int n;

            private int res;
            public int totalNQueens(int n) {
                this.n = n;
                this.g = build(n);

                dfs(0);
                return res;
            }
            private char[][] build(int n) {
                char[][] g = new char[n][n];
                for (char[] row : g) {
                    Arrays.fill(row, '.');
                }
                return g;
            }

            private void dfs(int x) {
                if (x == n) {
                    res++;
                }
                for (int i = 0; i < n; i++) {
                    if (valid(x, i)) {
                        g[x][i] = 'Q';
                        dfs(x + 1);
                        g[x][i] = '.';
                    }
                }

            }

            private boolean valid(int x, int y) {
                //同一列
                for (int i = 0; i < n; i++)
                    if (g[i][y] == 'Q')
                        return false;
                //同一行
                for (int j = 0; j < n; j++)
                    if (g[x][j] == 'Q')
                        return false;
                //-45度
                for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
                    if (g[i][j] == 'Q')
                        return false;
                }
                for (int i = x + 1, j = y + 1; i < n && j < n; i++, j++)
                    if (g[i][j] == 'Q')
                        return false;

                //+45度
                for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++)
                    if (g[i][j] == 'Q')
                        return false;

                for (int i = x + 1, j = y - 1; i < n && j >= 0; i++, j--)
                    if (g[i][j] == 'Q')
                        return false;

                return true;
            }
        }
    }

    /**
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     */
    class S2 {
        class Solution {
            private char[][] g;
            private int n;
            List<List<String>> res = new ArrayList<>();

            public List<List<String>> solveNQueens(int n) {
                this.n = n;
                this.g = build(n);

                dfs(0);
                return res;
            }

            private char[][] build(int n) {
                char[][] g = new char[n][n];
                for (char[] row : g) {
                    Arrays.fill(row, '.');
                }
                return g;
            }

            private void dfs(int x) {
                if (x == n) {
                    addRes();
                }
                for (int i = 0; i < n; i++) {
                    if (valid(x, i)) {
                        g[x][i] = 'Q';
                        dfs(x + 1);
                        g[x][i] = '.';
                    }
                }

            }

            private boolean valid(int x, int y) {
                //同一列
                for (int i = 0; i < n; i++)
                    if (g[i][y] == 'Q')
                        return false;
                //同一行
                for (int j = 0; j < n; j++)
                    if (g[x][j] == 'Q')
                        return false;
                //-45度
                for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
                    if (g[i][j] == 'Q')
                        return false;
                }
                for (int i = x + 1, j = y + 1; i < n && j < n; i++, j++)
                    if (g[i][j] == 'Q')
                        return false;

                //+45度
                for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++)
                    if (g[i][j] == 'Q')
                        return false;

                for (int i = x + 1, j = y - 1; i < n && j >= 0; i++, j--)
                    if (g[i][j] == 'Q')
                        return false;

                return true;
            }

            private void addRes() {
                List<String> curr = new ArrayList<>();
                for (char[] chars : g) {
                    StringBuilder sb = new StringBuilder();
                    for (char c : chars) {
                        sb.append(c);
                    }
                    curr.add(sb.toString());
                }
                res.add(curr);
            }
        }
    }
}
