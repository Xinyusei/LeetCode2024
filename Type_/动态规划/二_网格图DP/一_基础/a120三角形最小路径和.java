package Type_.动态规划.二_网格图DP.一_基础;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/21
 * @Description:
 */
public class a120三角形最小路径和 {

    /**
     * 记忆化搜索 自底向上
     */
    class S1 {
        class Solution {
            int[][] memo;

            public int minimumTotal(List<List<Integer>> triangle) {
                //[0,0]
                //[1,0] [1,1]
                //[2,0] [2,1] [2,2]
                int n = triangle.size();
                memo = new int[n][n];
                for (int[] r : memo) {
                    Arrays.fill(r, Integer.MAX_VALUE);
                }
                return dfs(triangle, 0, 0);
            }

            //dfs(g,x,y) 表示从 x，y 出发，到达最下层的最小路径和
            private int dfs(List<List<Integer>> g, int x, int y) {
                if (x == g.size())
                    return 0;
                if (memo[x][y] != Integer.MAX_VALUE)
                    return memo[x][y];
                return memo[x][y] = Math.min(dfs(g, x + 1, y), dfs(g, x + 1, y + 1)) + g.get(x).get(y);
            }
        }
    }

    /**
     * DP TABLE - 从 0,0 到 x，y的最小路径和
     */
    class S2 {
        class Solution {
            public int minimumTotal(List<List<Integer>> triangle) {
                int n = triangle.size();
                int[][] f = new int[n][];
                for (int i = 0; i < n; i++) {
                    f[i] = new int[triangle.get(i).size()];
                }
                f[0][0] = triangle.get(0).get(0);
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < triangle.get(i).size(); j++) {
                        if (j == 0)
                            f[i][j] = f[i - 1][j];
                        else if (j == triangle.get(i).size() - 1)
                            f[i][j] = f[i - 1][j - 1];
                        else {
                            f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]);

                        }
                        f[i][j] += triangle.get(i).get(j);
                    }
                }
                int res = Integer.MAX_VALUE;
                for (int lastLine : f[n - 1]) {
                    res = Math.min(res, lastLine);
                }
                return res;
            }
        }
    }


    /**
     * DP TABLE - 从 x，y 到 底边的最小路径和 - 未优化
     */
    class S3 {
        class Solution {
            public int minimumTotal(List<List<Integer>> triangle) {
                int n = triangle.size();
                int[][] f = new int[n][];
                for (int i = 0; i < n; i++) {
                    f[i] = new int[triangle.get(i).size()];
                }
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = 0; j <= i; j++) {
                        f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
                    }
                }
                return f[0][0];
            }
        }
    }

    /**
     * DP TABLE - 从 x，y 到 底边的最小路径和 - 优化
     */
    class S4 {
        class Solution {
            public int minimumTotal(List<List<Integer>> triangle) {
                int n = triangle.size();
                int[] f = new int[n];
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = 0; j <= i; j++) {
                        f[j] = Math.min(f[j], f[j + 1]) + triangle.get(i).get(j);
                    }
                }
                return f[0];
            }
        }
    }
}
