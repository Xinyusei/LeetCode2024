package Type_.动态规划.三_背包问题.一_零一背包;

/**
 * @Author: ZJX
 * @Date: 2024/12/07
 * @Description:
 */
public class a1774最接近目标价格的甜点成本 {
    class Solution {

        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            int n = baseCosts.length, m = toppingCosts.length;
            int ans = -1, minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int state = 0; state < (int) Math.pow(3, m); state++) {
                    int cost = baseCosts[i];
                    int mask = state;
                    for (int k = 0; k < m; k++) {
                        cost += (mask % 3) * toppingCosts[k];
                        mask /= 3;
                    }
                    int diff = Math.abs(cost - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans = cost;
                    } else if (diff == minDiff && cost < ans) {
                        ans = cost;
                    }

                }
            }
            return ans;
        }
    }
}
