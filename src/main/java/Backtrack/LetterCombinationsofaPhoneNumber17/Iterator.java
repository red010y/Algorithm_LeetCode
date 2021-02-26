package Backtrack.LetterCombinationsofaPhoneNumber17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


/**
 * 思路：
 * map建立kv关系，k数字，vList存储字母
 * String转字符数组
 * queue存储所有组合
 * 每次组合一个格子，之后在这个格子的基础上加入新的字符
 * a
 * b
 * c
 * ad
 * ae
 * af
 * bd...
 */
public class Iterator {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<String>();
        if(digits.isEmpty()) return queue;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.offer("");
        for(int i =0; i<digits.length();i++){
//            int x = Character.getNumericValue(digits.charAt(i));
            int num = digits.charAt(i)-'0';
            while(queue.peek().length()==i){
                String s = queue.poll();
                for(char c : mapping[num].toCharArray())
                    queue.offer(s+c);
            }
        }
        return queue;
    }



    public List<String> letterCombinations2(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits.equals(""))return queue;
        queue.offer("");
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
        for (int i=0;i<chars.length;i++){
            int size = queue.size();
            List<Character> list = map.get(chars[i]-'0');
            for (int j=0;j<size;j++){
                String poll = queue.poll();
                for (char c:list){
                    queue.offer(poll+c);
                }
            }
        }
        return queue;
    }
}
