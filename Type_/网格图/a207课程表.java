package Type_.网格图;

import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 * <a href = "https://leetcode.cn/problems/course-schedule/description/"></a>
 */
public class a207课程表 {

    /**
     * DFS 解法 ：
     */
    private class Solution1 {
        boolean[] visited;
        int[] onPath;
        boolean hasCycle = false;

        public boolean canFinish(int n, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(n, prerequisites);
            visited = new boolean[n];
            onPath = new int[n];

            for (int i = 0; i < n && !hasCycle; i++) {
                if (!visited[i])
                    traverse(graph, i);
            }

            return !hasCycle;
        }

        public List<Integer>[] buildGraph(int n, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] table : prerequisites) {
                int from = table[1], to = table[0];
                graph[from].add(to);
            }
            return graph;
        }

        /*  DFS */
        public void traverse(List<Integer>[] graph, int course) {
            if (onPath[course] == 1) {
                hasCycle = true;
            }
            if (visited[course] || hasCycle)
                return;

            visited[course] = true;
            onPath[course] = 1;
            for (Integer other : graph[course]) {
                traverse(graph, other);
            }
            onPath[course] = 0;

        }
    }


    /**
     * BFS
     */
    private class Solution2 {

        int[] inDegree;

        List<Integer> queue = new LinkedList<>();

        public boolean canFinish(int n, int[][] prerequisites) {
            inDegree = new int[n];
            List<Integer>[] graph = buildGraph(n, prerequisites);
            for (int i = 0; i < n; i++) {
                //找到入度为0的节点开始BFS
                if (inDegree[i] == 0) {
                    queue.addLast(i);
                }
            }
            int visited = 0;
            while (!queue.isEmpty()) {
                ++visited;
                Integer first = queue.removeFirst();
                for (Integer other : graph[first]) {
                    --inDegree[other];
                    if(inDegree[other] == 0)
                        queue.addLast(other);
                }
            }

            return visited == n;
        }

        public List<Integer>[] buildGraph(int n, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] table : prerequisites) {
                int from = table[1], to = table[0];
                graph[from].add(to);
                //记录入度。
                ++inDegree[to];
            }
            return graph;
        }
    }
}
