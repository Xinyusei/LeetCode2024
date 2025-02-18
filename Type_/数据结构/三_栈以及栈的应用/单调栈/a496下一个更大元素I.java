package Type_.数据结构.三_栈以及栈的应用.单调栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: ZJX
 * @Date: 2025/02/17
 * @Description:
 */
public class a496下一个更大元素I {
    class S1 {
        class Solution {
            public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                HashMap<Integer, Integer> keyToNext = new HashMap<>();
                int m = nums1.length, n = nums2.length;
                Stack<Integer> s = new Stack<>();
                for (int i = n - 1; i >= 0; i--) {
                    int cur = nums2[i];
                    while (!s.isEmpty() && cur >= s.peek()) {
                        s.pop();
                    }
                    keyToNext.put(cur, s.isEmpty() ? -1 : s.peek());
                    s.push(cur);
                }
                int[] res = new int[m];
                for (int i = 0; i < m; i++) {
                    res[i] = keyToNext.get(nums1[i]);
                }
                return res;
            }
        }
    }
}
