package Type_.图论算法.遍历基础.DFS;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/keys-and-rooms/description/">841. 钥匙和房间</a>
 */
public class a841钥匙和房间 {
    class Solution1 {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            List<Integer>[] g = new List[n];
            Arrays.setAll(g,i->new ArrayList<>());

            for (int i = 0; i < rooms.size(); i++) {
                List<Integer> room = rooms.get(i);
                for (Integer key : room) {
                    g[i].add(key);
                }
            }

            //0 ,[1]
            //1 ,[2]
            //2 ,[3]
            //3 ,[]
            boolean[] vis = new boolean[n];
            traverse(g,vis,0);
            for (boolean b : vis)
                if(!b)
                    return false;
            return true;
        }
        private void traverse(List<Integer>[] g,boolean[] vis,int start){
            if(start < 0 || start >= g.length || vis[start])
                return;
            vis[start] = true;
            for (Integer key : g[start]) {
                traverse(g,vis,key);
            }
        }
    }

    class Solution2 {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            boolean[] vis = new boolean[n];
            traverse(rooms,vis,0);
            for (boolean b : vis)
                if(!b)
                    return false;
            return true;
        }
        private void traverse(List<List<Integer>> g,boolean[] vis,int start){
            if(start < 0 || start > g.size() || vis[start])
                return;
            vis[start] = true;
            for (Integer key : g.get(start)) {
                traverse(g,vis,key);
            }
        }
    }
}
