package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        //System.out.println(sqrt.findSqrt(2147483647));
        // System.out.println(sqrt.findSqrtBinarySearch(2147395599));
        // System.out.println(sqrt.climbStairs(2));
        System.out.println(sqrt.majorityElement(new int[] {2,2,1,1,1,2,2}));
        //sqrt.getColumnExcel(716);
    }

    public int findSqrt(int x) {
        if (x == 1 || x == 0 ) return x;
        for (int i=1; i<=x/2 + 1; i ++) {
            System.out.println(i);
            if (i * i == x)
                return i;
            if (i * i > x)
                return i-1;
        }
        return -1;
    }

    public int findSqrtBinarySearch(int x) {
        int left = 0;
        int right = x;
        int result = 0;
        int mid = 0;
        while (left <= right) {
            mid = (left + right)/2;
            if (mid * mid == x)
                return mid;
            if (mid * mid < x) {
                result = mid;
                left = mid + 1;
            }
            if (mid * mid > x)
                right = mid - 1;
        }
        return result;
    }

    // https://leetcode.com/problems/single-number/
    public int findLonelyNUmber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        int sum = 0; int setSum = 0;
        for (Integer i: nums)
            sum += i;
        for (Integer i: set)
            setSum += 2 * i;
        return setSum - sum;
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int[] a = new int[n + 1];
        a[0] = 1; a[1] =1 ;
        IntStream.rangeClosed(2, a.length)
                .forEach(i -> a[i] = a[i - 1] + a[i - 2]);
        return a[n];
    }

    // Boyer-Moore majority Voting algo
    public int majorityElement(int[] arr) {
        int ctr = 0;
        int curr = arr[0];

        for (int i: arr) {
            if (ctr == 0) {
                curr = i;
                ctr = 1;
            }
            else if (curr == i)
                ctr +=1;
            else
                ctr -=1;
        }
        return curr;
    }

    public void getColumnExcel( int n) {
        StringBuilder sb = new StringBuilder();
        //System.out.println((char)(n - 1 + 'A'));
        int rem;
        while (n > 0) {
            n --;
            rem = n % 26;
            n = n /26;
            sb.insert(0, (char)(rem + 'A'));
        }
        System.out.println(sb.toString());
    }
}
