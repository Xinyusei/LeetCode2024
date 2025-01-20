package Type_.动态规划.三_背包问题.一_零一背包;

public class basic {

    class Solution1 {
        /**
         * 给你一个可装载重量为 capacity 的背包和 n 个物品,每个物品有重量和价值两个属性。
         * 其中第 i 个物品的重量为 w[i] ,价值为 v[i] ,现在让你用这个背包装物品,最多能装的价值是多少?
         * n = 3, capacity = 4
         * w = [2, 1, 3]
         * v = [4, 2, 3]
         *
         * @param v        第i个物品的价值
         * @param w        第i个物品的体积
         * @param capacity 背包容量
         * @return 在不超过背包容量的情况下，背包中放入的物品的最大价值
         */

        int[] v;

        int[] w;

        int capacity;

        public int zero_one_knapsack(int[] v, int[] w, int capacity) {
            this.v = v;
            this.w = w;
            this.capacity = capacity;

            return dfs(capacity, v.length - 1);
        }

        /**
         * @param capacity 当前背包的容量
         * @param i        当前是第几个物品
         * @return 在不超过capacity容量的情况下, 在前i个物品中加入了背包的物品的最大价值
         */

        private int dfs(int capacity, int i) {
            if (i < 0)
                return 0;
            if (capacity < w[i])
                return dfs(capacity, i - 1);
            //当前操作 ： 枚举当前物品，选/不选
            //选:在容量为capacity - w[i],从前i - 1个物品中得到的最大价值和
            //不选:在容量为capacity,从前i - 1个物品中得到的最大价值和
            return Math.max(dfs(capacity - w[i], i - 1) + v[i], dfs(capacity, i - 1));
        }
    }

    class Solution2 {
        /**
         * 给你一个可装载重量为 capacity 的背包和 n 个物品,每个物品有重量和价值两个属性。
         * 其中第 i 个物品的重量为 w[i] ,价值为 v[i] ,现在让你用这个背包装物品,最多能装的价值是多少?
         * n = 3, capacity = 4
         * w = [2, 1, 3]
         * v = [4, 2, 3]
         *
         * @param v        第i个物品的价值
         * @param w        第i个物品的体积
         * @param capacity 背包容量
         * @return 在不超过背包容量的情况下，背包中放入的物品的最大价值
         */
        public int zero_one_knapsack(int[] v, int[] w, int capacity) {
            int n = v.length;
            int[][] f = new int[n + 1][capacity + 1];
            //定义：f[i][c] 的定义如下：对于前 i 个物品，当前背包的容量为 c，这种情况下可以装的最大价值是 f[i][c]。
            //比如说，如果 f[3][5] = 6，其含义为：对于给定的一系列物品中，若只对前 3 个物品进行选择，当背包容量为 5 时，可以装下的价值最大为 6。
            //注意这里的下标i从(1)开始,表示从前(1)个物品开始取。
            for (int i = 1; i <= n; i++) {
                for (int c = w[i]; c <= capacity; c++) {
                    //如果把这第 i 个物品装入了背包，那么第 i 个物品的价值 val[i-1] 肯定就到手了
                    //接下来就要在剩余容量 c - w[i-1] 的限制下，在前 i - 1 个物品中挑选，求最大价值，即 f[i-1][c - w[i-1]]。
                    //f[i][c] 应该等于  f[i-1][c - w[i-1]] + v[i-1]。
                    //如果没有把这第 i 个物品装入背包，那么很显然，最大价值 f[i][c] 应该等于 f[i-1][w]，继承之前的结果。
                    f[i][c] = Math.max(f[i - 1][c - w[i - 1]] + v[i - 1], f[i - 1][c]);
                }
            }
            return f[n][capacity];
        }

    }

}
