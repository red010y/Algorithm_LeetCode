package Stack.ReverseOnlyLetters917;

import java.util.Stack;

/**
 * 思路：
 * 使用栈，把字母放入栈中
 * 全部放完后在从栈中取，替换掉原来位置上的元素
 */
public class Use_Stack {
    public static void main(String[] args) {
        String letter="ab-cd";
        useStack(letter);
    }

    private static String useStack(String letter) {
        char[] chars = letter.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i=0;i<chars.length;i++){
            if (Character.isLetter(chars[i])){
                stack.push(chars[i]);
            }
        }
        for (int i=0;i<chars.length;i++){
            if (Character.isLetter(chars[i])){
                chars[i]=stack.pop();
            }
        }
        return new String(chars);
    }
}
