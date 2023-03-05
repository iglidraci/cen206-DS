import java.util.Scanner;
public class SingleElement {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int size = scanner.nextInt();
		if (size % 2 == 0) {
			System.out.println("Size cannot be even number");
			System.exit(1);
		}
		int[] nums = new int[size];
 		for (int i=0; i<size; i++) {
			System.out.print("-> ");
			nums[i] = scanner.nextInt();
		}
		System.out.println("Single element: " + singleElement(nums));
	}
	public static int singleElement(int[] nums) {
		int xor = 0;
		for (int num: nums)
			xor = xor ^ num;
		return xor;
	}
}
