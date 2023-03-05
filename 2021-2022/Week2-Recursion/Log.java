/*
Describe a recursive algorithm to compute the integer part of the base-two
logarithm of n using only addition and integer division.
*/

public class Log {
	public static void main (String[] args) {
		int n = Integer.valueOf(args[0]);
		System.out.printf("Log2(%d)=%d\n", n, baseTwoLog(n));
	}
	public static int baseTwoLog(int n) {
		return (n <= 1) ? 0 : 1 + baseTwoLog(n/2);
	}
}
