package Array.ValidPalindrome125;

public class Top_Down_ProgrammingIdeas {

    public boolean isPalindrome(String s) {
        String filterS=isLetterORDigit(s);
        String reversS=reverse(filterS);
        return filterS.equalsIgnoreCase(reversS);
    }

    private String reverse(String filterS) {
        StringBuilder sb = new StringBuilder(filterS);
        sb.reverse();
        return sb.toString();
    }

    private String isLetterORDigit(String s) {
        return s.replaceAll("[^0-9a-zA-Z]","");
    }

}

