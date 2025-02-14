package Type_.图论算法.遍历基础.BFS;

import java.util.LinkedList;

/**
 * 994. 腐烂的橘子
 * https://leetcode.cn/problems/rotting-oranges/description/?envType=daily-question&envId=2024-05-13
 */
public class a994腐烂的橘子 {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int freshCnt = 0;
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2)
                        queue.add(new int[]{i, j});
                    if (grid[i][j] == 1)
                        freshCnt++;
                }
            }
            int minutes = 0;
            int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            while (!queue.isEmpty()) {
                int sz = queue.size();
                boolean isChanged = false;
                for (int i = 0; i < sz; i++) {
                    int[] pos = queue.removeFirst();
                    for (int[] d : dir) {
                        int nextI = d[0] + pos[0], nextJ = d[1] + pos[1];
                        if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == 1) {
                            isChanged = true;
                            queue.add(new int[]{nextI, nextJ});
                            grid[nextI][nextJ] = 2;
                            freshCnt--;
                        }
                    }
                }
                if (isChanged)
                    minutes++;
            }
            return freshCnt == 0 ? minutes : -1;
        }
    }
}
