package 面试150;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/22
 * @Description:
 */
public class a274H指数 {
    /**
     * 对[引用值进行二分]
     */
    class S1 {
        class Solution {
            public int hIndex(int[] cs) {
                //H 指数 ： 至少有 H 篇论文的引用次数大于 H
                int lo = 0, hi = cs.length;
                //对 [论文引用数] 进行二分 h指数不可能超过cs的长度
                while (lo < hi) {
                    int mid = (hi + lo) >> 1;
                    //mid代表当前的h指数
                    if (check(cs, mid)) {
                        //这里缩小范围到[mid + 1,hi) lo和lo-1都是有可能取到的
                        lo = mid + 1;
                    } else
                        //mid 不能取,缩小到[lo,mid)
                        hi = mid;
                }
                if (lo >= 0 && check(cs, lo))
                    return lo;
                int h = lo - 1;
                if (h >= 0 && check(cs, h))
                    return h;
                return 0;
            }

            private boolean check(int[] cs, int h) {
                int cnt = 0;
                //寻找cs中大于等于h的论文数
                for (int v : cs) {
                    if (v >= h) cnt++;
                }
                return cnt >= h;
            }
        }
    }

    /**
     * 计数
     */
    class S2 {
        class Solution {
            public int hIndex(int[] cs) {
                int n = cs.length;
                int[] record = new int[n + 1];
                for (int v : cs) {
                    record[Math.min(v, n)]++;
                }
                //0，1，3，5，
                //1，1，1，2
                int total = 0;
                for (int i = n; i >= 0; i--) {
                    total += record[i];
                    if (total >= i)
                        return i;
                }
                return -1;
            }
        }
    }
}
