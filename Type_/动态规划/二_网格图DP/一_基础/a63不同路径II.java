package Type_.动态规划.二_网格图DP.一_基础;

import java.util.Arrays;

/**
 * 63. 不同路径 II
 * https://leetcode.cn/problems/unique-paths-ii/description/
 */
public class a63不同路径II {
    /**
     * 记忆化搜索 - 从  0，0开始搜索
     */
    class S2_1 {
        int[][] memo;

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            this.memo = new int[m][n];
            for (int[] me : memo)
                Arrays.fill(me, -1);
            return search(0, 0, obstacleGrid);
        }

        public int search(int i, int j, int[][] g) {
            int m = g.length, n = g[0].length;
            if (i >= m || j >= n)
                return 0;
            if (i == m - 1 && j == n - 1) {
                if (g[i][j] == 1)
                    return 0;
                else
                    return 1;
            }
            if (memo[i][j] != -1)
                return memo[i][j];
            if (g[i][j] == 1)
                return 0;
            return memo[i][j] = search(i, j + 1, g) + search(i + 1, j, g);
        }
    }


    /**
     * 记忆化搜索 - 分解问题 从终点往回推
     */
    class S2_2 {
        int[][] memo;

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            this.memo = new int[m][n];
            for (int[] me : memo)
                Arrays.fill(me, -1);
            boolean rowFlag = false, colFlag = false;
            for (int i = 0; i < obstacleGrid.length; i++) {
                if (obstacleGrid[i][0] == 1)
                    rowFlag = true;
                if (rowFlag)
                    obstacleGrid[i][0] = 1;
            }
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[0][j] == 1)
                    colFlag = true;
                if (colFlag)
                    obstacleGrid[0][j] = 1;
            }
            return search(m - 1, n - 1, obstacleGrid);
        }

        public int search(int i, int j, int[][] g) {
            if (i == 0 || j == 0) {
                if (g[i][j] == 1)
                    return 0;
                return 1;
            }
            if (memo[i][j] != -1)
                return memo[i][j];
            if (g[i][j] == 1)
                return 0;
            return memo[i][j] = search(i - 1, j, g) + search(i, j - 1, g);
        }
    }

    /**
     * DP TABLE - 从 x，y 到达 右下角(m - 1,n - 1)有多少路径
     */
    class S1_1 {
        class Solution {
            public int uniquePathsWithObstacles(int[][] g) {
                int m = g.length, n = g[0].length;
                int[][] f = new int[m][n];

                //f[i][j] 表示 从 0，0 到达 x,y 有多少路径
                //base case
                for (int i = 0, j = 0; j < n; j++) {
                    if (g[i][j] == 1)
                        break;
                    f[i][j] = 1;
                }
                for (int i = 0, j = 0; i < m; i++) {
                    if (g[i][j] == 1)
                        break;
                    f[i][j] = 1;
                }

                for (int i = 1; i < m; i++) {
                    for (int j = 1; j < n; j++) {
                        if (g[i][j] == 1) {
                            f[i][j] = 0;
                            continue;
                        }
                        f[i][j] = f[i - 1][j] + f[i][j - 1];
                    }
                }
                return f[m - 1][n - 1];
            }
        }
    }

    /**
     * DP TABLE -  从 x,y 到达 右下角(m-1, n-1) 的路径数目
     */

    class S1_2 {
        class Solution {
            public int uniquePathsWithObstacles(int[][] g) {
                int m = g.length, n = g[0].length;
                int[][] f = new int[m][n];

                //f[i][j] 表示 从 x,y 到达 右下角(m-1, n-1) 的路径数目
                //base case
                for (int i = m - 1, j = n - 1; j >= 0; j--) {
                    if (g[i][j] == 1)
                        break;
                    f[i][j] = 1;
                }
                for (int i = m - 1, j = n - 1; i >= 0; i--) {
                    if (g[i][j] == 1)
                        break;
                    f[i][j] = 1;
                }

                for (int i = m - 2; i >= 0; i--) {
                    for (int j = n - 2; j >= 0; j--) {
                        if (g[i][j] == 1)
                            continue;
                        f[i][j] = f[i + 1][j] + f[i][j + 1];
                    }
                }
                return f[0][0];
            }
        }
    }
}
