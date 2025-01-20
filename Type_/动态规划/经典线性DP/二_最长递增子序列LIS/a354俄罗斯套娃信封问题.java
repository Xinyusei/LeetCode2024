package Type_.动态规划.经典线性DP.二_最长递增子序列LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/11
 * @Description:
 */
public class a354俄罗斯套娃信封问题 {
    class Solution {
        //求最长严格递增子序列需要二分找到大于或等于当前元素的元素位置（即lower_bound）；
        //求最长不降子序列需要二分找到大于当前元素的元素位置（即upper_bound）。


        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (o1, o2) -> {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            });
            //必须要保证对于每一种 w 值，我们最多只能选择 1 个信封。
            //将 h 值作为排序的第二关键字进行降序排序，这样对于每一种 w 值，其对应的信封在排序后的数组中是按照 h 值递减的顺序出现的
            //那么这些 h 值不可能组成长度超过 1 的严格递增的序列，这就从根本上杜绝了错误的出现。

            //System.out.println(Arrays.deepToString(envelopes));
            //先将信封按照宽度排序
            int n = envelopes.length;
            //dp[i]表示以envelopes[i]结尾的最多套娃信封个数
            List<Integer> g = new ArrayList<>();
            g.add(envelopes[0][1]);
            //g[i] 表示当前长度为i+1的严格单调递增子序列末尾的最小元素
            //考虑当前元素 e[i]如果 e[i] 大于 g 中的最大值，那么  e[i]就可以接在 f 中的最大值之后，形成一个长度更长的严格递增子序列；
            //否则我们找出 f 中比 e[i] 严格小的最大的元素f[j] ，即 f[j] < e[i] <= f[j + 1] ，那么 e[i] 可以接在 f[j] 之后
            // 形成一个长度为 j + 1 的严格递增子序列，因此需要对 f[j + 1] 进行更新：f[j + 1] = e[i]
            for (int i = 1; i < n; i++) {
                //base case
                int j = lowerBound(g, envelopes[i][1]);
                if (j == g.size()) {
                    g.add(envelopes[i][1]);
                } else {
                    g.set(j, envelopes[i][1]);
                }
            }
            return g.size();
        }

        //去找 g中 >= x 的最小元素的索引
        private int lowerBound(List<Integer> g, int x) {
            int lo = 0, hi = g.size();
            while (lo < hi) {
                int mid = (hi - lo) / 2 + lo;
                //[lo,mid) mid [mid+1,hi)
                if (g.get(mid) >= x) {
                    hi = mid;
                } else
                    lo = mid + 1;
            }
            return hi;
        }
    }

    class Solution1 {
        /**
         * 会超时
         *
         * @param envelopes
         * @return
         * @author ZJX
         * @date 2024/12/11
         */
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0])
                        return o2[1] - o1[1];
                    return o1[0] - o2[0];

                }
            });
            //System.out.println(Arrays.deepToString(envelopes));
            //先将信封按照宽度排序
            int n = envelopes.length;
            //dp[i]表示以envelopes[i]结尾的最多套娃信封个数
            int[] dp = new int[n];

            for (int i = 0; i < n; i++) {
                //base case
                dp[i] = 1;
                //判断envelops[i]能否装下前面的信封
                for (int j = 0; j < i; j++) {
                    //如果高度更高,说明可以装入
                    if (envelopes[i][0] != envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            int res = 1;
            for (int j : dp) {
                res = Math.max(res, j);
            }
            return res;
        }
    }
}
