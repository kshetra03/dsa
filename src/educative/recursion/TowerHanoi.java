package educative.recursion;

public class TowerHanoi {
    public static void main(String[] args) {
        moveTowers(2, 'A', 'B', 'C');
    }

    public static void moveTowers(int n, char src, char dest, char temp) {
        if (n == 1) {
            System.out.println(String.format("Moving disk %d from %s to %s", n, src, dest));
            return;
        }
        moveTowers(n - 1, src, temp, dest);
        System.out.println(String.format("Moving disk %d from %s to %s", n, src, dest));
        moveTowers(n - 1, temp, dest, src);
    }
}
