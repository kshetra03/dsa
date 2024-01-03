package leetcode;

public class Powxn {
    public static void main(String[] args) {
        Powxn powxn = new Powxn();
        System.out.println(powxn.myPow(0.00001, 2147483647));
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n > 0)
            return x * (myPow(x, n - 1));
        return (myPow(x, n + 1))/x;
    }
}
