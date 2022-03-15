// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Input: nums = [3,2,4], target = 6
// Output: [1,2]

public class TwoSum {

  public static void main (String[] args) {
    System.out.println("Welcome to Data Structures coruse");
	int[] numbers = {3, 2, 3};
	int target = 6;
	int[] result = twoSum(numbers, target);
	Common.printArray(result);
  }
  // it works but very naive solution
  // we'll look to improve it later on
  public static int[] twoSum(int[] numbers, int target) {
    for (int i=0; i < numbers.length - 1; i++)
      for (int j=i+1; j<numbers.length; j++)
        if (numbers[i] + numbers[j] == target)
          return new int[] {i, j};
    return null;
  }

}
