import java.util.Arrays;
import java.util.Random;

public class Main {
    static final int SIZE = 1_000;

    public static void main(String[] args) {
        Integer[] arr = buildArray();
        Sorting.insertionSort(arr, true);
        System.out.println(Arrays.toString(arr));
    }

    private static Integer[] buildArray() {
        Integer[] arr = new Integer[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
}
