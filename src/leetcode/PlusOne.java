package leetcode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(getPlusOne(new int[] {9,9,9,9}));
        System.out.println(getPlusOne(new int[] {9}));
        System.out.println(getPlusOne(new int[] {1,2,3,4,5,6,9}));
        System.out.println(getPlusOne(new int[] {1,2,3,}));
    }

    public static int[] getPlusOne(int[] digits) {
        int carry = 1;
        int idx = digits.length;
        int[] res = new int[idx + 1];

        for (int i = idx ; i >0; i--) {
            res[i] += (digits[i-1] + carry);
            if (res[i] / 10 == 1) {
                res[i] = 0;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (res[1] == 0)
            res[0] = 1;
        else
            // remove res[0]
            res = Arrays.copyOfRange(res, 1, res.length);
        return res;
    }
}
