package Type_.动态规划.一入门DP.aa.最大子数组_子段和;

import java.util.HashMap;

/**
 * 2606. 找到最大开销的子字符串
 * https://leetcode.cn/problems/find-the-substring-with-maximum-cost/description/
 */
public class a2606找到最大开销的子字符串 {
    class Solution {
        public int maximumCostSubstring(String s, String chars, int[] vals) {
            HashMap<Character, Integer> valMap = new HashMap<>();
            for (int i = 0; i < chars.length(); i++) {
                valMap.putIfAbsent(chars.charAt(i), vals[i]);
            }
            int[] f = new int[s.length()];
            f[0] = valMap.getOrDefault(s.charAt(0), s.charAt(0) - 'a' + 1);
            int ans = Math.max(f[0], 0);
            for (int i = 1; i < s.length(); i++) {
                f[i] = valMap.getOrDefault(s.charAt(i), s.charAt(i) - 'a' + 1);
                if (f[i - 1] >= 0)
                    f[i] += f[i - 1];
                ans = Math.max(f[i], ans);
            }
            return ans;
        }
    }
}
