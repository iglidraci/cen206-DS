package recursion;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(64, 'A', 'C', 'B');
    }

    static void hanoi(int n, char from, char to, char aux) {
        if (n == 0) return;
        if (n == 1) {
            System.out.println(from + " -> " + to);
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.println(from + " -> " + to);
        hanoi(n-1, aux, to, from);
    }
}
