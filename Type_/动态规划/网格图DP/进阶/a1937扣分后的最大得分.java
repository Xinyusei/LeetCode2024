package Type_.动态规划.网格图DP.进阶;

import javax.lang.model.element.Name;

/**
 * @Author: ZJX
 * @Date: 2024/12/06
 * @Description:
 */
public class a1937扣分后的最大得分 {
    class Solution {
        public long maxPoints(int[][] points) {
            int m = points.length, n = points[0].length;

            long[][] f = new long[m][n];
            //定义 f[i][j] 表示前 i 行中，第 i 行选择 points[i][j] 时的最大得分。通过枚举上一行的转移来源 k，我们有
            //f[i][j]=points[i][j]+maxf[i−1][k]−∣k−j∣
            //但是会超时
            //拆掉绝对值符号，并将 j 提出来 ，遍历到f[i][j] 的时候 points[i][j] 和 j 是确定的，不确定的状态为：maxf[i−1][k]+k 和 maxf[i−1][k]−k
            //f[i][j]=points[i][j]−j+maxf[i−1][k]+k, k<=j
            //f[i][j]=points[i][j]+j+maxf[i−1][k]−k, k>j

            long res = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                f[0][j] = points[0][j];
            }
            for (int i = 1; i < m; i++) {

                //在计算 f[i][j] 时，我们需要知道位置 j 左侧的 f[i−1][k]+k 的最大值，以及位置 j 右侧的 f[i−1][k]−k 的最大值。
                long cur = f[i - 1][0];
                for (int j = 0; j < n; j++) {
                    //从左侧正序遍历一次,计算 j 左侧的 f[i−1][k]+k 的最大值 cur
                    cur = Math.max(cur, f[i - 1][j] + j);
                    f[i][j] = Math.max(f[i][j], cur + points[i][j] - j);
                }
                //从右侧倒序遍历一次,计算 j 右侧的 f[i−1][k] - k 的最大值 cur
                cur = f[i - 1][n - 1] - n + 1;
                for (int j = n - 1; j >= 0; j--) {
                    cur = Math.max(cur, f[i - 1][j] - j);
                    f[i][j] = Math.max(f[i][j], cur + points[i][j] + j);
                }
            }
            for (int i = m - 1, j = 0; j < n; j++)
                res = Math.max(res, f[i][j]);
            return res;
        }
    }
}
