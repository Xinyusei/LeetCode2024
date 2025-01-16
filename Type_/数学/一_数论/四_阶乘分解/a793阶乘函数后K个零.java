package Type_.数学.一_数论.四_阶乘分解;

/**
 * @Author: ZJX
 * @Date: 2025/01/16
 * @Description:
 */
public class a793阶乘函数后K个零 {
    class S1 {
        class Solution {
            private final static long mx = Long.MAX_VALUE;

            // 数学 + 二分
            public int preimageSizeFZF(int k) {
                long left = leftBound(k);
                long right = leftBound(k + 1) - 1;
                return (int) (right - left + 1);
            }

            private long f(long n) {
                long res = 0;
                for (long i = 5; i <= n; n /= 5) {
                    res += n / 5;
                }
                return res;
            }

            //找到 满足条件的最小索引
            private long leftBound(long k) {
                long lo = 0, hi = mx;
                while (lo <= hi) {
                    long mid = ((hi - lo) >> 1) + lo;
                    if (f(mid) >= k)
                        hi = mid - 1;
                    else
                        lo = mid + 1;
                }
                return hi + 1;
            }
        }
    }
}

