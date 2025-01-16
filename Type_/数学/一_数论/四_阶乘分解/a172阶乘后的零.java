package Type_.数学.一_数论.四_阶乘分解;

/**
 * @Author: ZJX
 * @Date: 2025/01/16
 * @Description:
 */
public class a172阶乘后的零 {

    class S2_1{

    }
    class S1_1 {
        class Solution {
            public int trailingZeroes(int n) {
                //1  3 4  6 7 8 9 （2 * 5） （2 * 5）
                int res = 0;
                long divisor = 5;
                while (divisor <= n) {
                    res += (int) (n / divisor);
                    divisor *= 5;
                }
                return res;
            }
        }
    }

    class S1_2 {
        class Solution {
            public int trailingZeroes(int n) {
                //1  3 4  6 7 8 9 （2 * 5） （2 * 5）
                int res = 0;
                for (long divisor = 5; divisor <= n; divisor *= 5) {
                    res += n / divisor;
                }
                return res;
            }
        }
    }
}
