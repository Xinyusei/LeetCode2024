package Type_.滑动窗口与双指针.定长滑动窗口;

public class a2379得到K个黑块的最少涂色次数 {
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int ans = 0;
            for (int i = 0; i < k; i++) {
                if (blocks.charAt(i) == 'W')
                    ans++;
            }
            int window = ans;
            for (int i = k; i < blocks.length(); i++) {
                if (blocks.charAt(i - k) == 'W')
                    window--;
                if (blocks.charAt(i) == 'W')
                    window++;
                ans = Math.min(ans, window);
            }
            return ans;
        }
    }
}
