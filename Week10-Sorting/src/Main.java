import java.util.Random;

public class Main {
    static final int SIZE = 10000;

    public static void main(String[] args) {
        long start, end;
        var arr1 = buildArray();
        start = System.currentTimeMillis();
		System.out.println("Sorting using insertion sort ...");
        Sorting.insertionSort(arr1);
        end = System.currentTimeMillis();
        testSorted(arr1);
        System.out.println("Insertion sort took " + (end- start) + " ms");
        var arr2 = buildArray();
        start = System.currentTimeMillis();
		System.out.println("Sorting using merge sort ...");
        Sorting.mergeSort(arr2);
        end = System.currentTimeMillis();
        testSorted(arr2);
        System.out.println("Merge sort took " + (end-start) + " ms");
		var arr3 = buildArray();
		start = System.currentTimeMillis();
		System.out.println("Sorting using bubble sort ...");
		Sorting.bubbleSort(arr3);
		end = System.currentTimeMillis();
		testSorted(arr3);
		System.out.printf("Bubble sort took %d ms\n", (end-start));
		var arr4 = buildArray();
		start = System.currentTimeMillis();
		System.out.println("Sorting using quick sort ...");
		Sorting.quickSort(arr4);
		end = System.currentTimeMillis();
		testSorted(arr4);
		System.out.printf("Quick sort took %d ms\n", (end-start));
		var arr5 = buildArray();
		start = System.currentTimeMillis();
		System.out.println("Sorting using randomized quick sort ...");
		Sorting.randomizedQuickSort(arr5);
		end = System.currentTimeMillis();
		testSorted(arr5);
		System.out.printf("Randomized quick sort took %d ms\n", (end-start));
		int k = 1000;
		var arr6 = buildArray(k); // range from 1 to 500
		start = System.currentTimeMillis();
		System.out.println("Sorting using counting sort ...");
		Sorting.countingSort(arr6, k);
		end = System.currentTimeMillis();
		testSorted(arr6);
		System.out.printf("Counting sort took %d ms\n", (end-start));
    }

    private static<T extends Comparable<T>> void testSorted(T[] arr) {
        if (arr.length == 0 || arr.length == 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            assert arr[i].compareTo(arr[i+1]) <= 0;
        }
    }

    private static Integer[] buildArray() {
		return buildArray(Integer.MAX_VALUE);
    }
	private static Integer[] buildArray(int bound) {
		Integer[] arr = new Integer[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
	}
}
