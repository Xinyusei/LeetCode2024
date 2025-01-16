package Type_.位运算.其他;

/**
 * @Author: ZJX
 * @Date: 2025/01/16
 * @Description:
 */
public class a137只出现一次的数字II {
    /**
     * 136. 只出现一次的数字
     */
    class S1_1 {

        class Solution {
            public int singleNumber(int[] nums) {
                int res = 0;
                for (int i = 0; i < 32; i++) {
                    //当前 位 出现的1的个数
                    int cnt = 0;
                    for (int x : nums) {
                        cnt += x >> i & 1;
                    }
                    res |= (cnt & 1) << i;
                }
                return res;
            }
        }
    }

    class S1_2 {
        class Solution {
            public int singleNumber(int[] nums) {
                int res = 0;
                for (int x : nums) {
                    res ^= x;
                }
                return res;
            }
        }
    }

    /**
     * 137. 只出现一次的数字 II
     */
    class S2 {
        class Solution {
            public int singleNumber(int[] nums) {
                int res = 0;
                for (int i = 0; i < 32; i++) {
                    int cnt = 0;
                    for (int x : nums) {
                        cnt += x >> i & 1;
                    }
                    res |= cnt % 3 << i;
                }
                return res;
            }
        }
    }
}
