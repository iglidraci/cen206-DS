public class Factorial {
	public static void main (String[] args) {
		System.out.printf("fact(%d)=%d\n", 10, fact(10));
		System.out.printf("fact(%d)=%d\n", 10, fact2(10));
	}
	public static long fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * fact(n-1);
	}
	public static long fact2(int n) {
		// tail-recursion optimized
		return factTL(n, 1);
	}
	private static long factTL(int n, long accumulator) {
		if (n == 0 || n == 1)
			return accumulator;
		else return factTL(n-1, accumulator * n);
	}
}
