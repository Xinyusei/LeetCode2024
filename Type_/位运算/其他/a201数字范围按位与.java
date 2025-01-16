package Type_.位运算.其他;

/**
 * @Author: ZJX
 * @Date: 2025/01/16
 * @Description:
 */
public class a201数字范围按位与 {
    class S1 {
        class Solution {
            public int rangeBitwiseAnd(int left, int right) {
                //其实是去找 left到right的所有数的公共前缀，由于是left +++ 到达的right，后缀是在不断变化的，等价于找 left 和 right的公共前缀

                //简单思考：只要第一个二进制位，只存0，1两种情况。如果left < right区间中必然存在 left + 1，那么最低位 & 一定为0。
                //因此 不断向右移位，直到 left = right，此时left & right = left ，找到原来移位的个数，就得到了之前后缀有多少个0，再左移shift即可。


                //101
                //110
                //10
                //11
                //1
                //1

                int shift = 0;

                //找到公共前缀
                while (left < right) {
                    left >>>= 1;
                    right >>>= 1;
                    shift++;
                }
                //将得到的公共前缀 - left 左移相同操作数
                return left << shift;
            }
        }
    }
}
