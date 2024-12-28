package 面试150;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: ZJX
 * @Date: 2024/12/28
 * @Description:
 */
public class a76最小覆盖子串 {
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length())
                return "";
            Map<Character, Integer> record = new HashMap<>();
            for (int i = 0; i < t.length(); i++)
                record.merge(t.charAt(i), 1, Integer::sum);
            String res = " " + s;
            //System.out.println("record : " + record);
            Map<Character, Integer> window = new HashMap<>();
            int startIdx = 0, len = Integer.MAX_VALUE;
            int valid = 0;
            char[] cs = s.toCharArray();
            for (int lo = 0, hi = 0; hi < cs.length; hi++) {
                char rightCH = cs[hi];
                if (record.containsKey(rightCH)) {
                    window.merge(rightCH, 1, Integer::sum);
                    //判断
                    if (record.get(rightCH).equals(window.get(rightCH)))
                        valid++;
                    while (valid == record.size()) {
                        //更新最小覆盖子串
                        if (hi - lo + 1 < len) {
                            startIdx = lo;
                            len = hi - lo + 1;
                        }
                        char rem = cs[lo];
                        if (record.containsKey(rem)) {
                            if (window.get(rem).equals(record.get(rem))) {
                                valid--;
                            }
                            window.merge(rem, -1, Integer::sum);
                        }
                        lo++;
                    }
                    //System.out.println("lo移动后,window : " + window);
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + len);
        }
    }
}
