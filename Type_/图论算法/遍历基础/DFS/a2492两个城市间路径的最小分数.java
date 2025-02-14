package Type_.图论算法.遍历基础.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-score-of-a-path-between-two-cities/description/">2492. 两个城市间路径的最小分数</a>
 */
public class a2492两个城市间路径的最小分数 {
    class Solution {
        private int minValue = Integer.MAX_VALUE;

        public int minScore(int n, int[][] roads) {
            List<List<Integer>>[] g = new List[n + 1];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int[] road : roads) {
                int x = road[0], y = road[1], w = road[2];
                g[x].add(Arrays.asList(y, w));
                g[y].add(Arrays.asList(x, w));
            }
            boolean[] vis = new boolean[n + 1];
            traverse(g, vis, 1);
            return minValue;
        }

        private void traverse(List<List<Integer>>[] g, boolean[] vis, int cur) {
            if (vis[cur])
                return;
            vis[cur] = true;
            for (List<Integer> road : g[cur]) {
                minValue = Math.min(minValue, road.get(1));
                traverse(g, vis, road.get(0));
            }
        }
    }
}
