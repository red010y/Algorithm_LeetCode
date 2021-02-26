package Hash.GroupAnagrams49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 思路：
 * 遍历字符串数组
 * 每次都创建一个26长度的数组，记录当前字符串的字符个数
 * 记录每个字符串字母+出现次数(a1b2)，如果能和map中的key对上的就是异位数，存在当前map的v中
 */
public class UseHeap_Count {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s:strs){
            int[] arr = new int[26];
            char[] chars = s.toCharArray();
            for (char c:chars){
                arr[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<arr.length;i++){
                if (arr[i]!=0) {
                   sb.append(i+'a');
                   sb.append(arr[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(s);
            map.put(sb.toString(),list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
