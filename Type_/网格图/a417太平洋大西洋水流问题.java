package Type_.网格图;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * <a href="https://leetcode.cn/problems/pacific-atlantic-water-flow/description/">...</a>
 */
public class a417太平洋大西洋水流问题 {
    int row, col;
    boolean[][] po, ao;
    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    int[][] g;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.row = heights.length;
        this.col = heights[0].length;
        po = new boolean[row][col];
        ao = new boolean[row][col];
        this.g = heights;
        for (int i = 0; i < row; i++)
            dfs(i, 0, po);
        for (int j = 0; j < col; j++)
            dfs(0, j, po);
        for (int i = 0; i < row; i++)
            dfs(i, col - 1, ao);
        for (int j = 0; j < col; j++)
            dfs(row - 1, j, ao);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ao[i][j] && po[i][j]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;

    }

    public void dfs(int x, int y, boolean[][] ocean) {
        if (x < 0 || x >= row || y < 0 || y >= col || ocean[x][y])
            return;
        ocean[x][y] = true;
        for (int[] d : dir) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col || g[nx][ny] < g[x][y])
                continue;
            dfs(nx, ny, ocean);
        }
    }
}
