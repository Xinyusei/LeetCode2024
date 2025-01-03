package 面试必刷;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/25
 * @Description:
 */
public class a151反转字符串中的单词 {
    /**
     * 从前向后遍历
     */
    class S1 {
        class Solution {
            public String reverseWords(String s) {
                List<String> record = new ArrayList<>();
                int hi = 0, n = s.length();
                StringBuilder sb = new StringBuilder();
                while (hi < n) {
                    while (hi < n && s.charAt(hi) == ' ')
                        hi++;
                    int lo = hi;
                    while (hi < n && s.charAt(hi) != ' ')
                        hi++;
                    //the sky is blue
                    if (lo == hi)
                        break;
                    record.addLast(s.substring(lo, hi));
                }
                for (int i = record.size() - 1; i >= 0; i--) {
                    sb.append(record.get(i));
                    if (i != 0)
                        sb.append(' ');
                }
                return sb.toString();
            }
        }
    }

    /**
     * 从后往前遍历
     */
    class S2 {

        class Solution {
            public String reverseWords(String s) {
                int n = s.length(), lo = n - 1;
                StringBuilder sb = new StringBuilder();
                while (lo >= 0) {
                    while (lo >= 0 && s.charAt(lo) == ' ')
                        lo--;
                    int hi = lo + 1;
                    while (lo >= 0 && s.charAt(lo) != ' ')
                        lo--;
                    if (lo + 1 < 0 || lo + 1 == hi)
                        break;
                    sb.append(s, lo + 1, hi).append(' ');
                }
                return sb.deleteCharAt(sb.length() - 1).toString();
            }
        }
    }
}
