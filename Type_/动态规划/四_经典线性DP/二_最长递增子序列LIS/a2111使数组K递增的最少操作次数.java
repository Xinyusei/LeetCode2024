package Type_.动态规划.四_经典线性DP.二_最长递增子序列LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/11
 * @Description:
 */
public class a2111使数组K递增的最少操作次数 {
    class Solution {
        public int kIncreasing(int[] arr, int k) {
            List<Integer>[] g = new ArrayList[k];
            Arrays.setAll(g, i -> new ArrayList<>());
            int res = 0;
            //list[i] 表示 : 长度为 i + 1 的 非递减子序列的 末尾元素的最小值
            for (int i = 0; i < arr.length; i++) {
                List<Integer> list = g[i % k];
                int j = upperBound(list, arr[i]);
                if (j == list.size()) {
                    list.add(arr[i]);
                } else {
                    res++;
                    list.set(j, arr[i]);
                }
            }
            return res;
        }

        //找到 > x 的最小索引
        private int upperBound(List<Integer> g, int x) {
            int lo = 0, hi = g.size();
            while (lo < hi) {
                int mid = (hi - lo) / 2 + lo;
                //[lo,mid) mid [mid + 1,hi)
                if (g.get(mid) >= x)
                    lo = mid + 1;
                else
                    lo = mid;
            }
            return hi;
        }
    }
}
