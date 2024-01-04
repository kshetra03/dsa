package ctci.arraystrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class UniqueCharsInString {
    public static void main(String[] args) {
        UniqueCharsInString uniqueCharsInString = new UniqueCharsInString();
        // System.out.println(uniqueCharsInString.checkUniqueCharsInString("abcre"));
        // System.out.println(uniqueCharsInString.checkUniqueCharInString_Array("abcrea"));
        UniqueCharsInString.sortWithIndices(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5});
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

    public static int[] sortWithIndices(int[] arr) {
        Integer[] indices = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt(i -> arr[i]));

        int[] sortedIndices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedIndices[i] = indices[i];
        }
        for (int i: sortedIndices)
            System.out.print(i + " - ");
        return sortedIndices;
    }
}
