package Hash.ValidAnagram242;

/**
 * 思路：
 * 简单过滤：看两个字符串长度是否一致
 * 数组长度26，代表26个字母
 * 遍历s和t，s中的字母在数组上++，t中的字母--
 * 最后遍历数组，如果有不是0的就不为有效字母异位词
 */
public class UseArr {
    public boolean isAnagram(String s, String t) {

        if (s.length()!=t.length())return false;

        int[] arr=new int[26];

        for (char c:s.toCharArray()){
            arr[c-'a']++;
        }

        for (char c:t.toCharArray()){
            arr[c-'a']--;
        }

        for (int i:arr)if (i!=0)return false;

        return true;
    }
}
