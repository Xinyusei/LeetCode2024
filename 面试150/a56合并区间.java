package 面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/30
 * @Description:
 */
public class a56合并区间 {

    /**
     * 利用已经添加的元素的性质
     */
    class S2 {
        class Solution {
            public int[][] merge(int[][] intervals) {
                //按照左端点从小到大排序
                Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
                int n = intervals.length, i = 0;
                List<int[]> ls = new ArrayList<>();

                for (int[] p : intervals) {
                    int m = ls.size();
                    //有相交 , 可以合并,更新 右端点
                    if (m > 0 && ls.get(m - 1)[1] >= p[0])
                        ls.get(m - 1)[1] = Math.max(ls.get(m - 1)[1], p[1]);
                    else
                        //不相交,无法合并,增加新的合并的区间
                        ls.add(p);
                }
                return ls.toArray(new int[ls.size()][2]);
            }
        }
    }

    class S1 {
        class Solution {
            public int[][] merge(int[][] intervals) {
                //按照左端点从小到大排序
                Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
                int n = intervals.length, i = 0;
                List<int[]> ls = new ArrayList<>();
                while (i < n) {
                    int low = i, start = intervals[low][0], end = intervals[low][1];
                    i++;
                    while (i < n && intervals[i][0] <= end) {
                        end = Math.max(end, intervals[i][1]);
                        i++;
                    }
                    ls.add(new int[]{start, end});
                }
                return ls.toArray(new int[ls.size()][2]);
            }
        }
    }

}
