package Ev2024.Ev2024_10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZJX
 * @Date: 2024/10/23
 * @Description:
 */
public class a3185构成整天的下标对数目II {
    class Solution {
        public long countCompleteDayPairs(int[] s) {
//            从 s 中 找寻 一对下标(i,j) (i + j)  % 24 == 0 且 i < j
            HashMap<Integer, Long> record = new HashMap<>();
            //12,36,60 30,18,42 0,0,
            long ret = 0L;
            for (int h : s) {
                int v = h % 24;
                if (v == 0) {
                    ret += record.getOrDefault(0, 0L);
                } else {
                    ret += record.getOrDefault(24 - v, 0L);
                }
                record.put(v, record.getOrDefault(v, 0L) + 1);
            }
            return ret;
        }
    }

    //优化：
    class Solution2 {
        public long countCompleteDayPairs(int[] s) {
//            从 s 中 找寻 一对下标(i,j) (i + j)  % 24 == 0 且 i < j
            int H = 24;
            int[] record = new int[H];
            //12,36,60 30,18,42 0,0,
            long ret = 0L;
            for (int h : s) {
                int v = h % 24;
                if (v == 0) {
                    ret += record[v];
                } else {
                    ret += record[24 - v];
                }
                record[v]++;
            }
            return ret;
        }
    }
}
