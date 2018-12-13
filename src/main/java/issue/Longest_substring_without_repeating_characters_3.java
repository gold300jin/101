package issue;

import java.util.HashMap;
import java.util.Map;

public class Longest_substring_without_repeating_characters_3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mark = new HashMap<>();
        int maxLength = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int v = -1;
            if (mark.containsKey(c)) {
                v = mark.get(c);
            }
            mark.put(c, i);
            if (v <= start || v == -1) {
                int currentLength = i - start;
                maxLength = maxLength < currentLength ? currentLength : maxLength;
            } else {
                start = v;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s ="pwwkew";
        Longest_substring_without_repeating_characters_3 solution = new Longest_substring_without_repeating_characters_3();
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
