package 面试必刷;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/24
 * @Description:
 */
public class a135分发糖果 {
    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length, res = 0;
            int[] candy = new int[n];
            Arrays.fill(candy, 1);
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1])
                    candy[i] = candy[i - 1] + 1;
            }
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1])
                    candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
            for (int c : candy) {
                res += c;
            }
            return res;
        }
    }
}
