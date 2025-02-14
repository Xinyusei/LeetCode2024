package 面试必刷;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/07
 * @Description:
 */
public class a207课程表_环检测及拓扑排序算法 {
    /**
     * 207. 课程表 - DFS - 只要存在环，就说明存在循环依赖
     */
    class S1_1 {
        class Solution {

            //全局判断当前节点是否遍历过，是以图为维度来考虑
            boolean[] visited;

            // 记录一次 traverse 递归经过的节点
            boolean[] onPath;
            // 记录图中是否有环
            boolean hasCycle = false;

            public boolean canFinish(int numCourses, int[][] prerequisites) {
                List<Integer>[] g = new ArrayList[numCourses];
                this.visited = new boolean[numCourses];
                this.onPath = new boolean[numCourses];
                for (int i = 0; i < g.length; i++) {
                    g[i] = new ArrayList<>();
                }
                //建图
                for (int[] pre : prerequisites) {
                    int from = pre[1], to = pre[0];
                    g[from].add(to);
                }
                //System.out.println("Arrays.deepToString(g) = " + Arrays.deepToString(g));
                for (int i = 0; i < numCourses && !hasCycle; i++) {
                    if (!visited[i])
                        // 遍历图中的所有节点
                        traverse(g, i);
                }
                return !hasCycle;

            }

            void traverse(List<Integer>[] g, int s) {
                if (hasCycle) {
                    // 如果已经找到了环，也不用再遍历了
                    return;
                }


                if (onPath[s]) {
                    // s 已经在递归路径上，说明成环了
                    hasCycle = true;

                    return;
                }
                if (visited[s]) {
                    // 不用再重复遍历已遍历过的节点
                    return;
                }
                // 前序代码位置
                visited[s] = true;
                onPath[s] = true;
                for (Integer next : g[s]) {
                    traverse(g, next);
                }
                // 后序代码位置
                onPath[s] = false;
            }

        }

    }


    /**
     * 207. 课程表 - 图的环检测 - BFS - 入度表 + 拓扑排序
     */
    class S1_2 {
        class Solution {
            public boolean canFinish(int numCourses, int[][] prerequisites) {
                // 构建入度数组
                int[] inDegrees = new int[numCourses];
                List<Integer>[] g = new ArrayList[numCourses];
                // 建图，有向边代表「被依赖」关系
                for (int i = 0; i < g.length; i++) {
                    g[i] = new ArrayList<>();
                }
                //建图 并且 统计每个点的入度
                for (int[] pre : prerequisites) {
                    int from = pre[1], to = pre[0];
                    g[from].add(to);
                    inDegrees[to]++;
                }
                List<Integer> queue = new ArrayList<>();

                // 根据入度初始化队列中的节点，将入度的为0的点加入队列
                for (int i = 0; i < numCourses; i++) {
                    if (inDegrees[i] == 0)
                        queue.addLast(i);
                }

                //BFS - 拓扑排序
                while (!queue.isEmpty()) {
                    // 弹出节点 cur，并将它指向的节点的入度减一
                    int pre = queue.removeFirst();
                    numCourses--;

                    for (Integer nxt : g[pre]) {
                        inDegrees[nxt]--;
                        if (inDegrees[nxt] == 0)
                            // 如果入度变为 0，说明 next 依赖的节点都已被遍历
                            queue.add(nxt);
                    }
                }
                // 如果所有节点都被遍历过，说明不成环
                return numCourses == 0;
            }
        }
    }

    /**
     * 210. 课程表 II - 图的环检测 - 拓扑排序记录顺序 - BFS
     */
    class S2_1 {
        class Solution {
            public int[] findOrder(int numCourses, int[][] prerequisites) {
                int[] inDegrees = new int[numCourses];
                List<Integer>[] g = new ArrayList[numCourses];
                for (int i = 0; i < g.length; i++) {
                    g[i] = new ArrayList<>();
                }
                //建图 并且 统计每个点的入度
                for (int[] pre : prerequisites) {
                    int from = pre[1], to = pre[0];
                    g[from].add(to);
                    inDegrees[to]++;
                }
                List<Integer> queue = new ArrayList<>();
                //将入度的为0的点加入队列
                for (int i = 0; i < numCourses; i++) {
                    if (inDegrees[i] == 0)
                        queue.addLast(i);
                }
                //BFS - 拓扑排序
                int[] res = new int[numCourses];
                int idx = 0;
                while (!queue.isEmpty()) {
                    int pre = queue.removeFirst();
                    res[idx++] = pre;
                    for (Integer nxt : g[pre]) {
                        inDegrees[nxt]--;
                        if (inDegrees[nxt] == 0)
                            queue.add(nxt);
                    }
                }
                return idx == numCourses ? res : new int[]{};
            }
        }

    }
}
