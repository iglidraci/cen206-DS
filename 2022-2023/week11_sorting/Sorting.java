public class Sorting {
    public static void insertionsSort(int[] arr) {
        for(int j=1; j <= arr.length - 1; j++) {
            int key = arr[j];
            // insert A[j] into the sorted sequence A[0 ... j-1]
            int i = j - 1;
            while (i >=0 && arr[i] > key) {
                arr[i+1] = arr[i];
                i = i - 1;
            }
            arr[i+1] = key;
        }
    }
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] a, int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        long[] left = new long[n1 + 1];
        long[] right = new long[n2 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = a[q + j + 1];
        }
        left[n1] = Integer.MAX_VALUE + 1L; // bigger than any int value
        right[n2] = Integer.MAX_VALUE + 1L;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if(left[i] <= right[j]){
                a[k] = (int) left[i];
                i = i + 1;
            } else {
                a[k] = (int) right[j];
                j = j + 1;
            }
        }
    }
}
