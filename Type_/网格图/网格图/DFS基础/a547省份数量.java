package Type_.网格图.网格图.DFS基础;


/**
 * <a href="https://leetcode.cn/problems/number-of-provinces/description/">547. 省份数量</a>
 */
public class a547省份数量 {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(isConnected, visited, i);
                    ans++;
                }
            }
            return ans;
        }

        public void dfs(int[][] g, boolean[] visited, int idx) {
            if (visited[idx])
                return;

            visited[idx] = true;
            for (int j = 0; j < g.length; j++) {
                if (j != idx && !visited[j] && g[idx][j] == 1)
                    dfs(g, visited, j);
            }
        }
    }
}
