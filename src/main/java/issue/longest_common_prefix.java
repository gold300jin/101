package issue;

public class longest_common_prefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        int p = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (flag) {
            for(int i = 0; i < strs.length - 1; i++) {
                if (p < strs[i].length() && p < strs[i+1].length() && strs[i].charAt(p) != strs[i+1].charAt(p)) {
                    flag = false;
                    break;
                }
                sb.append(strs[0].charAt(p));
            }
        }
        return sb.toString();
    }


}
