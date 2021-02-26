package Stack.MinStack155;

import java.util.ArrayDeque;


/**
 * 思路：
 * 用2个栈实现stack
 * 一个正常的出入栈normal_stack，另外一个存放最小值min_stack
 * push如果min_stack栈顶元素大于等于当前值，把当前值存入
 * pop如果正常出栈的值和min_stack栈顶元素值一样，min_stack进行出栈操作
 */
public class TwoStack {
    class MinStack {
        ArrayDeque<Integer> normal_stack;
        ArrayDeque<Integer> min_stack;
        /** initialize your data structure here. */
        public MinStack() {
            normal_stack=new ArrayDeque<>();
            min_stack=new ArrayDeque<>();
        }
        public void push(int x) {
            if (normal_stack.isEmpty())min_stack.push(x);
            else {
                if (min_stack.peek()>=x)min_stack.push(x);
            }
            normal_stack.push(x);
        }

        public void pop() {
//            不自动拆箱,peek()返回的是E,也就是我们给stack指定的泛型,要进行比较可以用equals（）
//            Integer pop = normal_stack.pop();
//            Integer min = min_stack.peek();

//            min.peek()获取的是地址值,不自动拆箱，没法和pop比较
//            if (pop==min.peek())min_stack.pop();
//            if (pop==min)min_stack.pop();
            int pop = normal_stack.pop();
            int min = min_stack.peek();
            if (pop==min)min_stack.pop();
        }

        public int top() {
            return normal_stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }
}
