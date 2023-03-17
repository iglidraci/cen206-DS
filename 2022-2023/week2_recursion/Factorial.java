public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(factTR(5));
    }
    static long fact(int n) {
        if (n == 0) return 1;
        return n * fact(n-1);
    }

    static long factTR(int n) {
        return factTR(n, 1);
    }

    static long factTR(int n, long accumulator) {
        if (n == 0) return accumulator;
        return factTR(n-1, n * accumulator);
    }
}
