package 代码随想录.动态规划.背包问题.完全背包;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/11/03
 * @Description:
 */
public class a279完全平方数 {
    class Solution1 {
        public int numSquares(int n) {
            int[] f = new int[n + 1];
            Arrays.fill(f, n + 1);
            f[0] = 0;
            for (int i = 1; i * i <= n; i++) {
                int v = i * i;
                for (int j = v; j <= n; j++) {
                    f[j] = Math.min(f[j], f[j - v] + 1);
                }
            }
            return f[n];
        }
    }

    class Solution2 {
        public int numSquares(int n) {
            int[] f = new int[n + 1];
            Arrays.fill(f, n + 1);
            f[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++)
                    f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
            return f[n];
        }
    }
}
