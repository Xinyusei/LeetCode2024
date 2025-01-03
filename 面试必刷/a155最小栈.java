package 面试必刷;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/12/31
 * @Description:
 */
public class a155最小栈 {
    class S1 {
        class MinStack {
            //存放当前存在的元素中的最小元素
            List<Integer> minStack;
            //普通的栈
            List<Integer> realStack;

            //real -2 0
            //min  -2 -2
            public MinStack() {
                //存放当前存在的元素中的最小元素
                this.minStack = new ArrayList<>();
                //普通的栈
                this.realStack = new ArrayList<>();
            }


            public void push(int val) {
                realStack.addLast(val);
                if (minStack.isEmpty() || minStack.getLast() >= val)
                    minStack.addLast(val);
                else
                    minStack.addLast(minStack.getLast());
            }

            public void pop() {
                realStack.removeLast();
                minStack.removeLast();
            }

            public int top() {
                return realStack.getLast();
            }

            public int getMin() {
                return minStack.getLast();
            }
        }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
    }
}
