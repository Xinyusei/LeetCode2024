package Type_.动态规划.打家劫舍;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @Author: ZJX
 * @Date: 2024/12/02
 * @Description:
 */
public class a3186施咒的最大总伤害 {
    class Solution1 {
        //OOM
        public long maximumTotalDamage(int[] power) {
            HashMap<Integer, Long> record = new HashMap<>();
            int mx = 0;
            for (int v : power) {
                record.put(v, record.getOrDefault(v, 0L) + v);
                mx = Math.max(mx, v);
            }
            long[] f = new long[mx + 1];
            f[0] = record.getOrDefault(0, 0L);
            f[1] = Math.max(record.getOrDefault(0, 0L), record.getOrDefault(1, 0L));
            if (mx >= 2)
                f[2] = Math.max(record.getOrDefault(2, 0L), Math.max(record.getOrDefault(0, 0L), record.getOrDefault(1, 0L)));
            for (int i = 3; i <= mx; i++) {
                f[i] = Math.max(Math.max(f[i - 1], f[i - 2]), f[i - 3] + record.getOrDefault(i, 0L));
            }
            return f[mx];
        }
    }

    class Solution2 {
        //1,6,6,7

        //1,1,3,4
        public long maximumTotalDamage(int[] power) {
            HashMap<Integer, Integer> record = new HashMap<>();
            int mx = 0;
            for (int v : power) {
                record.put(v, record.getOrDefault(v, 0) + 1);
                mx = Math.max(mx, v);
            }
            long p0 = 0;
            long p1 = (long) record.getOrDefault(1, 0);
            long p2 = 0;
            if (mx >= 2)
                p2 = Math.max(record.getOrDefault(2, 0) * 2, Math.max(p0, p1));
            long p3 = Math.max(Math.max(p2, p1), p0 + record.getOrDefault(3, 0) * 3L);
            for (int i = 3; i <= mx; i++) {
                p3 = Math.max(Math.max(p2, p1), p0 + (long) record.getOrDefault(i, 0) * i);
                p0 = p1;
                p1 = p2;
                p2 = p3;
            }
            //p0 p1 p2 p3
            //   p0 p1 p2 p3
            return p3;
        }
    }


    class Solution3 {
        class Solution {
            public long maximumTotalDamage(int[] power) {
                Map<Integer, Integer> cnt = new HashMap<>();
                for (int x : power) {
                    //统计每个元素的出现次数，记到哈希表 cnt 中。
                    cnt.merge(x, 1, Integer::sum);
                }
                int n = cnt.size();
                int[] arr = new int[n];
                int idx = 0;
                //将哈希表的 key 整理到数组 arr 中，把 arr 按照从小到大的顺序排序。
                for (Integer x : cnt.keySet()) {
                    arr[idx++] = x;
                }
                Arrays.sort(arr);

                //arr: 1,6,7
                //arr: 1,3,4
                //定义f[i] 表示从arr[0] 到 arr[i - 1] 中选择,可以得到的伤害之和的最大值
                long[] f = new long[n + 1];
                int j = 0;
                for (int i = 1; i <= n; i++) {
                    int x = arr[i - 1];
                    while (arr[j] < x - 2) {
                        j++;
                    }
                    //如果不选当前的,则f[i] = f[i - 1]
                    //如果选,则伤害值等于 arr[i - 1] - 1 ,arr[i - 1] - 2的不能选, 从arr[0] 到 arr[j - 1]中选择,可以得到的伤害的最大值,其中j最小的满足arr[j] >= a[i - 1] - 2
                    f[i] = Math.max(f[i - 1], f[j] + (long) x * cnt.get(x));
                }
                return f[n];
            }
        }
    }
}
