package Type_.滑动窗口与双指针.不定长滑动窗口.不定长_求最大or最长;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 * https://leetcode.cn/problems/fruit-into-baskets/description/
 */
public class a904水果成篮 {
    class Solution {
        public int totalFruit(int[] fruits) {
            Map<Integer, Integer> window = new HashMap<>();
            int ret = 0;
            for (int lo = 0, hi = 0; hi < fruits.length; hi++) {
                int type = fruits[hi];
                window.put(type, window.getOrDefault(type, 0) + 1);
                if (window.size() <= 2) {
                    ret = Math.max(ret,hi - lo + 1);
                }
                while (lo < fruits.length && window.size() > 2) {
                    int rm = fruits[lo++];
                    if (window.get(rm) == 1)
                        window.remove(rm);
                    else
                        window.put(rm, window.get(rm) - 1);
                }
            }
            return ret;
        }
    }
}
