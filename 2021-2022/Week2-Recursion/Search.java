import java.lang.Comparable;
import java.util.Arrays;

public class Search {
	public static void main (String[] args) {
		if (args.length == 0) {
			System.out.println("Wrong usage of the application");
			System.out.println("Pass as args each element in the sorted array and lastly the key");
			System.out.println("java Search 1 2 3 3 4 6 key");
			System.exit(1);
		}
		Integer[] numbers = new Integer[args.length - 1];
		for(int i=0; i<args.length - 1; i++)
			numbers[i] = Integer.valueOf(args[i]);
		Integer key = Integer.valueOf(args[args.length - 1]);
		System.out.println("Array: " + Arrays.toString(numbers));
		System.out.println("Search Key: " + key);
		boolean isIn = binarySearch(numbers, key);
		if (isIn)
			System.out.println("Key " + key + " was found in the array");
		else
			System.out.println("Key " + key + " wasn't found in the array");
	}

	public static<T> boolean linearSearch(T[] array, T key) {
		for (T element: array)
			if (element.equals(key))
				return true;
		return false;
	}
	public static<T extends Comparable<T>> boolean binarySearch(T[] array, T key) {
		return recursiveSearch(array, key, 0, array.length - 1);
	}

	private static<T extends Comparable<T>> boolean recursiveSearch(T[] array, T key, int left, int right) {
		if (left > right)
			return false;
		int mid = (left + right) / 2;
		int result = array[mid].compareTo(key);
		if (result == 0)
			return true;
		else if (result > 0)
			return recursiveSearch(array, key, left, mid - 1);
		else
			return recursiveSearch(array, key, mid + 1, right);
	}
}
