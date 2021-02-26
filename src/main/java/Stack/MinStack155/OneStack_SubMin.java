package Stack.MinStack155;

import java.util.ArrayDeque;

/**
 * 思路：
 * 用1个栈实现stack
 * 栈中存放peek=当前值x-min
 * 入栈的时候如果x是一个负数就更新min为v
 * 出栈的时候，如果是负数就用x(也就是现在的min)-v求出上一个min的值
 * top的时候需要注意：如果栈中元素小于0（最小值），返回min。否则返回peek+min
 *
 * 注意：为了防止超出int的范围我们这里最后都设置成long
 */
public class OneStack_SubMin {

    class MinStack {
        ArrayDeque<Long> stack;
        long min;
        /** initialize your data structure here. */
        public MinStack() {
            stack=new ArrayDeque<>();
        }

        public void push(int x) {
            if (stack.isEmpty()){
                min=x;
                stack.push(0L);
            }else {
                long peek = x - min;
                stack.push(peek);
                if (peek<0)min=x;
            }

        }

        public void pop() {
            if (stack.isEmpty()) return;
            if (stack.peek()<0)min=min-stack.pop();
            else stack.pop();
        }

        public int top() {
            Long peek = stack.peek();
            if (peek<0)return (int) min;
            else return (int) (peek+min);
        }

        public int getMin() {
            return (int)min;
        }
    }

}
