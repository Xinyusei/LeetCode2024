package Type_.数据结构.三_栈以及栈的应用.单调栈;

import java.util.List;
import java.util.Stack;

/**
 * @Author: ZJX
 * @Date: 2025/02/17
 * @Description:
 */
public class 单调栈模版 {
    class S1 {
        int[] calculateGreaterElement(int[] nums) {
            int n = nums.length;
            // 存放答案的数组
            int[] res = new int[n];
            Stack<Integer> s = new Stack<>();
            //倒着往里面放
            for (int i = n - 1; i >= 0; i--) {
                // 判定个子高矮
                while (!s.isEmpty() && s.peek() <= nums[i]) {
                    // 矮个起开，反正也被挡着了。。。
                    s.pop();
                }
                // nums[i] 身后的更大元素
                res[i] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[i]);
            }
            return res;
        }
    }
}
