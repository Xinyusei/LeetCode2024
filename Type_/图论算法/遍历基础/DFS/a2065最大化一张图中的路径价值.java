package Type_.图论算法.遍历基础.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-path-quality-of-a-graph/description/?envType=daily-question&envId=2024-07-01">2065. 最大化一张图中的路径价值</a>
 */
public class a2065最大化一张图中的路径价值 {
    class Solution {
        public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
            int n = values.length;
            List<int[]>[] g = new ArrayList[n];
            Arrays.setAll(g,i ->new ArrayList<>());
            //建图
            for (int[] e : edges) {
                int x = e[0];
                int y = e[1];
                int w = e[2];
                g[x].add(new int[]{y,w});
                g[y].add(new int[]{x,w});
            }
            boolean[] vis = new boolean[n];
            vis[0] = true;

            return dfs(0,0,values[0],vis,g,values,maxTime);
        }

        private int dfs(int x,int sumTime,int sumValue,boolean[] vis,List<int[]>[] g,int[] values,int maxTime) {
            int res = x  == 0 ? sumValue : 0;
            for (int[] e : g[x]) {
                int y = e[0];
                int w = e[1];
                if(sumTime + w > maxTime)
                    continue;
                if(vis[y])
                    res = Math.max(res,dfs(y,sumTime + w,sumValue,vis,g,values,maxTime));
                else {
                    vis[y] = true;
                    res = Math.max(res,dfs(y,sumTime + w,sumValue + values[y],vis,g,values,maxTime));
                    vis[y] = false;
                }
            }
            return res;
        }
    }
}
