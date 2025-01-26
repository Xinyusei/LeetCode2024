package Type_.滑动窗口与双指针.定长滑动窗口;

import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/">1456定长子串中元音的最大数目</a>
 */
public class a1456定长子串中元音的最大数目 {
    class Solution {
        public int maxVowels(String s, int k) {
            HashSet<Character> valid = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
            int ans = 0;
            for (int i = 0; i < k; i++) {
                if (valid.contains(s.charAt(i)))
                    ans++;
            }
            int window = ans;
            for (int lo = 0, hi = k; hi < s.length(); lo++, hi++) {
                if (valid.contains(s.charAt(hi))) window++;
                if (valid.contains(s.charAt(lo))) window--;
                ans = Math.max(ans, window);
            }
            return ans;
        }
    }
}
