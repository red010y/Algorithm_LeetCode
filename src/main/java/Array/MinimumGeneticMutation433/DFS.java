package Array.MinimumGeneticMutation433;

import java.util.HashSet;

/**
 * 思路：
 * 考虑到重复走没有意义，必须设置set，存储已经走过的字符串
 *
 * 重复性：
 * 当前start和字符串数组中的字符串进行比较是否差一个字符，并且之前set中没有存放
 *  之后用这个差一个字符的字符串作为start在和字符数组中的字符进行比较
 *
 * 如果当前的start和end一样就重新给min赋值
 * 遍历字符数组，当前字符串和字符数组中的字符只差一个字符，并且没在set中存在
 * 之后用这个差一个字符的字符串作为start在和字符数组中的字符进行比较
 */
public class DFS {

    int min=Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> visited = new HashSet<>();
        dfs(start,end,bank,visited,0);
        if (min==Integer.MAX_VALUE)return -1;
        return min;
    }

    private void dfs(String start, String end, String[] bank, HashSet<String> visited, int step) {
        if (start.equals(end)){
            min=Math.min(min,step);
            return;
        }
        for (String gene:bank){
            if (!visited.contains(gene)&&isOK(gene,start)){
                visited.add(gene);
                dfs(gene, end, bank, visited, step+1);
                visited.remove(gene);
            }
        }
    }

    private boolean isOK(String gene, String start) {
        int diff=0;
        for (int i=0;i<start.length();i++){
            char s_char = start.charAt(i);
            char g_char = gene.charAt(i);
            if (s_char!=g_char)diff++;
        }
        if (diff==1)return true;
        return false;
    }


    public static void main(String[] args) {
        DFS brute = new DFS();
        brute.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
    }

}
