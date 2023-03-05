import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15}; int target = 9;
        System.out.println("Two sum solution: " + Arrays.toString(twoSum(numbers, target)));
        System.out.println("Single number solution: " + single(new int[]{4,1,2,1,2}));
        System.out.println("First and last position: " + Arrays.toString(firstAndLastPosition(new int[]{5, 7, 7, 8, 8, 10}, 6)));

    }
    static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target)
                    return new int[] {i, j};
            }
        }
        return null;
    }

    static int single(int[] numbers) {
        // every element appears twice except for one
        int xor = 0;
        for(int x : numbers)
            xor ^= x;
        return xor;
    }

    static int[] firstAndLastPosition(int[] numbers, int target) {
        int first, last;
        first = last = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target)
                break;
            if(numbers[i] == target) {
                if (first == -1)
                    first = i;
                else last = i;
            }
        }
        if (first == -1) return new int[] {-1, -1};
        else if (last == -1) return new int[]{first, first};
        else return new int[] {first, last};
    }
}