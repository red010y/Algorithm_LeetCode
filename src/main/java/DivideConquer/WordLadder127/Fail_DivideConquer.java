package DivideConquer.WordLadder127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 思路：
 * 每次改变一个字符，去字典中检查这个改变是否存在
 * 如果存在记录这个新单词，如果不存在，尝试改变其他单词
 *
 * 错误原因：
 * 读题的问题
 * 没有考虑，字符串变化和最终字符串字符不同的情况
 *  "hit" -> "hot" -> "dot"
 */
public class Fail_DivideConquer {
    public static void main(String[] args) {
        String beginWord="hit";
        String endWord="cog";
        String[] arr={"hot","dot","dog","lot","log","cog"};
        ArrayList<String> wordList=new ArrayList<String>(Arrays.asList(arr));
        int i = ladderLength(beginWord, endWord, wordList);
        System.out.println(i);

    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        char[] begin = beginWord.toCharArray();
        char[] end = endWord.toCharArray();
        int change=0;
        HashSet<String> set = new HashSet<>();
        for (String word:wordList)set.add(word);
        while (true) {
            if (new String(begin).equals(new String(end)))break;
            for (int i = 0; i < beginWord.length(); i++) {
                if (begin[i] != end[i]) {
                    if (i == begin.length - 1 && change == 0) return change;
                    char old = begin[i];
                    begin[i] = end[i];
                    if (!set.contains(new String(begin))) {
                        begin[i] = old;
                    } else {
                        change++;
                    }
                }
            }
        }
        return change+1;
    }
}
