package Hash.GroupAnagrams49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 思路：
 * 给每个字母对应一个质数
 * 遍历字符串数组，每个字符串的字符对照质数数组
 * 把所有质数的乘积作为map的key（因为是质数可以保证不会出现不同位置乘起来结果一样）
 */
public class UseHeap_Prime {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, List<String>> map = new HashMap<>();
        //每个字母对应一个质数,26
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (String s:strs){
            long mapping=1;
            char[] chars = s.toCharArray();
            for (char c:chars){
                mapping*=prime[c-'a'];
            }
            List<String> list = map.getOrDefault(mapping, new ArrayList<String>());
            list.add(s);
            map.put(mapping,list);
        }
        return new ArrayList<>(map.values());
    }
}
