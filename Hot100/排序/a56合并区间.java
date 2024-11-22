package Hot100.排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/22
 * @Description:
 */
public class a56合并区间 {
    class Solution1 {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> ls = new LinkedList<>();

            ls.add(intervals[0]);
            int n = intervals.length;
            for (int i = 1; i < n; i++) {
                int[] curr = intervals[i];

                int[] last = ls.getLast();
                //可以合并
                if (last[1] >= curr[0]) {
                    last[1] = Math.max(last[1], curr[1]);
                } else
                    ls.add(curr);
            }
            return ls.toArray(new int[ls.size()][0]);
        }
    }


    class Solution2 {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            List<int[]> ls = new LinkedList<>();
            int n = intervals.length;
            for (int i = 0; i < n; ) {
                //记录能合并的区间的右端点
                int leftMax = intervals[i][1];
                int j = i + 1;
                while (j < n && intervals[j][0] <= leftMax) {
                    leftMax = Math.max(leftMax, intervals[j][1]);
                    j++;
                }
                //i到j-1是能合并的区间
                ls.add(new int[]{intervals[i][0], leftMax});
                i = j;
            }
            return ls.toArray(new int[ls.size()][0]);
        }
    }
}
