package Hash.ValidAnagram242;

import java.util.Arrays;

/**
 * 思路：
 * 简单过滤：看两个字符串长度是否一致
 * 转换成字符数组
 * 排序
 * 比较数组
 */
public class Sort {

    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1,t1);
    }

}
