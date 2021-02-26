package DivideConquer.WordLadder127;

import java.util.*;


public class BFS {
    public static void main(String[] args) {
        BFS bfs = new BFS();
        String[] arr={"hot","dot","dog","lot","log","cog"};

        bfs.ladderLength("hit","cog",Arrays.asList(arr));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step=1;
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
//        HashSet<String> words = new HashSet<>();
//        words.addAll(wordList);
        HashSet<String> words = new HashSet<>(wordList);
        char[] letters=new char[26];
        for (int i=0;i<26;i++){
            letters[i]= (char) ('a'+i);
        }
        HashSet<String> visited = new HashSet<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                String poll = queue.poll();
                char[] poll_char = poll.toCharArray();
                for (int i=0;i<poll_char.length;i++) {
                    for (char letter : letters) {
                        char old = poll_char[i];
                        poll_char[i]=letter;
                        String new_char = new String(poll_char);
                        if (!visited.contains(new_char)&&words.contains(new_char)){
                            queue.offer(new_char);
                            visited.add(new_char);
                            if (new_char.equals(endWord))return step+1;
                        }
                        poll_char[i]=old;
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int step=1;
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        HashSet<String> dict = new HashSet<>(wordList);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                String poll = queue.poll();
                char[] chars_poll = poll.toCharArray();
                for (int i=0;i<chars_poll.length;i++){
                    for (char c='a';c<='z';c++){
                        char old = chars_poll[i];
                        chars_poll[i]=c;
                        String new_chars = new String(chars_poll);
                        if (dict.contains(new_chars)){
                            dict.remove(new_chars);
                            queue.offer(new_chars);
                            if (new_chars.equals(endWord))return step+1;
                        }
                        chars_poll[i]=old;
                    }
                }
            }
            step++;
        }
        return 0;
    }


    /**
     * 思路：
     * 首先判断在字典中有没有end，没有返回0
     * 创建一个set（reached）专门存放在字典中移除的字符串
     * 判断reached是否包含ednword
     * 只要不包含就创建一个新的set（toAdd），记录每次改变后在字典中存在的字符串
     * 遍历reached
     * 之后改变begin中的每个字符，判断在字典中有没有，如果有，toAdd中加入，字典中移除。
     * 遍历完所有的reached后，count++
     * toAdd中没有长度，说明字典中没有这个单词，没法到达（万一有两种选择的路呢？）哪set的长度就是2，赋值给reached就是2个单词，替换前面的reached中的值
     * 把set赋值给reached
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> reached = new HashSet<>();
        HashSet<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord))return 0;

        reached.add(beginWord);
        int count=1;
        while (!reached.contains(endWord)){
            HashSet<String> toAdd = new HashSet<>();
            for (String s:reached){
                for (int i=0;i<s.length();i++){
                    char[] chars = s.toCharArray();
                    for (char c='a';c<='z';c++){
                        chars[i]=c;
                        String word = new String(chars);
                        if (wordDict.contains(word)){
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            count++;
            if (toAdd.size()==0)return 0;
            reached=toAdd;
        }
        return count;
    }
}
