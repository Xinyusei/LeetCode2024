package Type_.设计;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/11/21
 * @Description:
 */
public class a155最小栈 {
    class MinStack {

        private final List<Integer> minStack;  //阶段性的记录当前栈中最小的元素

        private final List<Integer> realStack; //realStack是真实的栈

        public MinStack() {
            minStack = new LinkedList<>();
            realStack = new LinkedList<>();

        }


        public void push(int val) {
            realStack.addFirst(val);

            //minStack为空或者minStack的栈顶(即此时的最小元素比要插入的元素还小)
            if (minStack.isEmpty() || val <= minStack.getFirst()) {
                //将minStack的栈顶设当要插入的元素值(即此时的最小元素就是要插入的元素)
                minStack.addFirst(val);
            } else
                //插入的这个元素比较大
                minStack.addFirst(minStack.getFirst());


            /*System.out.println("minStack = " + minStack);
            System.out.println("realStack = " + realStack);*/

        }

        public void pop() {
            realStack.removeFirst();
            minStack.removeFirst();

            /*System.out.println("minStack = " + minStack);
            System.out.println("realStack = " + realStack);*/
        }

        public int top() {
            return realStack.getFirst();
        }

        public int getMin() {
            return minStack.getFirst();
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
