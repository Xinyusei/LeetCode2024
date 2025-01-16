package Type_.数学.杂项.计算;

/**
 * @Author: ZJX
 * @Date: 2025/01/16
 * @Description:
 */
public class a69x的平方根 {
    class S1 {
        class Solution {
            public int mySqrt(int x) {
                int lo = 0, hi = Math.min(x, 46340) + 1;
                while (lo < hi) {
                    int mid = ((hi - lo) >> 1) + lo;
                    int v = mid * mid;
                    //循环不变量
                    if (v <= x) {
                        lo = mid + 1;
                    } else
                        hi = mid;
                }
                //结束:lo = hi, 此时 lo^2 <= x 且 hi^2 >x
                return lo - 1;
            }
        }
    }
}
