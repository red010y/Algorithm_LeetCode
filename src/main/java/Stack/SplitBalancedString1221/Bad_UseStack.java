package Stack.SplitBalancedString1221;

import java.util.Stack;

/**
 * 思路：
 * 栈中存放LR，如果LR匹配并且栈为null
 * count++
 */
public class Bad_UseStack {
    public static void main(String[] args) {
        String s="RLLLLRRRLR";
        int i = useStack(s);
        System.out.println(i);
    }

    private static int useStack(String s) {
        Stack<Character> stack = new Stack<Character>();
        int count=0;
        for (int i=0;i<s.length();i++){
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            while (!stack.empty()){
                if (stack.peek()=='L'){
                    if (s.charAt(i)=='R'){
                        stack.pop();
                        break;
                    }else {
                        stack.push(s.charAt(i));
                        break;
                    }
                }else {
                    if (s.charAt(i)=='L'){
                        stack.pop();
                        break;
                    }else {
                        stack.push(s.charAt(i));
                        break;
                    }
                }
            }
            if (stack.empty()){
                count++;
            }
        }
        return count;
    }
}
