package Type_.网格图.网格图.DFS基础;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-if-path-exists-in-graph/description/">1971. 寻找图中是否存在路径</a>
 */
public class a1971寻找图中是否存在路径 {
    class Solution1 {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            //建图
            List<Integer>[] g = new List[n];
            for (int i = 0; i < g.length; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                g[edge[0]].add(edge[1]);
                g[edge[1]].add(edge[0]);
            }
            boolean[] visited = new boolean[n];
            return dfs(source, destination, g, visited);
        }

        public boolean dfs(int s, int d, List<Integer>[] g, boolean[] visited) {
            if (s == d)
                return true;

            visited[s] = true;
            for (int num : g[s]) {
                if (!visited[num] && dfs(num, d, g, visited))
                    return true;
            }
            return false;
        }
    }

    class Solution2 {
        public boolean validPath(int n, int[][] edges, int s, int d) {
            //建立
            List<Integer>[] g = new List[n];
            for (int i = 0; i < g.length; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                g[edge[0]].add(edge[1]);
                g[edge[1]].add(edge[0]);
            }
            List<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            queue.add(s);
            visited[s] = true;
            while (!queue.isEmpty()) {
                Integer first = queue.removeFirst();
                for (Integer nxt : g[first]) {
                    if (nxt == d)
                        return true;
                    if (visited[nxt])
                        continue;
                    visited[nxt] = true;
                    queue.addLast(nxt);
                }
            }
            return visited[d];
        }
    }
}

