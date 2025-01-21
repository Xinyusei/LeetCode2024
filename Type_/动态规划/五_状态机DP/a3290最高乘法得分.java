package Type_.动态规划.五_状态机DP;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/18
 * @Description:
 */
public class a3290最高乘法得分 {
    class Solution {
        public long maxScore(int[] a, int[] b) {
            int n = b.length;
            int k = 4;
            long[][] f = new long[n + 1][k + 1];
            //f[i][j]表示从前 i 个数中选出 数组b中的 j 个数与a[0]~a[j - 1]进行点积得到的最大得分
            Arrays.fill(f[0], 1, 5, Long.MIN_VALUE >> 1);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    f[i][j] = Math.max(
                            f[i - 1][j],
                            f[i - 1][j - 1] + (long) a[j - 1] * b[i - 1]);
                }
            }
            return f[n][k];
        }
    }

    class Solution1 {

        long[][] memo;

        public long maxScore(int[] a, int[] b) {
            int k = 4;
            int n = b.length;
            // 分解问题很重要
            //定义 dfs(i,j)表示从b[0]到b[i] 选 j个数,与a[0]到a[j - 1]计算点积,结果的最大值
            memo = new long[n][k];
            for (long[] row : memo) {
                Arrays.fill(row, Long.MIN_VALUE); //表示没有遍历过
            }
            return dfs(n - 1, k, a, b);
        }

        private long dfs(int i, int j, int[] a, int[] b) {
            if (j <= 0) //选完了
                return 0;

            if (i < 0) //j >= 1 ,没选完
                return Long.MIN_VALUE >> 1;

            if (memo[i][j] != Long.MIN_VALUE)
                return memo[i][j];
            return memo[i][j] = Math.max(
                    dfs(i - 1, j - 1, a, b) + ((long) a[j - 1] * b[i]),
                    dfs(i - 1, j, a, b));
        }
    }
}
