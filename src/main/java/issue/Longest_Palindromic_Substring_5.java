package issue;

public class Longest_Palindromic_Substring_5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char mark='#';
        String convertS = "" + mark;
        for (int i = 0; i < s.length(); i++) {
            convertS+=s.charAt(i);
            convertS+=mark;
        }
        int maxLength = 0;
        String maxString="";
        for (int i = 0; i < convertS.length(); i++) {
            for (int j = 1; i - j >= 0 && i + j < convertS.length(); j++) {
                if (convertS.charAt(i - j) == convertS.charAt(i + j)) {
                    if (maxLength < j) {
                        maxLength = j;
                        maxString = convertS.substring(i - j, i + j + 1);
                    }
                } else {
                    break;
                }
            }
        }
        String result = "";
        for (int i = 0; i < maxString.length(); i++) {
            if (maxString.charAt(i) != '#') {
                result += maxString.charAt(i);
            }
        }
        return result;
    }

    public String longestPalindrome2(String s) {
        int start =0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int lenth1 = extendAroundCenter(s, i, i);
            int lenth2 = extendAroundCenter(s, i, i + 1);
            int lenth = Math.max(lenth1, lenth2);
            if (lenth > end - start + 1) {
                start = i - (lenth - 1) / 2;
                end = i + lenth / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int extendAroundCenter(String s, int L, int R) {
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        Longest_Palindromic_Substring_5 solution = new Longest_Palindromic_Substring_5();
        String s = "";
        String result = solution.longestPalindrome2(s);
        System.out.println(result);

    }
}
