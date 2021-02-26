package Hash.ValidAnagram242;
//异位词，长度一样，包含的字母都一样，每个字符出现的频率也一样，只是顺序不同而已

import java.util.HashMap;

/**
 * 思路：
 * 简单过滤：看两个字符串长度是否一致
 * map中存放26个字母，以及出现的次数
 * s中出现++，t中出现--
 * 最后看map中的每个key的value是否为0
 */
public class UseHash {

    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c='a';c<='z';c++)map.put(c,0);

        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
            map.put(t.charAt(i),map.get(t.charAt(i))-1);
        }

        for (int i:map.values())if (i!=0)return false;

        return true;
    }
}
