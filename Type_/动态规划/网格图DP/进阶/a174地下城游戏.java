package Type_.动态规划.二_网格图DP.进阶;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/03
 * @Description:
 */
public class a174地下城游戏 {
    class Solution1 {
        /**
         * 记忆化搜索
         */
        int[][] memo;

        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length, n = dungeon[0].length;
            memo = new int[m][n];
            for (int[] e : memo) {
                //初始化为-1,表示没有遍历过
                Arrays.fill(e, -1);
            }
            return dfs(0, 0, dungeon);
        }

        //从 grid[i][j] 到达终点（右下角）所需的最少初始生命值是 dfs(grid, i, j)
        private int dfs(int x, int y, int[][] g) {
            int m = g.length, n = g[0].length;

            //base case
            if (x == m - 1 && y == n - 1) {
                return Math.max(1, 1 - g[x][y]);
            }
            if (x == m || y == n)
                return Integer.MAX_VALUE;
            if (memo[x][y] != -1)
                return memo[x][y];
            int res = Math.max(
                    Math.min(dfs(x + 1, y, g), dfs(x, y + 1, g)) - g[x][y],
                    1);
            return memo[x][y] = res;
        }
    }

    class Solution2 {
        //这道题的dp是倒序的，这点很重要，为什么不能像【最小路径和】一样是正序的？因为【最小路径和】是无状态的，你会发现【最小路径和】倒序dp也是可以的
        //这道题由于有“加血”的过程，只能依赖后面的值判断需要的血量。所以这里的dp[i][j]表达的意思是：“从（i，j）出发，到达终点需要最少的血量”。
        //因此，正序的含义为“从起点出发，到达位置（i，j）所需要的最少血量”；倒序的含义是“从（i，j）出发，到达终点需要最少的血量”。初始血量本来就是要求的，所以只能倒序dp
        class Solution {
            public int calculateMinimumHP(int[][] dungeon) {
                int m = dungeon.length, n = dungeon[0].length;
                int[][] f = new int[m][n];
                //f[i][j] 表示： 从 i,j 出发,到达终点所需要的最少的血量

                //base case
                f[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
                for (int i = m - 2; i >= 0; i--)
                    f[i][n - 1] = Math.max(1, f[i + 1][n - 1] - dungeon[i][n - 1]);

                for (int j = n - 2; j >= 0; j--)
                    f[m - 1][j] = Math.max(1, f[m - 1][j + 1] - dungeon[m - 1][j]);

                for (int i = m - 2; i >= 0; i--) {
                    for (int j = n - 2; j >= 0; j--) {
                        f[i][j] = Math.max(1, Math.min(f[i + 1][j], f[i][j + 1]) - dungeon[i][j]);
                    }
                }
                return f[0][0];
            }
        }
    }

    class Solution3 {
        //这道题的dp是倒序的，这点很重要，为什么不能像【最小路径和】一样是正序的？因为【最小路径和】是无状态的，你会发现【最小路径和】倒序dp也是可以的
        //这道题由于有“加血”的过程，只能依赖后面的值判断需要的血量。所以这里的dp[i][j]表达的意思是：“从（i，j）出发，到达终点需要最少的血量”。
        //因此，正序的含义为“从起点出发，到达位置（i，j）所需要的最少血量”；倒序的含义是“从（i，j）出发，到达终点需要最少的血量”。初始血量本来就是要求的，所以只能倒序dp
        class Solution {
            public int calculateMinimumHP(int[][] dungeon) {
                int m = dungeon.length, n = dungeon[0].length;
                int[][] f = new int[m + 1][n + 1];
                //f[i][j] 表示： 从 i,j 出发,到达终点所需要的最少的血量
                //base case
                for (int[] row : f) {
                    Arrays.fill(row, Integer.MAX_VALUE);
                }
                f[m][n - 1] = f[m - 1][n] = 1;
                for (int i = m - 1; i >= 0; i--) {
                    for (int j = n - 1; j >= 0; j--) {
                        f[i][j] = Math.max(1, Math.min(f[i + 1][j], f[i][j + 1]) - dungeon[i][j]);
                    }
                }
                return f[0][0];
            }
        }
    }
}
