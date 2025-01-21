package Type_.动态规划.五_状态机DP;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/18
 * @Description:
 */
public class a1262可被三整除的最大和 {
    class Solution {
        int[][] memo;
        int d = 3;

        public int maxSumDivThree(int[] nums) {
            int n = nums.length;
            memo = new int[n][d];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            int res = dfs(n - 1, nums, 0);
            return res == Integer.MIN_VALUE ? 0 : res;
        }

        //dfs(i,nums,j)表示从nums[0~i]中选数,还要选的 [数字之和]s满足： s mod d = j的前提下，s的最大值
        private int dfs(int i, int[] nums, int j) {
            if (i < 0)
                return j == 0 ? 0 : Integer.MIN_VALUE;
            //假设有一个空数组或者已经遍历完所有元素但还没有达到目标模 3 结果为 0 的情况：
            //j == 0表示 ：说明我们可以用零个元素构成一个和为 0 的子集，所以返回 0
            //j > 0 表示 ：我们不可能通过选择这些元素使得总和模 3 等于 0，返回 Integer.MIN_VALUE 来标记这是一个无效的情况
            if (memo[i][j] != -1) return memo[i][j]; // 之前计算过
            int res = Math.max(
                    //不选当前元素 变成从 nums[0] 到 nums[n−2] 中寻找能被 j 整除的元素最大和
                    dfs(i - 1, nums, j),
                    //选 当前元素，问题变成从 nums[0] 到 nums[i−2] 中选数，满足 元素的最大和 (s + x) mod d = j
                    //即 s mod d = (j − x ) mod d 的前提下，s 的最大值。
                    // 即 dfs(i,j)=dfs(i−1,(j−x) mod d)+x。 这里 （j - x) mod d可能在[0~d-1]之外，需要重新映射到范围内

                    dfs(i - 1, nums, ((j - nums[i]) % d + d) % d) + nums[i]);
            //如果更改 j 的定义为 [已经选的数字之和]则变为
            //dfs(i - 1, nums, (j + nums[i]) % d) + nums[i];

            return memo[i][j] = res;
        }
    }

    class Solution2 {
        class Solution{
            public int maxSumDivThree(int[] nums) {
                int N = 3;
                return doGetMaxSumDivN(nums, N);
            }

            private int doGetMaxSumDivN(int[] nums, int N) {
                int n = nums.length;
                int[][] f = new int[n + 1][N];
                //f[0][1] = f[0][2] = Integer.MIN_VALUE;
                for (int i = 0, j = 1; j < N; j++)
                    f[i][j] = Integer.MIN_VALUE;
                //f(i,j)表示从nums[0~i]中选数,后续还要选的 [数字之和]s满足： s mod d = j的前提下，s的最大值
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j < N; j++) {
                        f[i][j] = Math.max(
                                //不选
                                f[i - 1][j],
                                //选
                                f[i - 1][((j - nums[i - 1] % N) + N) % N] + nums[i - 1]);
                    }
                }
                //end : 到nums[0...n - 1] mod N 余数为 0 的最大和
                return f[n][0];
            }
        }
    }
}
