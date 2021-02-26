package Array.ValidPalindrome125;

/**
 * 思路：
 * 现将字符串进行格式化：小写转大写，只保留数字字母
 * 之后将字符串反转，比较原字符串和反转后的
 */
public class Brute {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();
        return sb.toString().equals(reverse.toString());

    }
}
