package issue;

public class palindrome_number {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int pre = x, after = 0;
        while(pre > 0) {
            after = after * 10 + pre % 10;
            pre /= 10;
        }
        return pre == after;
    }

    public static void main(String[] args) {
        palindrome_number solution = new palindrome_number();
        solution.isPalindrome(121);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
    }
}
