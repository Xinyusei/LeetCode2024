package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求最大or最长;

/**
 * 2730. 找到最长的半重复子字符串
 * https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/description/
 */
public class a2730找到最长的半重复子字符串 {
    class Solution {
        public int longestSemiRepetitiveSubstring(String s) {
            if (s.length() == 1)
                return 1;
            int cnt = 0, ret = 0;
            int lo = 0, hi = 1;
            for (; hi < s.length(); hi++) {
                if (s.charAt(hi) == s.charAt(hi - 1)) {
                    cnt++;
                    if (cnt > 1) {
                        ret = Math.max(ret, hi - lo);
                        while (cnt > 1) {
                            if (s.charAt(lo) == s.charAt(lo + 1)) {
                                cnt--;
                            }
                            lo++;
                        }
                    }
                }
            }
            return Math.max(ret, hi - lo);
        }
    }
}
