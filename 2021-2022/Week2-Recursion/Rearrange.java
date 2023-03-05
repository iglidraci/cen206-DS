/*
Write a short recursive Java method that rearranges an array of integer values
so that all the even values appear before all the odd values
*/
import java.util.Arrays;
public class Rearrange {
	public static void main (String[] args) {
		int[] nums = new int[args.length];
		for(int i=0; i < nums.length; i++) {
			nums[i] = Integer.valueOf(args[i]);
		}
		System.out.println("Original: " + Arrays.toString(nums));
		recursive(nums);
		System.out.println("Rearranged: " + Arrays.toString(nums));
	}
	public static void iterative(int[] array) {
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			while(isEven(array[start]) && start < end)
				start++;
			while (!isEven(array[end]) && start < end) {
				end--;
			}
			if (start < end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
	}
	public static void recursive(int[] array) {
		recursive(array, 0, array.length - 1);
	}
	private static void recursive (int[] array, int start, int end) {
		if (start >= end)
			return;
		while(isEven(array[start]) && start < end)
			start++;
		while (!isEven(array[end]) && start < end) {
			end--;
		}
		if (start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			recursive(array, start+1, end-1);
		}
	}
	private static boolean isEven(int nr) {
		return nr%2 == 0;
	}
}
