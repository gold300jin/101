package issue;

public class Reverse_Integer_7 {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        int x2 = isNegative ? -x : x;
        int result = 0;
        do {
            if ((Integer.MAX_VALUE - x2 % 10) / 10 < result) {
                return 0;
            }
            result = result * 10 + x2 % 10;
        } while((x2 /= 10) > 0);
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        Reverse_Integer_7 solution = new Reverse_Integer_7();
        int result = solution.reverse(123);
        System.out.println(result);
    }
}
