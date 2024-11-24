package 周赛.w425;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2024/11/24
 * @Description:
 */
public class a100445重排子字符串以形成目标字符串 {
    class Solution {
        public boolean isPossibleToRearrange(String s, String t, int k) {
            Map<String, Integer> record = new HashMap<>();
            int n = s.length(), d = n / k;
            for (int i = 0; i < n; i += d) {
                String sub = s.substring(i, i + d);
                record.put(sub, record.getOrDefault(sub, 0) + 1);
            }
            //System.out.println(record);
            for (int i = 0; i < n; i += d) {
                String sub = t.substring(i, i + d);
                if (!record.containsKey(sub) || record.get(sub) == 0)
                    return false;
                record.put(sub, record.get(sub) - 1);
            }
            //System.out.println(record);
            return true;
        }
    }
}
