package Type_.网格图;

import java.util.*;

/**
 * 2192. 有向无环图中一个节点的所有祖先
 * <a href="https://leetcode.cn/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/?envType=daily-question&envId=2024-04-04">...</a>
 */
public class a2192有向无环图中一个节点的所有祖先 {
    class Solution1 {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            //建图、入度
            List<Integer>[] g = new List[n];
            int[] inDegree = new int[n];
            for (int i = 0; i < g.length; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int from = edge[0], to = edge[1];
                g[from].add(to);
                ++inDegree[to];
            }
            Set<Integer>[] parentSet = new HashSet[n];
            for (int i = 0; i < n; i++) {
                parentSet[i] = new HashSet<Integer>();
            }
            List<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) {
                    queue.addLast(i);
                }
            }

            while (!queue.isEmpty()) {
                int first = queue.removeFirst();
                for (int point : g[first]) {
                    //更新子节点的祖先哈希表
                    parentSet[point].add(first);
                    for (int i : parentSet[first]) {
                        parentSet[point].add(i);
                    }
                    --inDegree[point];
                    if(inDegree[point] == 0)
                        queue.addLast(point);
                }
            }// 转化为答案数组
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; ++i) {
                res.add(new ArrayList<Integer>());
                for (int j : parentSet[i]) {
                    res.get(i).add(j);
                }
                Collections.sort(res.get(i));
            }
            return res;
        }
    }


    class Solution2 {


        public int[][] build(int n, int[][] edges) {
            int[][] g = new int[n][n];
            for (int[] edge : edges) {
                int from = edge[0], to = edge[1];
                g[from][to] = 1;
            }
            return g;
        }
    }
}
