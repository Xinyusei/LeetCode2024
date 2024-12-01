package 周赛.w426;

import javax.sound.midi.Soundbank;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/01
 * @Description:
 */
public class a100475连接两棵树后最大目标节点数目I {
    class Solution {
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
            //第一步：分别保存两个图中 每个节点的

            List<Integer>[] g1 = buildTree(edges1);
            List<Integer>[] g2 = buildTree(edges2);
            int[] e1 = new int[g1.length], e2 = new int[g2.length];
            for (int i = 0; i < g1.length; i++) e1[i] = disKNum(g1, k, i);
            for (int i = 0; i < g2.length; i++) e2[i] = disKNum(g2, k - 1, i);
            int max = Arrays.stream(e2).max().getAsInt();
        /*System.out.println(Arrays.toString(e1));
        System.out.println(Arrays.toString(e2));*/

            int[] res = new int[g1.length];

            for (int i = 0; i < e1.length; i++) {
                res[i] = e1[i] + (k > 0 ? max : 0);
            }
            return res;

        }

        private List<Integer>[] buildTree(int[][] edges) {
            List<Integer>[] g = new ArrayList[edges.length + 1];
            Arrays.setAll(g, i -> new ArrayList<>());

            for (int[] e : edges) {
                int x = e[0], y = e[1];
                g[x].add(y);
                g[y].add(x);
            }
            return g;
        }

        private int disKNum(List<Integer>[] g, int maxDis, int start) {
            int n = g.length;
            boolean[] visited = new boolean[n];
            List<Integer> queue = new ArrayList<>();
            queue.add(start);
            visited[start] = true;
            int res = 1;
            int dis = 0;
            while (!queue.isEmpty() && dis < maxDis) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    Integer first = queue.removeFirst();
                    for (Integer nei : g[first]) {
                        if (!visited[nei]) {
                            visited[nei] = true;
                            res++;
                            queue.addLast(nei);
                        }
                    }
                }
                dis++;

            }
            return res;
        }
    }
}
