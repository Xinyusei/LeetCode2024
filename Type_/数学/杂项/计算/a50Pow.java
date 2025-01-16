package Type_.数学.杂项.计算;

/**
 * @Author: ZJX
 * @Date: 2025/01/16
 * @Description:
 */
public class a50Pow {
    class S1 {
        class Solution {
            public double myPow(double x, int N) {
                long n = N;
                if (n < 0) {
                    x = 1 / x;
                    n = -n;
                }
                //1010
                //Math.pow(2,10) = 2 ^ 1 + 2 ^ 3
                double res = 1;
                while (n > 0) { // 从低到高枚举 n 的每个比特位
                    if ((n & 1) == 1) { // 这个比特位是 1
                        res *= x; // 把 x 乘到 ans 中
                    }
                    x *= x; // x 自身平方
                    n >>= 1;  // 继续枚举下一个比特位
                }
                return res;
            }
        }
    }
}
