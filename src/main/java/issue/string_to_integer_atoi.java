package issue;

public class string_to_integer_atoi {
    public int myAtoi(String str) {
        boolean isStart = false, isNegative = false;
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isStart) {
                if (c == ' ') {
                    continue;
                } else if (c == '-') {
                    isNegative = true;
                    isStart = true;
                    continue;
                } else if (c - '0' >= 0 && c - '9' <= 0) {
                    isStart = true;
                } else {
                    return 0;
                }
            }
            if (isStart) {
                if (c - '0' >= 0 && c - '9' <= 0) {
                    int digit = c - '0';
                    if ((Integer.MAX_VALUE - digit) / 10 < number) {
                        return 0;
                    } else {
                        number = number * 10 + digit;
                    }
                } else {
                    break;
                }
            }
        }
        return isNegative ? -number: number;
    }
}
