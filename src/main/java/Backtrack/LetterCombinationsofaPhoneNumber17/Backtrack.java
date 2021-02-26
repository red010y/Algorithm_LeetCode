package Backtrack.LetterCombinationsofaPhoneNumber17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Backtrack {
    /**
     * 思路：
     * map建立kv关系，k数字，vList存储字母
     * String转字符数组
     * 递归的往格子里放字母
     */
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.equals(""))return result;
        HashMap<Integer, List<Character>> map = new HashMap<>();
        int num=0;
        for (int i=2;i<= 9;i++){
            ArrayList<Character> list = new ArrayList<>();
            list.add((char) ('a'+num++));
            list.add((char) ('a'+num++));
            list.add((char) ('a'+num++));
            if (i==7||i==9)list.add((char) ('a'+num++));
            map.put(i,list);
        }
        char[] chars = digits.toCharArray();
        recursive(map,chars,result,0,"");
        return result;
    }

    private void recursive(HashMap<Integer, List<Character>> map, char[] chars, ArrayList<String> result, int lattice, String s) {
        if (lattice==chars.length){
            result.add(s);
            return;
        }
        int num = chars[lattice] -'0';
        List<Character> list = map.get(num);
        for (char c:list){
            recursive(map, chars, result, lattice+1, s+c);
        }
    }
}
