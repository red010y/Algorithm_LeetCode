package Stack.MinStack155;

import java.util.Arrays;

/**
 * 思路：
 * 用数组实现stack
 * current指向的是还没有值的位置
 * push current下标不断移动。越界扩容
 * pop 出栈栈顶元素：current-1
 * top 获取栈顶元素：current-1
 * getMin 记录最小值，遍历整个数组
 */
public class UseArray {
    class MinStack {
        int[] arr;
        int current;
        /** initialize your data structure here. */
        public MinStack() {
            arr = new int[16];
            current=0;
        }

        public void push(int x) {
            if (current>=arr.length)grow(current);
            arr[current++]=x;
        }

        public void pop() {
            arr[--current]=0;
        }

        public int top() {
            return arr[current-1];
        }

        public int getMin() {
            int min=arr[0];
            for (int i=1;i<current;i++){
                if (arr[i]<min)min=arr[i];
            }
            return min;
        }
        private void grow(int minCapacity) {
            int oldCapacity = arr.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            arr = Arrays.copyOf(arr, newCapacity);
        }
    }
}
