package Type_.网格图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 210. 课程表 II
 * https://leetcode.cn/problems/course-schedule-ii/description/
 */
public class a210课程表II {
    private class Solution1 {

        boolean[] visited;
        int[] onPath;
        boolean hasCycle = false;

        List<Integer> postOrder = new ArrayList<>();

        public int[] findOrder(int n, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(n, prerequisites);
            visited = new boolean[n];
            onPath = new int[n];
            int[] res = new int[n];
            for (int i = 0; i < n && !hasCycle; i++) {
                if (!visited[i])
                    traverse(graph, i);
            }
            // 有环图无法进行拓扑排序
            if (hasCycle) {
                return new int[]{};
            }
            // 逆后序遍历结果即为拓扑排序结果
            for (int i = 0; i < postOrder.size(); i++) {
                res[i] = postOrder.get(postOrder.size() - 1 - i);
            }
            return res;

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

            // 前序遍历位置
            visited[course] = true;
            onPath[course] = 1;
            //遍历邻居
            for (Integer other : graph[course]) {
                traverse(graph, other);
            }
            onPath[course] = 0;
            postOrder.add(course);

        }
    }


    private class Solution2 {
        int[] inDegree;

        List<Integer> queue = new LinkedList<>();

        public int[] findOrder(int n, int[][] prerequisites) {
            inDegree = new int[n];
            List<Integer>[] graph = buildGraph(n, prerequisites);
            for (int i = 0; i < n; i++) {
                //找到入度为0的节点开始BFS
                if (inDegree[i] == 0) {
                    queue.addLast(i);
                }
            }
            int visited = 0;
            // 记录拓扑排序结果
            int[] res = new int[n];
            while (!queue.isEmpty()) {
                Integer first = queue.removeFirst();
                res[visited++] = first;
                for (Integer other : graph[first]) {
                    --inDegree[other];
                    if (inDegree[other] == 0) {
                        queue.addLast(other);
                    }
                }
            }
            return visited == n ? res : new int[]{};
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
