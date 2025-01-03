package 面试必刷;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/12/23
 * @Description:
 */
public class a14最长公共前缀 {

    /**
     * 纵向比较 - O(mn)
     */
    class S1 {
        class Solution {
            public String longestCommonPrefix(String[] ss) {
                String base = ss[0];
                for (int idx = 1; idx < ss.length; idx++) {
                    if (ss[idx].length() < base.length()) {
                        base = ss[idx];
                    }
                }
                int idx = 0;
                for (; idx < base.length(); idx++) {
                    char ch = base.charAt(idx);
                    for (String s : ss) {
                        if (s.charAt(idx) != ch)
                            return base.substring(0, idx);
                    }
                }
                return base.substring(0, idx);
            }
        }
    }

    /**
     * 排序 + 比较  0(mnlogm)
     */
    class S2 {
        class Solution {
            public String longestCommonPrefix(String[] ss) {
                Arrays.sort(ss);
                String sf = ss[0], sr = ss[ss.length - 1];
                int idx = 0;
                String ans = "";
                while (idx < sf.length() && idx < sr.length()) {
                    if (sf.charAt(idx) == sr.charAt(idx)){
                        ans += sf.charAt(idx);
                        idx++;
                    }
                    else
                        break;
                }
                return ans;
            }
        }
    }

}
