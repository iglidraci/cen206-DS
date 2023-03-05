public class Fibonacci {
	public static void main(String[] args) {
		int nr = Integer.valueOf(args[0]);
		System.out.println("Fibonacci of " + nr + " = " + goodFibonacci(nr));
		System.out.println("Fibonacci of " + nr + " = " + fibTL(nr));
	}
	public static long badFibonacci(int nr) {
		if (nr == 0) return 0;
		else if (nr == 1) return 1;
		else return badFibonacci(nr-1) + badFibonacci(nr-2);
	}
	public static long goodFibonacci(int nr) {
		long[] memo = new long[nr + 1];
		memo[1] = 1;
		return fib(nr, memo);
	}
	private static long fib(int nr, long[] memo) {
		if (nr == 0) return 0;
		else if (nr == 1) return 1;
		if (memo[nr] != 0)
			return memo[nr];
		long result = fib(nr-1, memo) + fib(nr-2, memo);
		memo[nr] = result;
		return result;
	}
	public static long fibTL(int nr) {
		// tail-recursion optimization
		return fibTL(nr, 0, 1);
	}
	private static long fibTL (int nr, long a, long b) {
		if (nr == 0)
			return a;
		else if (nr == 1)
			return b;
		else return fibTL(nr-1, b, a+b);
	}
}
