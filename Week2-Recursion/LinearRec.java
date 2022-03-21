import java.util.Arrays;

public class LinearRec {
	public static void main (String[] args) {
		Integer[] array = new Integer[args.length];
		for (int i=0; i < args.length; i++)
			array[i] = Integer.valueOf(args[i]);
		System.out.println("Input array: " + Arrays.toString(array));
		reverse(array);
		System.out.println("Reversed array: " + Arrays.toString(array));
		System.out.println("Power(4, 6) = " + power(4, 6));
		System.out.println("Math.pow(4, 6) = " + Math.pow(4, 6));
	}
	public static<T> void reverse (T[] array) {
		// reverse in place
		swap(array, 0, array.length - 1);
	}
	private static<T> void swap(T[] array, int left, int right) {
		if (left >= right)
			return;
		T temp = array[right];
		array[right] = array[left];
		array[left] = temp;
		swap(array, left + 1, right - 1);
	}
	public static long power (int a, int n) {
		if (n == 0)
			return 1;
		int k = n/2;
		long result = power(a, k);
		if (n % 2 == 0)
			return result * result;
		else
			return result * result * a;
	}
}
