package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recursion {

    public static int powerOfTwo(final int power) {
        if(power == 0)
            return 1;
        return 2 * powerOfTwo(power - 1);
    }

    public static void printCounting(final int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");
        printCounting(n-1);
    }

    public static int fib(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int countDistinctWayToClimbStairs(final long nStairs) {
        if (nStairs < 0) { return 0; }
        if (nStairs == 0) { return 1; }
        return countDistinctWayToClimbStairs(nStairs - 1) + countDistinctWayToClimbStairs(nStairs - 2);
    }

    public static void sayDigits(int num) {
        final List<String> numStrings = Arrays.asList(
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        if (num == 0)
            return;

        int numToSay = num % 10;
        num /= 10;

        sayDigits(num);

        System.out.print(numStrings.get(numToSay) + "  ");
    }

    public static boolean isArraySorted_loop(final int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] < arr[i])
                return false;
        }
        return true;
    }

    public static boolean isArraySorted_recursive(final int[] arr, int start) {
        if (start == arr.length -1)
            return true;
        if (arr[start] > arr[start + 1])
            return false;
        else
            return isArraySorted_recursive(arr, start + 1);
    }

    public static boolean isArraySorted_recursive1(final int[] arr, int size) {
        if (size == 0 || size == 1)
            return true;
        if (arr[0] > arr[1])
            return false;
        else
            return isArraySorted_recursive1(
                    Arrays.stream(arr, 1, arr.length).toArray(),
                    size -1);
    }

    public static int sumOfArray(final int[] arr, int idx) {
        if (idx == arr.length - 1)
            return arr[idx];
        return arr[idx] + sumOfArray(arr, idx + 1);
    }

    public static int sumOfArray1(final int[] arr, int size) {
        if (size == 0) return 0;
        if (size == 1) return arr[0];

        return arr[0] + sumOfArray1(
                Arrays.stream(arr, 1, arr.length).toArray(),
                size - 1);
    }

    public static boolean linearSearch(final int[] arr, int size, int key) {
        if (size == 0)
            return false;
        if (key == arr[0])
            return true;
        else
            return linearSearch(
                    Arrays.stream(arr, 1, arr.length).toArray(),
                    size - 1,
                    key);
    }

    public static int binarySearch(final int[] arr, int key, int lo, int hi) {
        // Restrict the boundary of right index and the left index to prevent overflow of indices
        if (hi >= lo && lo <= arr.length - 1) {
            int mid = (lo + hi) / 2;
            if (key == arr[mid])
                return mid;
            if (key > arr[mid])
                return binarySearch(arr, key, mid + 1, hi);
            else
                return binarySearch(arr, key, lo, mid - 1);
        }
        return -1;
    }

    public static void stringReverse(final String str, int idx) {
        if (idx == str.length())
            return;
        stringReverse(str, idx + 1);
        char c = str.charAt(idx);

        System.out.print(c);
    }

    public static boolean isPalindrome_iterative(final String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome(final String str, int start, int end) {
        if (start == end)
            return true;
        if (str.charAt(start) != str.charAt(end))
            return false;
        else
            return isPalindrome(str, ++start, --end);
    }

    public static int power(final int base, final int pow) {
        if (pow == 0)
            return 1;
        else
            return base * power(base, pow - 1);
    }

    public static int fibMemo(int n) {
        if (n == 0 || n == 1)
            return n;

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i=2; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        while (n > 1) {
            if(n % 2 != 0) return false;
            else
                n /= 2;
        }
        return true;
    }

    public static boolean isPowerOf2(int n) {
        if (n <= 0) return false;
        return ((Math.log(n) / Math.log(2)) % 1 == 0);
    }

    public static boolean isPowerOf2BitWise(int n) {
        if (n <= 0) return false;
        return ((n & (n-1)) == 0);
    }

    private static Map<Character, Integer> frequencyCounter(final String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c: str.toCharArray()) {
            map.computeIfPresent(c, (k, v) -> v+1);
            map.putIfAbsent(c, 1);
        }
        return map;
    }


    public static void main(String[] args) {
        // System.out.println(powerOfTwo(3));
        // printCounting(10);
        // System.out.println(fib(8));
        // System.out.println(countDistinctWayToClimbStairs(4));
        // sayDigits(412);
        // System.out.println(isArraySorted_loop(new int[] {2,3,4,1,56,65}));
        // System.out.println(isArraySorted_recursive(new int[] {2,3,4,1,56,65}, 0));
        // System.out.println(isArraySorted_recursive1(new int[] {2,3, 4,56,65, 1}, 6));
        // System.out.println(sumOfArray(new int[] {1,2,3,4}, 0));
        // System.out.println(sumOfArray1(new int[] {1,2,3,4}, 4));
        // System.out.println(linearSearch(new int[] {2,4, 5, 7, 12, 8, 6}, 7, 1));
        // System.out.println(binarySearch(new int[] {2, 3, 5, 8, 9, 23, 34, 54, 56}, 51, 0, 9));
        // stringReverse("abc", 0);
        // System.out.println(isPalindrome_iterative("RACECAR"));
        // System.out.println(isPalindrome("RACECAR", 0, 6));
        // System.out.println(power(3, 4));
        // System.out.println(fibMemo(2));
        // System.out.println(isPowerOfTwo(16));
        // System.out.println(isPowerOf2(16));
        // System.out.println(isPowerOf2(536870912));
        // System.out.println(isPowerOf2BitWise(16));
        System.out.println(frequencyCounter("atach"));
    }
}
