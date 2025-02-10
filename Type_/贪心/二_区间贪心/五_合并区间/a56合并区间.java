package Type_.贪心.二_区间贪心.五_合并区间;

import java.util.*;

/**
 * @Author: ZJX
 * @Date: 2025/02/10
 * @Description:
 */
public class a56合并区间 {
    //todo
    class S1 {
        class Solution {
            public int[][] merge(int[][] intervals) {
                //1.按左端点排序
                Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
                //2.合并区间
                List<int[]> res = new ArrayList<>();

                res.add(intervals[0]);

                for (int i = 1; i < intervals.length; i++) {
                    int[] curr = intervals[i];

                    int[] last = res.getLast();

                    if (curr[0] <= last[1]) {
                        last[1] = Math.max(last[1], curr[1]);
                    } else {
                        res.add(curr);
                    }
                }
                return res.toArray(new int[res.size()][0]);


            }
        }
    }

    class S2 {
        class Solution {
            public int[][] merge(int[][] intervals) {
                //1.按左端点排序
                Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
                //2.合并区间
                List<int[]> res = new ArrayList<>();

                for (int[] curr : intervals) {
                    if (!res.isEmpty() && curr[0] <= res.getLast()[1]) {
                        res.getLast()[1] = Math.max(res.getLast()[1], curr[1]);
                    } else {
                        res.add(curr);
                    }
                }
                return res.toArray(new int[res.size()][0]);
            }
        }
    }
}
