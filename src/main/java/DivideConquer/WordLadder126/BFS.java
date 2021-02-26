package DivideConquer.WordLadder126;

import java.util.*;

/**
 * 思路：
 * 整体和单词接龙i一致，不同之处在于：
 * 队列中存放集合
 * 设置一个subvisited
 * 每次出队，往队列中加入符合的node
 * 按批次出队，就能找到最后的结果集
 */
public class BFS {
    public static void main(String[] args) {
        String start = "red";
        String end = "tax";
        String[] bank = {"ted","tex","red","tax","tad","den","rex","pee"};
        //输出：
        //[["red","ted","tad","tax"],["red","ted","tex","tax"]]
        //预期结果：
        //[["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
        //TODO 会出现这个错误的主要原因是，tex从字典中移除，在单词接龙1中，我们认为tex就是下一层，可以去除
        //TODO 但是到了这里会少掉一种可能，结果2变为tex后，3就没法变为tex了

        new BFS().findLadders(start, end, Arrays.asList(bank));

    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ArrayList<List<String>> result = new ArrayList<>();
        ArrayDeque<List<String>> queue = new ArrayDeque<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.offer(list);
        boolean find=false;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))return result;
        while (!queue.isEmpty()){
            int size = queue.size();
            HashSet<String> subVisted = new HashSet<>();
            while (size-->0){
                List<String> poll = queue.poll();
                String s = poll.get(poll.size()-1);
                char[] chars_poll = s.toCharArray();
                for (int i=0;i<chars_poll.length;i++){
                    for (char c='a';c<='z';c++){
                        char old = chars_poll[i];
                        chars_poll[i]=c;
                        String new_chars = new String(chars_poll);
                        if (!visited.contains(new_chars)&&dict.contains(new_chars)){
                            if (new_chars.equals(endWord)){
                                poll.add(new_chars);
                                result.add(new ArrayList<>(poll));
                                poll.remove(new_chars);
                                find=true;
                            }
                            poll.add(new_chars);
                            //这不会出现ted tax 都能变成tex导致queue中有两个tex的情况么？不会！注意queue这里放的是List！！
                            queue.offer(new ArrayList<>(poll));
                            poll.remove(new_chars);
                            subVisted.add(new_chars);
                        }
                        chars_poll[i]=old;
                    }
                }
            }
            visited.addAll(subVisted);
            if(find)return result;
        }
        return result;
    }
}
