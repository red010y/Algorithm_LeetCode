package DivideConquer.WordLadder126;

import java.util.*;

/**
 * 思路：
 * 用bfs：存储当前单词到start的距离（经过几次变换），当前单词可变形的邻居单词
 * 用dfs：根据距离和可变形单词组装结果集
 */
public class BFSDFS {
    public static void main(String[] args) {

/**
 * "red"
 * "tax"
 * ["ted","tex","red","tax","tad","den","rex","pee"]
 * 输出：
 * [["red","ted","tad","tax"],["red","ted","tex","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"],["red","rex","tex","tax"]]
 * 预期：
 * [["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
 *
 * rex ted都会产生neighbor tex，造成有两个tex
 */

        String start = "red";
        String end = "tax";
        String[] bank = {"ted", "tex", "red", "tax", "tad", "den", "rex", "pee"};
        new BFSDFS().findLadders(start, end, Arrays.asList(bank));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);
        HashMap<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 0);
        HashMap<String, List<String>> neighbor = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<List<String>> result = new ArrayList<>();
        bfs(beginWord, endWord, dict, distance, neighbor);
        dfs(beginWord, endWord, distance, neighbor, list, result);
        return result;
    }

    private void dfs(String beginWord, String endWord, HashMap<String, Integer> distance, HashMap<String, List<String>> neighbor, ArrayList<String> list, ArrayList<List<String>> result) {
        list.add(beginWord);
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(list));
        } else {
            for (String n : neighbor.get(beginWord)) {
                //neighbor的距离不都是当前节点的距离+1么？
                if (distance.get(n) == distance.get(beginWord) + 1) {
                    dfs(n, endWord, distance, neighbor, list, result);
                }
            }
        }
        list.remove(list.size() - 1);
    }

    private void bfs(String beginWord, String endWord, HashSet<String> dict, HashMap<String, Integer> distance, HashMap<String, List<String>> neighbor) {
        for (String s : dict) {
            neighbor.put(s, new ArrayList<>());
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        boolean find = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String poll = queue.poll();
                Integer curDistance = distance.get(poll);
                ArrayList<String> neighbors = getNeighbor(poll, dict);
                for (String n : neighbors) {
                    neighbor.get(poll).add(n);
                    if (!distance.containsKey(n)) {
                        distance.put(n, curDistance + 1);
                        if (n.equals(endWord)) {
                            find = true;
                        } else {
                            queue.offer(n);
                        }
                    }
                }
            }
            if (find) return;
        }
    }

    private ArrayList<String> getNeighbor(String poll, HashSet<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        char[] poll_chars = poll.toCharArray();
        for (int i = 0; i < poll_chars.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (poll_chars[i] == c) continue;
                char old = poll_chars[i];
                poll_chars[i] = c;
                String new_poll = new String(poll_chars);
                if (dict.contains(new_poll)) {
                    result.add(new_poll);
                }
                poll_chars[i] = old;
            }
        }
        return result;
    }

}

