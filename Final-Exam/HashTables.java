import java.util.HashMap;
import java.util.Random;

public class HashTables {
    public static void main(String[] args) {
        int[] numbers = buildRandomArray();
        HashMap<Integer, Integer> frequencies = findFrequencies(numbers);
        for (int key : frequencies.keySet()) {
            System.out.println("Element " + key + " was found " + frequencies.get(key) + " times");
        }
    }
    private static int[] buildRandomArray() {
        int[] numbers = new int[1000];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1, 11);
        }
        return numbers;
    }
    static HashMap<Integer, Integer> findFrequencies(int[] elements) {
        /*
         * O(n) linear time
         * we are looping the array only once
         */
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int el : elements) {
            if (frequencies.containsKey(el))
                frequencies.put(el, frequencies.get(el) + 1); // add 1 to the frequency of the element that we just found
            else
                frequencies.put(el, 1); // we see this element for the first time
        }
        return frequencies;
    }
}
