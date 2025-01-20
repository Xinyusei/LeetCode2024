package Type_.动态规划.一入门DP.爬楼梯;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2025/01/20
 * @Description:
 */
public class a70爬楼梯 {
    /**
     * DP table
     */
    class S2 {
        class Solution {
            public int climbStairs(int n) {
                if (n == 1 || n == 2)
                    return n;
                int[] f = new int[n + 10];
                f[1] = 1;
                f[2] = 2;
                for (int i = 3; i <= n; i++) {
                    f[i] = f[i - 1] + f[i - 2];
                }
                return f[n];
            }
        }
    }

    /**
     * DFS + memo
     */
    class S1 {
        class Solution {
            int[] memo;

            public int climbStairs(int n) {
                memo = new int[n + 1];
                Arrays.fill(memo, -1);
                return f(n);

            }

            public int f(int n) {
                if (n == 1 || n == 2)
                    return n;
                if (memo[n] != -1)
                    return memo[n];
                return memo[n] = (f(n - 1) + f(n - 2));
            }
        }
    }
}
