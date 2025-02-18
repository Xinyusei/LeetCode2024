package Type_.数据结构.三_栈以及栈的应用.单调栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: ZJX
 * @Date: 2025/02/18
 * @Description:
 */
public class a503下一个更大元素II {
    class S1 {
        class Solution {
            public int[] nextGreaterElements(int[] nums) {
                //[5,4,3,2,1,5,4,3,2,1]
                int n = nums.length;
                int[] res = new int[n];

                Stack<Integer> s = new Stack<>();
                // 数组长度加倍模拟环形数组
                for (int i = 2 * n - 1; i >= 0; i--) {
                    // 索引 i 要求模，其他的和模板一样
                    int x = nums[i % n];
                    while (!s.isEmpty() && x >= s.peek())
                        s.pop();

                    res[i % n] = !s.isEmpty() ? s.peek() : -1;
                    s.push(x);
                }
                return res;
            }
        }
    }
}
