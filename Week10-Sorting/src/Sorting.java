public class Sorting {
    public static<T extends Comparable<T>> void insertionSort(T[] array, boolean reversed) {
        for (int j = 1; j < array.length; j++) {
            T key = array[j];
            // insert A[j] in the sorted sequence A[1 ... j-1]
            int i = j-1;
            while (i>=0 && ((array[i].compareTo(key) > 0 && !reversed)
                            ||(array[i].compareTo(key) < 0 && reversed))) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
    }
    public static<T extends Comparable<T>> void insertionSort(T[] array) {
        insertionSort(array, false);
    }
    private static<T extends Comparable<T>> void merge(T[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        T[] left =(T[]) new Object[n1];
        T[] right =(T[]) new Object[n2];
        System.arraycopy(arr, p, left, 0, n1);
        System.arraycopy(arr, q+1, right, 0, n2);
        int i = 0; int j = 0;
        for (int k = p; k < r; k++) {
            // TBD
        }
    }
}
