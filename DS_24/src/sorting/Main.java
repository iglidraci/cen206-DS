package sorting;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 200_000;
        int[] sequence = generateSequence(size);
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        Sorting.insertionsSort(sequence);
        endTime = System.currentTimeMillis();
        if(!isSorted(sequence))
            throw new RuntimeException("Sequence not sorted");
        System.out.println("Insertion sort took " + (endTime - startTime) + " ms for " + size + " numbers");
        sequence = generateSequence(size);
        startTime = System.currentTimeMillis();
        Sorting.mergeSort(sequence);
        endTime = System.currentTimeMillis();
        if(!isSorted(sequence))
            throw new RuntimeException("Sequence not Sorted");
        System.out.println("Merge-sort took " + (endTime - startTime) + " ms for " + size + " numbers");
    }

    private static int[] generateSequence(int size) {
        int[] sequence = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sequence[i] = random.nextInt();
        }
        return sequence;
    }

    private static boolean isSorted(int[] sequence) {
        for (int i = 0; i < sequence.length - 1; i++) {
            if(sequence[i] > sequence[i+1]) return false;
        }
        return true;
    }
}
