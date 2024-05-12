package sorting;

public class InsertionSort implements Sortable{
    @Override
    public void sort(int[] arr) {
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
}
