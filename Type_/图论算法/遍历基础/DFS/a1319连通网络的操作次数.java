package Type_.图论算法.遍历基础.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/number-of-operations-to-make-network-connected/description/">1319. 连通网络的操作次数</a>
 */
public class a1319连通网络的操作次数 {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            List<Integer>[] g = new List[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            int m = connections.length, cnt = 0;
            if (m < n - 1)
                return -1;
            for (int[] e : connections) {
                g[e[0]].add(e[1]);
                g[e[1]].add(e[0]);
            } //建图
            boolean[] vis = new boolean[n];
            ArrayList<Integer> k = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    traverse(g, vis, i);
                    cnt++;
                }
            }
            return cnt - 1;
        }

        private void traverse(List<Integer>[] g, boolean[] vis, int cur) {
            if (vis[cur])
                return;
            vis[cur] = true;
            for (Integer nxt : g[cur]) {
                traverse(g, vis, nxt);
            }
        }
    }


    class Solution2 {
        //todo 并查集解法
        public int makeConnected(int n, int[][] connections) {
            return 0;
        }
    }

}
