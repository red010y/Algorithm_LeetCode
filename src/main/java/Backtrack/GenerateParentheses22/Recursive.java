package Backtrack.GenerateParentheses22;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路
 * 重复性，如何用左右括号
 * 括号合法条件：
 * 左括号随时可加，只要不超标
 * 右括号前面必须有左括号，左括号数>右括号
 * 递归的进行
 */
public class Recursive {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        recursive(n,0,0,"",res);
        return res;
    }

    private void recursive(int n, int l, int r, String s, ArrayList<String> res) {
        if (s.length()==2*n){
            res.add(s);
            return;
        }
        if (l<n)recursive(n,l+1,r,s+"(",res);
        if (l>r)recursive(n,l,r+1,s+")",res);
    }

}
