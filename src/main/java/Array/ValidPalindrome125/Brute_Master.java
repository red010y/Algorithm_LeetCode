package Array.ValidPalindrome125;

public class Brute_Master {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder reverse = new StringBuilder(str).reverse();
        return str.equals(reverse.toString());
    }
}
