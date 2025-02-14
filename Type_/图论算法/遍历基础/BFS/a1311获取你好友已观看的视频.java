package Type_.图论算法.遍历基础.BFS;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/get-watched-videos-by-your-friends/description/">1311. 获取你好友已观看的视频</a>
 */
public class a1311获取你好友已观看的视频 {
    class Solution {
        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
            List<Integer> queue = new ArrayList<>();
            queue.add(id);
            List<String> v = new ArrayList<>();
            int dis = 0;
            boolean[] vis = new boolean[friends.length];
            vis[id] = true;
            while (!queue.isEmpty()) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    Integer cur = queue.removeFirst();
                    for (int f : friends[cur]) {
                        //将朋友加入队列
                        if (vis[f])
                            continue;
                        queue.addLast(f);
                        vis[f] = true;
                    }
                    if (dis == level)
                        v.addAll(watchedVideos.get(cur));
                }
                dis++;
            }
            HashMap<String, Integer> v_cnt = new HashMap<>();
            for (String s : v)
                v_cnt.put(s, v_cnt.getOrDefault(s, 0) + 1);
            List<String> ans = new ArrayList<>(v_cnt.keySet());
            ans.sort((a, b) -> {
                if (!Objects.equals(v_cnt.get(a), v_cnt.get(b))) {
                    return v_cnt.get(a) - v_cnt.get(b);
                } else
                    return a.compareTo(b);
            });
            return ans;
        }
    }
}
