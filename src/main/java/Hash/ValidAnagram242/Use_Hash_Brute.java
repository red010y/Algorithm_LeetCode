package Hash.ValidAnagram242;

import java.util.HashMap;

/**
 * 思路：
 * 将字符串转换为字符数组
 * 存储每个字符的次数在map中
 * 对比map中的数是否相同
 */
public class Use_Hash_Brute {

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();

        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();

        for (char c:s_chars){
            if (s_map.containsKey(c)) {
                s_map.put(c, s_map.get(c) + 1);
            }else {
                s_map.put(c, 1);
            }
        }

        for (char c:t_chars){
            if (t_map.containsKey(c)) {
                t_map.put(c, t_map.get(c) + 1);
            }else {
                t_map.put(c, 1);
            }
        }

        if (s_map.size()!=t_map.size())return false;

        for (Character c:s_map.keySet()){
            if (!t_map.containsKey(c)||!s_map.get(c).equals(t_map.get(c)))return false;
        }
        return true;
    }

}
