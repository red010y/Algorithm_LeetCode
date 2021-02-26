package Array.MinimumGeneticMutation433;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 思路：
 * 将起始和目标转换为字符数组，逐个进行比较
 * 最后比较目标是否存在基因库，存在就返回count，不存在-1
 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
 * <p>
 * 以上的思路，没有读懂题
 * 这个题要求每一次的基因变化都在基因库中
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 1           2           3
 * <p>
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 1                       2
 * <p>
 * 哪现在问题来了，我怎么知道每次应该先变那个呢？
 * 中间变了怎么办？中间变了到半中间不行了怎么回溯？只要不等就循环，只要不在基因库中就return
 */

//"AACCTTGG"
//"AATTCCGG"
//["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]

//"AACCGGTT"
//"AACCGGTA"
//["AACCGGTA"]

/**
 * 思路:
 * 所有的基因存储到set中，用于后面进行判断，替换后的字符串是否合法
 * 4个基因存储成字节数组，用于后面进行替换字符
 * bfs：
 * 从start开始，记录所有的字符都被替换一次后，那些合法
 * 如果替换后就是end直接返回
 * 不是就从替换的下一批中继续找
 *
 */

public class BFS {
    public static void main(String[] args) {
        BFS brute = new BFS();
        brute.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
    }

    public int minMutation(String start, String end, String[] bank) {
        int step = 0;
        HashSet<String> banks = new HashSet<>();
        banks.addAll(Arrays.asList(bank));
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        char[] genes = {'A', 'C', 'G', 'T'};
        HashSet<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                visited.add(poll);
                char[] poll_char = poll.toCharArray();
                for (char c : genes) {
                    for (int j = 0; j < poll_char.length; j++) {
                        char old = poll_char[j];
                        poll_char[j] = c;
                        String new_poll = new String(poll_char);
                        if (!visited.contains(new_poll) && banks.contains(new_poll)) {
                            queue.add(new_poll);
                            if (new_poll.equals(end)) return step + 1;
                        }
                        poll_char[j] = old;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
/*    public int minMutation(String start, String end, String[] bank) {
        char[] start_chars = start.toCharArray();
        char[] end_chars = end.toCharArray();
        boolean mark=false;
        int count=0;
        for (int i=0;i<8;i++){
            if (start_chars[i]!=end_chars[i]){
                count++;
            }
        }
        for (int i=0;i<bank.length;i++){
            if (bank[i].equals(end))mark=true;
        }
        return mark?count:-1;
    }*/



