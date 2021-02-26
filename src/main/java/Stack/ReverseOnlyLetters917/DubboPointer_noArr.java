package Stack.ReverseOnlyLetters917;

/**
 * 思路：
 * 双指针
 * 首先将字符串转换为字节数组
 * 一个指向头，一个指向尾，循环直到两个指针相遇
 * 如果头指针和尾指针都是字母就进行互换
 *
 */
public class DubboPointer_noArr {
    public static void main(String[] args) {
        String letter="ab-cd";
//        char[] chars = letter.toCharArray();
        reverseOnlyLetters(letter);
    }

    private static String reverseOnlyLetters(String letter) {
        StringBuilder sb = new StringBuilder(letter);
        int end=letter.length()-1;
        for (int start=0;start<end;start++){
            if (Character.isLetter(letter.charAt(start))){
                while(!Character.isLetter(letter.charAt(end)))end--;
                sb.setCharAt(start,letter.charAt(end));
                sb.setCharAt(end--,letter.charAt(start));
            }
        }
        return sb.toString();
    }

      //使用isLetter
/*    private static String reverseOnlyLetters(char[] chars) {
        int end=chars.length-1;
        for (int start=0;start<end;start++){
            if (Character.isLetter(chars[start])){
                while (!Character.isLetter(chars[end])){
                    end--;
                }
                char tmp = chars[start];
                chars[start]=chars[end];
                chars[end]=tmp;
                end--;
            }
        }
        return new String(chars);
    }*/

    //未使用isLetter，时间复杂度更优
/*    private static String reverseOnlyLetters(char[] chars) {
        int end=chars.length-1;
        for (int start=0;start<end;start++){
            if ((chars[start]>=97&&chars[start]<=122)||(chars[start]>=65&&chars[start]<=90)){
                while (!((chars[end]>=97&&chars[end]<=122)||(chars[end]>=65&&chars[end]<=90))){
                    end--;
                }
                char tmp=chars[start];
                chars[start]=chars[end];
                chars[end]=tmp;
                end--;
            }
        }
        return new String(chars);
    }*/
}
