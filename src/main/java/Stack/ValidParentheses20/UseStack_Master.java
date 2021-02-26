package Stack.ValidParentheses20;

import java.util.ArrayDeque;

/**
 * 思路：
 * 如果是左括号入栈，但是入栈的是右括号
 * 如果是右括号，判断stack是否为null，不为null看是否和栈顶元素相同
 * 最后判断栈是否为null
 */
public class UseStack_Master {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

}
