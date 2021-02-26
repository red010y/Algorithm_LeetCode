package Array.ValidPalindrome125;

/**
 * 思路：
 * 过滤出需要的字符
 * 头尾比较
 */
public class DubboPointer {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int l=0,r=sb.length()-1;
        while (r>l){
            if (sb.charAt(l++)!=sb.charAt(r--))return false;
        }
        return true;
    }

}
