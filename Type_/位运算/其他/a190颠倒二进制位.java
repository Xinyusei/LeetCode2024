package Type_.位运算.其他;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2025/01/15
 * @Description:
 */
public class a190颠倒二进制位 {
    /**
     * 效率更高 ，边计算 n的当前位 边计算结果
     */
    class S1 {
        public class Solution {
            // you need treat n as an unsigned value
            public int reverseBits(int n) {
                int res = 0;
                //迭代32次 或者 n为0的时候提前结束
                for (int i = 1; i <= 32 && n != 0; i++, n >>>= 1) {
                    res |= (n & 1) >>> (32 - i);
                }
                return res;
            }
        }
    }

    /**
     * 效率较低
     */
    class S2 {
        public class Solution {
            // you need treat n as an unsigned value
            public int reverseBits(int n) {
                List<Integer> q = new ArrayList<>();
                for (int i = 1; i <= 32 && n != 0; i++, n >>>= 1) {
                    int cur = n & 1;
                    q.addLast(cur);
                }
                int res = 0;
                for (Integer cur : q) {
                    res <<= 1;
                    res += cur;
                }
                return res;
            }
        }
    }
}
