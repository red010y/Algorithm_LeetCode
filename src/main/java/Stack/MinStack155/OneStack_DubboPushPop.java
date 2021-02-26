package Stack.MinStack155;

import java.util.ArrayDeque;

/**
 * 思路：
 * 栈中记录2个最小值
 * 入栈：如果入栈的当前值小于最小值min，先把min在入栈一次，之后更新min，之后在入栈当前值入栈。这样即使当前值出栈也可以找到之前的最小值min
 * 出栈：如果出栈的是最小值，就需要更新最小值：在进行一次出栈，更新min
 */
public class OneStack_DubboPushPop {
    class MinStack {
        ArrayDeque<Integer> stack;
        int min;
        /** initialize your data structure here. */
        public MinStack() {
            stack=new ArrayDeque<>();
        }

        public void push(int x) {
            if (stack.isEmpty()||x<=min){
                stack.push(min);
                min=x;
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.pop()==min)
                min=stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
