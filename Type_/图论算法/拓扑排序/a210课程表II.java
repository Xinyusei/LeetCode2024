package Type_.图论算法.拓扑排序;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/02/14
 * @Description:
 */
public class a210课程表II {
    class S1 {
        class Solution {
            public int[] findOrder(int numCourses, int[][] prerequisites) {
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
                int[] res = new int[numCourses];
                int idx = 0;
                while (!queue.isEmpty()) {
                    // 开始执行 BFS 循环
                    int cur = queue.removeFirst();
                    res[idx++] = cur;

                    //相当于这个点被移除了，它所指向的节点的入度都-1
                    for (Integer next : g[cur]) {
                        inDegrees[next]--;
                        if (inDegrees[next] == 0)
                            queue.addLast(next);
                    }
                }
                return idx != numCourses ? res : new int[]{};
            }
        }
    }
}
