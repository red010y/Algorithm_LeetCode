package Stack.ReverseOnlyLetters917;

/**
 * 思路：
 * 一个指针在前面start，一个指针在后面end
 * 添加一个StringBuilder存储最终我们要的string
 * start遇到了字母停下来等end也遇到字母，之后把end的字母放入到StringBuilder
 * 如果不是字母就直接加入到StringBulider中
 * 因为他们相遇后还会继续走，之前是把后面的换到了前面，再次交换的时候就是把前面的换到后面
 */
public class DoubboPointer_addArr {
    public static void main(String[] args) {
        String s="ab-cd";
        reverseOnlyLetters(s);
    }

    private static String reverseOnlyLetters(String s) {
        StringBuilder ans=new StringBuilder();
        int j=s.length()-1;
        for (int i=0;i<s.length();i++){
            if (Character.isLetter(s.charAt(i))){
                while (!Character.isLetter(s.charAt(j))){
                    j--;
                }
                ans.append(s.charAt(j--));
            }else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
