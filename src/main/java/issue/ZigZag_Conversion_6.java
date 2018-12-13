package issue;

import java.util.ArrayList;
import java.util.List;

public class ZigZag_Conversion_6 {
    public String convert(String s, int numRows) {
        String s2 = s;
        int T = 2 * numRows - 2;
        if (T == 0) {
            return s;
        }
        for (int m = 0; m < T - s.length() % T; m++) {
            s2  += ' ';
        }
        StringBuilder resultBuilder = new StringBuilder(s2);
        int r = numRows;
        int n = s2.length() / T;
        for (int p = 0; p < s2.length(); p++) {
            int i = p / T + 1;
            int j = p % T + 1;
            int loc = getLocation(i, j, r, n) - 1;
            resultBuilder.setCharAt(loc, s2.charAt(p));
        }
        String result = "";
        for (int q = 0; q < resultBuilder.length(); q++) {
            if (resultBuilder.charAt(q) != ' ') {
                result += resultBuilder.charAt(q);
            }
        }
        return result;
    }

    private int getLocation(int i, int j, int r, int n) {
        if (j == 1) {
            return i;
        } else if (j > 1 && j < r) {
            return (j - 2) * 2 * n + n + 2 *(i - 1) + 1;
        } else if (j == r) {
            return (j - 2) * 2 * n + n + i;
        } else if (j > r && j <= 2* r - 2) {
            return (2 * r - 2 - j) * 2 * n + n + 2 * i;
        } else {
            // WRONG
            return -1;
        }
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1) return s;
        List<String> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add("");
        }
        int rowCount = 0;
        boolean goingDown = true;
        for (int i = 0; i < s.length(); i++) {
            String currentStr = rows.get(rowCount);
            currentStr +=s.charAt(i);
            rows.set(rowCount, currentStr);
            int move = goingDown ? 1 : -1;
            rowCount += move;
            if (rowCount == 0 || rowCount == numRows - 1) {
                goingDown = !goingDown;
            }
        }
        String result = "";
        for (int j = 0; j < numRows; j++) {
            result += rows.get(j);
        }
        return result;
    }

    public static void main(String[] args) {
        ZigZag_Conversion_6 solution = new ZigZag_Conversion_6();
        String s = "PAYPALISHIRING";
        int r = 4;
        String result = solution.convert2(s, r);
        System.out.println(result);
    }
}
