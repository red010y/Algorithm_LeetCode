package Stack.ValidParentheses20;

import java.util.ArrayDeque;
import java.util.HashMap;


/**
 * 思路：
 * map中存放括号
 * stack中存放左括号，遇到右括号就出栈
 * 如果最后stack==null说明是有效括号
 */
public class UseStack {

    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        char[] chars = s.toCharArray();
        for (char c:chars){
            if (map.containsValue(c))stack.push(c);
            else {
                if (map.get(c)==stack.peek())stack.pop();
                else return false;
            }
        }
        return stack.size()==0;
        //return stack.isEmpty();
    }
}
