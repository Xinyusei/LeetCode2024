package Type_.滑动窗口与双指针.定长滑动窗口;

/**
 * 2269. 找到一个数字的 K 美丽值
 * https://leetcode.cn/problems/find-the-k-beauty-of-a-number/description/
 */
public class a2269找到一个数字的K美丽值 {
    class Solution {
        public int divisorSubstrings(int num, int k) {
            String s = Integer.toString(num);
            int ans = 0;
            for (int i = 0; i <= s.length() - k; i++) {
                String sub = s.substring(i, i + k);
                int N = Integer.parseInt(sub);
                if (N != 0 && num % N == 0)
                    ans++;
            }
            return ans;
        }
    }
}
