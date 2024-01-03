package ctci.arraystrings;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        System.out.println(stringPermutation.checkIfPalindrome("atrea", "arrae"));
    }

    // check if two strings are palindrome of each other
    public boolean checkIfPalindrome(final String s1, final String s2) {
        if (s1.length() != s2.length())
            return false;
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c: s1.toCharArray()) {
            charCount.computeIfPresent(c, (k, v) -> v + 1);
            charCount.putIfAbsent(c, 1);
        }
        for (char c: s2.toCharArray()) {
            if (!charCount.containsKey(c))
                return false;
            if (charCount.get(c) == 0) return false;
            charCount.computeIfPresent(c, (k,v) -> v-1);
        }
        return true;
    }
}
