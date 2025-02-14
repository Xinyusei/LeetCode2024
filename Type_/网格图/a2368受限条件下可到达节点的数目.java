package Type_.网格图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2368. 受限条件下可到达节点的数目
 * https://leetcode.cn/problems/reachable-nodes-with-restrictions/description/?envType=daily-question&envId=2024-03-02
 */
public class a2368受限条件下可到达节点的数目 {
    private int cnt = 0;
    private boolean[] visited;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] graph = bulidGraph(edges, n);
        visited = new boolean[n];
        Arrays.fill(visited, false);
        boolean[] isRestricted = new boolean[n];
        for (int x : restricted) {
            isRestricted[x] = true;
        }

        List<Integer> list = graph[0];

        traverse(0, isRestricted, graph);
        return cnt;

    }

    void traverse(int x, boolean[] isRestricted, List<Integer>[] graph) {
        if (visited[x] || isRestricted[x])
            return;

        cnt++;
        visited[x] = true;
        List<Integer> list = graph[x];
        for (Integer num : list) {
            traverse(num, isRestricted, graph);
        }
    }

    List<Integer>[] bulidGraph(int[][] edges, int n) {
        //这表示一个数组,其元素类型是 List<Integer>。
        //List<Integer>[] 就是一个数组，其中的每个元素都是一个可以存储 Integer 对象的列表。
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            //初始化
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}

