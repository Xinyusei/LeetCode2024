package Type_.图论算法.遍历基础.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/">2316. 统计无向图中无法互相到达点对数</a>
 */
public class a2316统计无向图中无法互相到达点对数 {
    class Solution {
        public long countPairs(int n, int[][] edges) {
            List<Integer>[] g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int[] e : edges) {
                int x = e[0], y = e[1];
                g[x].add(y);
                g[y].add(x); // 建图
            }

            boolean[] vis = new boolean[n];
            long ans = 0;
            for (int i = 0, total = 0; i < n; i++) {
                if (!vis[i]) {
                    //当前连通块的大小
                    int size = dfs(i,g,vis);
                    ans += (long)total * size;
                    total += size;
                }
            }
            return ans;

        }

        private int dfs(int x, List<Integer>[] g, boolean[] vis) {
            vis[x] = true;
            int size = 1;
            for (Integer y : g[x]) {
                if (!vis[y])
                    size += dfs(y, g, vis);
            }
            return size;
        }
    }
}
