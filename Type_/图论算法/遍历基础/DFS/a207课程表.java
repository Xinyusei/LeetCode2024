package Type_.图论算法.遍历基础.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/14
 * @Description:
 */
public class a207课程表 {
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
     * 207.课程表 - BFS - 拓扑排序检测环
     */
    class S1_2 {
        class Solution {
            public boolean canFinish(int numCourses, int[][] prerequisites) {
                int[] inDegrees = new int[numCourses];
                List<Integer>[] g = new List[numCourses];
                Arrays.setAll(g, i -> new LinkedList<Integer>());

                // 构建入度数组
                for (int[] edge : prerequisites) {
                    g[edge[1]].add(edge[0]);
                    inDegrees[edge[0]]++;
                }

                List<Integer> queue = new LinkedList<>();
                // 根据入度初始化队列中的节点
                for (int i = 0; i < inDegrees.length; i++) {
                    if (inDegrees[i] == 0)
                        // 节点 i 没有入度，即没有依赖的节点
                        // 可以作为拓扑排序的起点，加入队列
                        queue.addLast(i);
                }

                // 记录遍历的节点个数
                int cnt = 0;
                while (!queue.isEmpty()) {
                    // 开始执行 BFS 循环
                    int cur = queue.removeFirst();
                    cnt++;

                    //相当于这个点被移除了，它所指向的节点的入度都-1
                    for (Integer next : g[cur]) {
                        inDegrees[next]--;
                        if (inDegrees[next] == 0)
                            queue.addLast(next);
                    }
                }
                return cnt == numCourses;
            }

        }
    }
}
