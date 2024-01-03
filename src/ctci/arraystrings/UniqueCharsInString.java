package ctci.arraystrings;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharsInString {
    public static void main(String[] args) {
        UniqueCharsInString uniqueCharsInString = new UniqueCharsInString();
        System.out.println(uniqueCharsInString.checkUniqueCharsInString("abcre"));
        System.out.println(uniqueCharsInString.checkUniqueCharInString_Array("abcrea"));

    }

    public boolean checkUniqueCharsInString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()) {
            if (map.containsKey(c)) {
                return false;
            }
            map.put(c, 1);
        }
        return true;
    }

    public boolean checkUniqueCharInString_Array(String str) {
        boolean []chars = new boolean[256];
        for (char c: str.toCharArray()) {
            if (chars[c]) {
                return false;
            }
            chars[c] = true;
        }
        return true;
    }
}
