package Stack.SplitBalancedString1221;

import java.util.Stack;

/**
 * 思路：
 * 栈
 * 如果栈位null入栈
 * 如果栈不为null，判断字符是否和栈中字符相同，相同入栈，不同出栈
 * 之后看栈是否为null，为null的话count++
 */
public class UseStack {
    public static void main(String[] args) {
        String s="RLLLLRRRLR";
        useStack(s);
    }

    private static int useStack(String s) {
        Stack<Character> stack = new Stack<Character>();
        int count=0;
        for (int i=0;i<s.length();i++){
            if (stack.empty()||s.charAt(i)==stack.peek())stack.push(s.charAt(i));
            else stack.pop();
            if (stack.empty())count++;
        }
        return count;
    }
}
