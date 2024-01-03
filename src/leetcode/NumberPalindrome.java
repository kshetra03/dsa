package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class NumberPalindrome {

    public static void main(String[] args) {
        NumberPalindrome leetCode = new NumberPalindrome();
        // System.out.println(leetCode.numberPalindrome(2147483647));
        // leetCode.readNumberForward(12003);
        System.out.println(leetCode.compare(1000021));
    }

    /*
    Problem No: 9
    https://leetcode.com/problems/palindrome-number/
     */
    public boolean numberPalindrome(int x) {
        return x == reverse(x);
    }

    private boolean compare(int n) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new ArrayDeque<>();
        boolean ret;
        while(n >0) {
            s.push(n%10);
            q.add(n%10);
            n/=10;
        }

        while (!s.isEmpty()) {
            Integer pop = s.pop();
            Integer poll = q.poll();
            if (!pop.equals(poll))
                return false;
        }
        return true;
    }

    private void readNumberForward(int n) {
        Queue<Integer> s = new ArrayDeque<>();
        while (n > 0) {
            s.add(n % 10);
            n /= 10;
        }
        while (!s.isEmpty()) {
            System.out.println(s.poll());
        }
    }
    private int getNumberOfZeros(int n) {
        int ctr =0;
        while(n > 9) {
            n /= 10;
            ctr++;
        }
        return ctr;
    }

    private int reverse(int n) {
        int rev = 0;
        while(n>0) {
            int temp = n % 10;
            n /= 10;
            rev = rev * 10 + temp;

        }
        return rev;
    }

}
