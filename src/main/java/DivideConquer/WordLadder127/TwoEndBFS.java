package DivideConquer.WordLadder127;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 思路：
 * 核心思路：为了降低重复性，建立两端，用少的那端进行字符串匹配
 * 如果单词替换后在end端出现，直接返回
 */
public class TwoEndBFS {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String[] bank = {"hot","dot","dog","lot","log","cog"};
        new TwoEndBFS().ladderLength(start,end, Arrays.asList(bank));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        //必须得加这个条件！！！
        //"hit"
        //"cog"
        //["hot","dot","dog","lot","log"]本身是无法到达的，但是交换后，cog参与了变换
        if (!dict.contains(endWord))return 0;
        int count=1;
        begin.add(beginWord);
        end.add(endWord);
        while (!begin.isEmpty()&&!end.isEmpty()){
            HashSet<String> nextLevel = new HashSet<>();
            //交换两端，使得start始终是少的那端
            if (begin.size()>end.size()){
                HashSet<String> tmp=begin;
                begin=end;
                end=tmp;
            }

            for (String word:begin){
                char[] chars = word.toCharArray();
                for (int i=0;i<word.length();i++){
                    char old = chars[i];
                    for (char c='a';c<='z';c++){
                        chars[i]=c;
                        String s = String.valueOf(chars);
                        //begin包含，end也有，双向打通了，返回count+1
                        if (end.contains(s))return count+1;
                        if (dict.contains(s)){
                            nextLevel.add(s);
                            dict.remove(s);
                        }
                    }
                    chars[i]=old;
                }
            }
            count++;
            begin=nextLevel;
        }
        return 0;
    }
}
