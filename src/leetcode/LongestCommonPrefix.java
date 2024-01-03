package leetcode;


import java.util.Arrays;

public class LongestCommonPrefix {

    /**
     * 14. Longest Common Prefix --
     * https://leetcode.com/problems/longest-common-prefix/description/
     */
    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        String[] str = new String[] {"flower","flow","flight"};
        String[] strs = new String[] {"ab", "a"};

        System.out.println(commonPrefix.longestCommonPrefix(str));
        System.out.println(commonPrefix.lcs_sorting(str));
    }

    // brute force
    public String longestCommonPrefix(String[] strs) {
        StringBuilder pre = new StringBuilder();
        for (int i=0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            boolean match = true;
            for (int j = 1; j < strs.length; j ++) {
                // not match
                if (strs[j].length() <= i || ch != strs[j].charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                pre.append(ch);
            } else {
                break;
            }
        }
        return pre.toString();
    }

    public String lcs_sorting(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        for (int i = 0; i< Math.min(first.length, last.length); i++) {
            if (first[i] == last[i])
                sb.append(first[i]);
            else
                break;
        }
        return sb.toString();
    }
}
