package 周赛.w426;

/**
 * @Author: ZJX
 * @Date: 2024/12/01
 * @Description:
 */
public class a仅含置位位的最小整数 {
    class Solution {
        public int smallestNumber(int n) {
            int x = 1;
            //2 1 0
            //2 4 8
            while (n > 0){
                n >>= 1;
                x <<= 1;
            }
            return x - 1;

        }
    }
}
