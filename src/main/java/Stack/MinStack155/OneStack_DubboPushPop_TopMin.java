package Stack.MinStack155;

import java.util.ArrayDeque;
/**
 * 思路：
 * 入栈：先记录栈顶元素（之前的最小值）。再存放当前值，之后比较当前值和最小值，存放当前的最小值
 * 出栈：出2次
 * top：先出栈当前最小值，记录下来。之后获取栈顶元素，就是当前值。之后恢复栈（入栈最小值）
 * getMin:栈顶元素就是最小值
 */
public class OneStack_DubboPushPop_TopMin {
    class MinStack {
        ArrayDeque<Integer> stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack=new ArrayDeque<>();
        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(x);
                stack.push(x);
            }else {
                Integer min = stack.peek();
                stack.push(x);
                stack.push(min>x?x:min);
            }
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            Integer pop = stack.pop();
            Integer peek = stack.peek();
            stack.push(pop);
            return peek;
        }

        public int getMin() {
            return stack.peek();
        }
    }
}
