import java.util.Arrays;

class Solution {
	public static void main (String[] args) {
		int[][] cases = new int[][] {
			{1, 2, 3},
			{1, 0, 0},
			{1, 0, 0, 0, 0},
			{9, 0}
		};
		for(int[] digits: cases) {
			Common.printArray(digits);
			int[] solution = decrement(digits);
			System.out.print("Solution: ");
			Common.printArray(solution);
		}
	}
    public static int[] decrement(int[] digits) {
		int size = digits.length;
		for(int i=size-1; i>=0; i--) {
			if (digits[i] == 0) {
				digits[i] = 9;
			} else {
				digits[i]--;
				break;
			}
		}
		if (digits[0] == 0 && size > 1)
			return Arrays.copyOfRange(digits, 1, size);
		return digits;
    }
}
