package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciTR(50));
        System.out.println(memoFibonacci(50));
    }

    static long badFibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return badFibonacci(n - 1) + badFibonacci(n-2);
    }

    static long memoFibonacci(int n) {
        long[] memo = new long[n + 1];
        memo[1] = 1;
        return memoFibonacci(n, memo);
    }
    private static long memoFibonacci(int n, long[] memo) {
        if (n == 0) return 0;
        if (memo[n] != 0) return memo[n];
        long result = memoFibonacci(n-1, memo) + memoFibonacci(n-2, memo);
        memo[n] = result;
        return result;
    }

    static long fibonacciTR(int n) {
        return fibonacciTR(n, 0, 1);
    }

    private static long fibonacciTR(int n, long a, long b) {
        if (n == 0) return a;
        else if (n == 1) return b;
        else return fibonacciTR(n - 1, b, a + b);
    }
}
