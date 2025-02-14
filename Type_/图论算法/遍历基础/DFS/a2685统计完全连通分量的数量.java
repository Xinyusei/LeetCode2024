package Type_.图论算法.遍历基础.DFS;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-complete-components/description/">2685. 统计完全连通分量的数量</a>
 */
public class a2685统计完全连通分量的数量 {
    class Solution {

        private int curV,curE;

        public int countCompleteComponents(int n, int[][] edges) {
            List<Integer>[] g = new List[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            //建图
            for (int[] e : edges) {
                int x = e[0], y = e[1];
                g[x].add(y);
                g[y].add(x);
            }
            boolean[] vis = new boolean[n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    curV = 0;
                    curE = 0;
                    traverse(g, vis, i);
                    if (curV * (curV - 1) == curE)
                        res++;
                }
            }
            return res;
        }

        private void traverse(List<Integer>[] g, boolean[] vis, int cur) {
            if(vis[cur])
                return;
            vis[cur] = true;
            curV++;
            List<Integer> edges = g[cur];
            curE += edges.size();
            for (int y : edges) {
                traverse(g, vis, y);
            }
        }
    }
}
