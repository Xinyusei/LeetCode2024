package 面试必刷;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2025/01/07
 * @Description:
 */
public class a399除法求值 {
    class S1 {

        class Solution {
            class Edge {
                String node;
                double weight;

                public Edge(String node, double weight) {
                    this.node = node;
                    this.weight = weight;
                }
            }

            public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
                //建立一个有向带权图
                Map<String, List<Edge>> g = new HashMap<>();
                for (int i = 0; i < equations.size(); i++) {
                    List<String> equation = equations.get(i);
                    String a = equation.get(0), b = equation.get(1);
                    double w = values[i];
                    // 构建双向带权图
                    g.putIfAbsent(a, new ArrayList<>());
                    g.putIfAbsent(b, new ArrayList<>());
                    g.get(a).add(new Edge(b, w));
                    g.get(b).add(new Edge(a, 1.0 / w));
                }

                double[] res = new double[queries.size()];
                for (int i = 0; i < queries.size(); i++) {
                    List<String> query = queries.get(i);
                    String start = query.get(0), end = query.get(1);
                    //计算 start 到 end 的 乘积
                    //res[i] = DFS(g, start, end, new HashSet<>());
                    res[i] = BFS(g, start, end);
                }
                return res;
            }


            private double DFS(Map<String, List<Edge>> g, String start, String end, Set<String> visited) {
                // 边界条件检查
                if (!g.containsKey(start) || !g.containsKey(end))
                    return -1.0;
                if (start.equals(end) || visited.contains(start))
                    return 1.0;
                // 标记当前节点为已访问
                visited.add(start);
                for (Edge edge : g.get(start)) {
                    if (!visited.contains(edge.node)) {
                        double w = DFS(g, edge.node, end, visited);
                        if (w != -1.0)
                            return w * edge.weight; // 找到路径，返回累乘结果
                    }
                }
                // 回溯时移除访问标记
                visited.remove(start);
                // 未找到路径
                return -1.0;
            }


            private double BFS(Map<String, List<Edge>> g, String start, String end) {
                // 边界条件检查
                if (!g.containsKey(start) || !g.containsKey(end))
                    return -1.0;
                if (start.equals(end))
                    return 1.0;

                // BFS 标准框架
                List<String> queue = new ArrayList<>();
                queue.add(start);
                HashSet<String> visited = new HashSet<>();
                visited.add(start);

                // key 为节点 ID（变量名），value 记录从 start 到该节点的路径乘积
                Map<String, Double> pathWeight = new HashMap<>();
                pathWeight.put(start, 1.0);
                while (!queue.isEmpty()) {
                    String cur = queue.removeFirst();
                    for (Edge edge : g.get(cur)) {
                        if (visited.contains(edge.node)) {
                            continue;
                        }
                        // 更新路径乘积
                        pathWeight.put(edge.node, edge.weight * pathWeight.get(cur));
                        if (edge.node.equals(end))
                            return pathWeight.get(end);

                        // 记录 visited
                        visited.add(edge.node);
                        // 加入队列，继续遍历
                        queue.add(edge.node);
                    }
                }
                return -1.0;
            }
        }
    }
}
