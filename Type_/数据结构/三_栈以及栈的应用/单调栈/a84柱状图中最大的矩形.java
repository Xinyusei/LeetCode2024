package Type_.数据结构.三_栈以及栈的应用.单调栈;

import java.util.Stack;

/**
 * @Author: ZJX
 * @Date: 2025/02/17
 * @Description:
 */
public class a84柱状图中最大的矩形 {
    class S1 {
        class Solution {
            public int largestRectangleArea(int[] heights) {
                //单调递减的栈
                Stack<Integer> s = new Stack<>();
                int n = heights.length;
                int[] right = new int[n];
                for (int i = heights.length - 1; i >= 0; i--) {
                    int x = heights[i];
                    while (!s.isEmpty() && x <= heights[s.peek()])
                        s.pop();
                    right[i] = s.isEmpty() ? n : s.peek();
                    s.push(i);
                }
                s.clear();
                int[] left = new int[n];
                for (int i = 0; i < heights.length; i++) {
                    int x = heights[i];
                    while (!s.isEmpty() && x <= heights[s.peek()])
                        s.pop();
                    left[i] = s.isEmpty() ? -1 : s.peek();
                    s.push(i);
                }
                int ans = 0;
                for (int i = 0; i < n; i++) {
                    ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
                }
                return ans;
            }
        }
    }
}
