package Stack.SplitBalancedString1221;

/**
 * 思路：
 * 遇到R，num++
 * 遇到L，num--
 * 如果num==0，count++
 */
public class Greedy {
    public static void main(String[] args) {
        String s="RLLLLRRRLR";
        greedy(s);
    }

    private static int greedy(String s) {
        int count=0;
        int num=0;
        for (char c:s.toCharArray()){
            num+=c=='R'?1:-1;
//            if (c=='R')num++;
//            else num--;
            if (num==0)count++;
        }
        return count;
    }
}
