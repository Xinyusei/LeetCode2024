package Type_.网格图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/description/">...</a>
 */
public class a797所有可能的路径 {
    List<Integer> path;
    List<List<Integer>> res;

    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        this.n = graph.length - 1;


        traverse(0,graph);
        return res;
    }

    public void traverse(int num, int[][] g) {
        if (num == n) {
            path.addLast(num);
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        path.addLast(num);
        for (int point : g[num]) {
            traverse(point,g);
        }
        path.removeLast();
    }
}
