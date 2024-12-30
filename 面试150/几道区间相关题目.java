package 面试150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/30
 * @Description: 分组循环的重要性
 */

public class 几道区间相关题目 {
    /**
     * 这三道是汇总 / 合并 / 插入 区间 - 找区间并集
     */
    class a228汇总区间 {

        /**
         * 不太容易出错的分组循环
         */
        class S2 {
            class Solution {
                public List<String> summaryRanges(int[] nums) {
                    List<String> res = new ArrayList<>();
                    int n = nums.length, i = 0;
                    while (i < n) {
                        //low 指向起点
                        int low = i;
                        i++;
                        while (i < n && nums[i] == nums[i - 1] + 1)
                            i++;
                        //high 指向终点
                        int high = i - 1;
                        StringBuilder sb = new StringBuilder(nums[low] + "");
                        if (low < high) {
                            sb.append("->").append(nums[high]);
                        }
                        res.add(sb.toString());
                    }
                    return res;
                }
            }
        }

        class S1 {
            class Solution {
                public List<String> summaryRanges(int[] nums) {

                    int n = nums.length;
                    List<String> res = new ArrayList<>();
                    if (n == 0)
                        return res;
                    int lo = 0;
                    for (int hi = 0; hi < n; hi++) {
                        //hi 向后遍历
                        if (hi + 1 < n && nums[hi + 1] - 1 != nums[hi]) {
                            //将当前区间写入
                            StringBuilder sb = new StringBuilder();
                            sb.append(nums[lo]);
                            if (hi != lo) {
                                sb.append("->").append(nums[hi]);
                            }
                            res.add(sb.toString());
                            lo = hi + 1;
                        }
                    }
                    return res;
                }
            }
        }
    }

    class a56合并区间 {

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

    class a57插入区间 {
        class S2 {
            class Solution {
                public int[][] insert(int[][] intervals, int[] newInterval) {
                    int[][] res = new int[intervals.length + 1][2];
                    int i = 0; //原数组指针
                    int idx = 0; //新数组指针
                    //遍历区间列表

                    //1.首先将新区间左边且相离的区间加入结果集
                    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                        res[idx++] = intervals[i++];
                    }

                    //2.找到了左端点可以合并的区间
                    //判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离

                    while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                        newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                        newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                        i++;
                    }
                    //将最终合并后的新区间加入结果集
                    res[idx++] = newInterval;

                    //3.将右边还剩下的区间加入结果集
                    while (i < intervals.length) {
                        res[idx++] = intervals[i++];
                    }
                    return Arrays.copyOf(res, idx);
                }
            }
        }

        /**
         * 先找到位置,插入,再合并区间
         */
        class S1 {
            class Solution {
                public int[][] insert(int[][] intervals, int[] newInterval) {
                    List<int[]> res = new ArrayList<>();
                    int left = newInterval[0];
                    if (intervals.length == 0)
                        return new int[][]{newInterval};
                    if (intervals[0][0] >= left) {
                        res.add(newInterval);
                        res.addAll(Arrays.asList(intervals));
                    } else if (left >= intervals[intervals.length - 1][0]) {
                        res.addAll(Arrays.asList(intervals));
                        res.add(newInterval);
                    } else {
                        for (int[] p : intervals) {
                            if (p[0] >= left) {
                                res.add(newInterval);
                            }
                            res.add(p);
                        }
                    }
                    return merge1(res);
                }

                public int[][] merge1(List<int[]> intervals) {
                    //按照左端点从小到大排序
                    //Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
                    int n = intervals.size(), i = 0;
                    List<int[]> ls = new ArrayList<>();
                    while (i < n) {
                        int low = i, start = intervals.get(low)[0], end = intervals.get(low)[1];
                        i++;
                        while (i < n && intervals.get(i)[0] <= end) {
                            end = Math.max(end, intervals.get(i)[1]);
                            i++;
                        }
                        ls.add(new int[]{start, end});
                    }
                    return ls.toArray(new int[ls.size()][2]);
                }
            }
        }
    }

    /**
     * 找区间交集
     */
    class a452用最少数量的箭引爆气球 {
        /**
         * 合并区间的并集 -> 找交集
         */
        class S1 {
            class Solution {
                public int findMinArrowShots(int[][] points) {
                    Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
                    //[1,6] [2,8] [7,12] [10,16]
                    //[2,6] [10,12]
                    int i = 0, n = points.length;
                    int cnt = 0;
                    while (i < n) {
                        int low = i, right = points[low][1];
                        i++;
                        //当前有重叠区间,但这里不是去找并集,而是找交集。
                        while (i < n && points[i][0] <= right) {
                            right = Math.min(right, points[i][1]);
                            i++;
                        }
                        cnt++;
                    }
                    return cnt;
                }
            }
        }
    }
}
