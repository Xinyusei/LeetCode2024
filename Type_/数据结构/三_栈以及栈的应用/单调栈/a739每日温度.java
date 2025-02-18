package Type_.数据结构.三_栈以及栈的应用.单调栈;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: ZJX
 * @Date: 2025/02/17
 * @Description:
 */
public class a739每日温度 {
    class S1 {
        class Solution {
            public int[] dailyTemperatures(int[] temperatures) {
                Stack<Integer> s = new Stack<>();
                int n = temperatures.length;
                int[] res = new int[n];
                for (int i = n - 1; i >= 0; i--) {
                    int cur = temperatures[i];
                    while (!s.isEmpty() && cur >= temperatures[s.peek()]) {
                        s.pop();
                    }
                    res[i] = s.isEmpty() ? 0 : s.peek() - i;
                    s.push(i);
                }
                return res;
            }
        }
    }
}
