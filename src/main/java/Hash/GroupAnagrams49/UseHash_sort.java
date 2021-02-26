package Hash.GroupAnagrams49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 思路：
 * 创建map和set
 * map中k是排序后的字符串，v是对应的List对象
 * 遍历字符串数组
 * 将字符串排序，判断是否在map中，在就在到对应的map的v中加入String。不在就创建List，并添加到map
 * 最后组装map中的所有v返回
 */
public class UseHash_sort {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sort_s = new String(chars);
            if (map.containsKey(sort_s)){
                List<String> list = map.get(sort_s);
                list.add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sort_s,list);
            }
        }
        for (List<String> list:map.values())result.add(list);
        return result;
    }

}
