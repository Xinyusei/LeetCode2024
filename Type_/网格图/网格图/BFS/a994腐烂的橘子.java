package Type_.网格图.网格图.BFS;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/14
 * @Description:
 */
public class a994腐烂的橘子 {
    class S1 {
        class Solution {
            private final static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

            public int orangesRotting(int[][] grid) {
                int m = grid.length, n = grid[0].length;
                List<int[]> queue = new LinkedList<>();

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == 2) {
                            queue.add(new int[]{i, j});
                        }
                    }
                }
                int res = 0;
                while (!queue.isEmpty()) {
                    int sz = queue.size();
                    res++;
                    for (int i = 0; i < sz; i++) {
                        int[] first = queue.removeFirst();
                        for (int[] d : dir) {
                            int nx = d[0] + first[0], ny = d[1] + first[1];
                            //排除 1. 越界 2. 不是新鲜苹果
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1)
                                continue;
                            //入队
                            System.out.println("加入：" + nx + "," + ny);
                            queue.addLast(new int[]{nx, ny});
                            //标记为腐烂
                            grid[nx][ny] = 2;
                        }
                    }
                }
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == 1) {
                            return -1;
                        }
                    }
                }

                return res != 0 ? res - 1 : 0;
            }

        }
    }
}
