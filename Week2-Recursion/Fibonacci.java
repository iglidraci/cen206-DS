public class Fibonacci {
	public static void main(String[] args) {
		int nr = Integer.valueOf(args[0]);
		System.out.println("Fibonacci of " + nr + " = " + goodFibonacci(nr));
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
}
