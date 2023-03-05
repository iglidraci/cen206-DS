/*
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
*/

public class FirstLast {
	public static void main (String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int[] result = firstAndLastPosition(nums, target);
		Common.printArray(result);
	}
	public static int[] firstAndLastPosition(int[] nums, int target) {
		int first = -1;
		int last = -1;
		for (int i=0; i < nums.length; i++) {
			if (nums[i] > target)
				break;
			if (nums[i] == target && first == -1)
				first = i;
			else if (nums[i] == target)
				last = i;
		}
		if (first == -1) return new int[] {-1, -1};
		else if (last == -1) return new int[] {first, first};
		return new int[] {first, last};
	}
}
