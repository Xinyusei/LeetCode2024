package Type_.动态规划.三_背包问题.一_零一背包;

/**
 * 2787. 将一个数字表示成幂的和的方案数
 * https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/description/
 */
public class a2787将一个数字表示成幂的和的方案数 {
    class Solution {
        private static final int MOD = (int)1e9 + 7;
        public int numberOfWays(int n, int x) {
            // f[i][j] 表示 从1~i 中选取 几个互不相同的数(要么选要么不选)，恰好使得 这几个数的x次幂的和等于 j 的 方案数
            int[][] f = new int[n + 1][n + 1];

            //base case
            //当i = 0,也就是没有任何数字,数字之和一定为0。即f[0][0] = 1,f[0][1~n] = 0
            f[0][0] = 1;

            //当前 数字为 i的时候,只有当 j >= i ^ x的才能选取 i

            for(int i = 1;i <= n;i++){
                for(int j = 0;j <= n;j++){
                    int power = (int)Math.pow(i,x);
                    if(j < power)
                        f[i][j] = f[i - 1][j];
                    else
                        f[i][j] = (f[i - 1][j] + f[i - 1][j - power]) % MOD;
                }
            }
            return f[n][n];
        }
    }
}
