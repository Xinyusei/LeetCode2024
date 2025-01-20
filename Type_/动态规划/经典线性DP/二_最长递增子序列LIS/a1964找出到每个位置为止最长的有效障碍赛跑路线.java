package Type_.动态规划.经典线性DP.二_最长递增子序列LIS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/11
 * @Description:
 */
public class a1964找出到每个位置为止最长的有效障碍赛跑路线 {
    class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            //求最长严格递增子序列需要二分找到大于或等于当前元素的元素位置（即lower_bound）；
            //求最长不降子序列需要二分找到大于当前元素的元素位置（即upper_bound）。
            //1 2 3
            //LIS - 用灵神的思路
            //g[i] 表示 : 长度为 i + 1 的 非递减子序列的 末尾元素的最小值
            int n = obstacles.length;
            List<Integer> g = new ArrayList<>();
            int[] f = new int[n];
            for (int i = 0; i < n; i++) {
                int idx = upperBound(g, obstacles[i]);
                //说明是新增的元素
                if (idx != g.size())
                    g.set(idx, obstacles[i]);
                else
                    g.add(obstacles[i]);
                f[i] = idx + 1;
            }
            return f;
        }

        //找到 > x 的最小索引
        private int upperBound(List<Integer> g, int x) {
            int lo = 0, hi = g.size();
            while (lo < hi) {
                int mid = (hi - lo) / 2 + lo;
                //[lo,mid) mid [mid + 1,hi)
                if (g.get(mid) > x)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            return hi;
        }
    }
}
