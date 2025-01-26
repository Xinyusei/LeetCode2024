package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求最小or最短;

/**
 * https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 */
public class a1234替换子串得到平衡字符串 {
    class Solution {
        public int balancedString(String s) {
            int n = s.length();
            if (n < 4)
                return 0;
            int[] count = new int[256];
            for (char c : s.toCharArray()) {
                count[c]++;
            }
            int target = n / 4;
            int ret = s.length();
            //lo ~ hi 之间的窗口是替换子串
            for (int lo = 0, hi = 0; hi < s.length(); hi++) {
                count[s.charAt(hi)]--;
                //查看窗口之外的情况:即不替换的部分是否满足情况
                while (lo < s.length() && count['Q'] <= target && count['W'] <= target && count['E'] <= target && count['R'] <= target) {
                    ret = Math.min(ret, hi - lo + 1);
                    count[s.charAt(lo)]++;
                    lo++;
                }
            }
            return ret;
        }
    }
}
