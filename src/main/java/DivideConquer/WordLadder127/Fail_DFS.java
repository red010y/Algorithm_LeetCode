package DivideConquer.WordLadder127;

import java.util.HashSet;
import java.util.List;

/**
 * 思路：
 *
 * 错误原因：
 * "qa"
 * "sq"
 * ["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
 * 超时
 * 递归栈太多
 *
 */
public class Fail_DFS {
    int min=Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        dfs(beginWord,endWord,wordList,1,visited);
        if (min==Integer.MAX_VALUE)return 0;
        return min;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, int step, HashSet<String> visited) {
        if (beginWord.equals(endWord)){
            min=Math.min(step,min);
            return;
        }
        for (String word:wordList){
            if (!visited.contains(word)&&isOK(beginWord,word)){
                visited.add(word);
                dfs(word, endWord, wordList, step+1, visited);
                visited.remove(word);
            }
        }
    }

    private boolean isOK(String beginWord, String word) {
        int diff=0;
        for (int i=0;i<beginWord.length();i++){
            char char_b = beginWord.charAt(i);
            char char_w = word.charAt(i);
            if (char_b!=char_w)diff++;
        }
        if (diff==1)return true;
        return false;
    }
}
