package Backtrack.GenerateParentheses22;

import java.util.List;

/**
 * 递归演示
 * 需求：n个位置，所有的左右括号的组合
 */
public class RecursiveDemo {
    public List<String> generateParenthesis(int n) {
        //当前层,总层数，字符串
        recur(0,2*n,"");
        return null;
    }
    public void recur(int level, int max, String s){
        //Terminator
        if (level>=max){
            System.out.println(s);
            return;
        }
        //process current logic
        String s1=s+"(";
        String s2=s+")";
        //drill down
        recur(level+1,max,s1);
        recur(level+1,max,s2);
        //restore current store
    }

    public static void main(String[] args) {
        new RecursiveDemo().generateParenthesis(3);
    }
}
