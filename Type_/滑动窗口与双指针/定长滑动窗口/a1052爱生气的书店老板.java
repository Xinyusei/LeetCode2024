package Type_.滑动窗口与双指针.定长滑动窗口;

/**
 * 1052. 爱生气的书店老板
 * https://leetcode.cn/problems/grumpy-bookstore-owner/description/
 */
public class a1052爱生气的书店老板 {
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int window = 0;
            for (int hi = 0; hi < minutes; hi++)
                window += customers[hi];
            for (int other = minutes; other < customers.length; other++)
                if (grumpy[other] == 0)
                    window += customers[other];
            int ans = window;
            for (int hi = minutes; hi < customers.length; hi++) {
                if(grumpy[hi] == 1)
                    window += customers[hi];
                if(grumpy[hi - minutes] == 0)
                    window += customers[hi - minutes];
                ans = Math.max(ans,window);
            }
            return ans;
        }
    }
}
