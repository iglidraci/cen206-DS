import java.util.Random;

public class Sorting {
	/*insertion sort*/
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
	/*end of insertion sort*/

	/*merge sort*/
    private static<T extends Comparable<T>> void merge(T[] arr, int p, int q, int r) {
        // computes the length n1 of the subarray A[p...q]
        int n1 = q - p + 1;
        // computes the length n2 of the subarray A[q+1 ... r]
        int n2 = r - q;
        T[] left =(T[]) new Comparable[n1];
        T[] right =(T[]) new Comparable[n2];
        System.arraycopy(arr, p, left, 0, n1);
        System.arraycopy(arr, q+1, right, 0, n2);
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            int comparator;
            if (i == n1)
                comparator = 1; // +infinity only in the L array
            else if (j == n2)
                comparator = -1; // +infinity only in the R array
            else
                comparator = left[i].compareTo(right[j]);
            if (comparator<= 0) arr[k] = left[i++];
            else arr[k] = right[j++];
        }
    }
    private static<T extends Comparable<T>> void mergeSort(T[] array, int p, int r) {
        if (p < r) {
            int q = (p+r)/2;
            mergeSort(array, p, q);
            mergeSort(array, q+1, r);
            merge(array, p, q, r);
        }
    }
    public static<T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length <= 1) return;
        mergeSort(array, 0, array.length-1);
    }
	/*end of merge sort*/
	/*bubble sort aka sinking sort*/
	public static<T extends Comparable<T>> void bubbleSort(T[] array) {
		for(int i=0; i < array.length-1; i++) {
			boolean swapped = false;
			for (int j=0; j<array.length - i - 1; j++) {
				if (array[j].compareTo(array[j+1]) > 0) {
					swap(array, j, j+1);
					swapped = true;
				}
			}
			if (!swapped) break;
		}
	}
	/*end of bubble sort*/
	/*quick sort*/
	public static<T extends Comparable<T>> void quickSort(T[] arr) {
		if (arr.length <= 1) return;
		quickSort(arr, 0, arr.length-1);
	}
	private static<T extends Comparable<T>> void quickSort(T[] arr, int p, int r) {
		if (p<r){
			int q = partition(arr, p, r);
			quickSort(arr, p, q-1);
			quickSort(arr, q+1, r);
		}
	}
	private static<T extends Comparable<T>> int partition(T[] arr, int p, int r) {
		T x = arr[r];
		int i = p-1;
		for(int j=p; j<=r-1; j++) {
			if (arr[j].compareTo(x) <= 0) {
				i++;
				// swap arr[i] with arr[j]
				swap(arr, i, j);
			}
		}
		// swap arr[i+1] with arr[r]
		swap(arr, i+1, r);
		return i+1;
	}
	/*end of quick sort*/

	/*randomized quicksort*/
	public static<T extends Comparable<T>> void randomizedQuickSort(T[] arr) {
		if (arr.length <= 1) return;
		randomizedQuickSort(arr, 0, arr.length-1);
	}
	private static<T extends Comparable<T>> void randomizedQuickSort(T[] arr, int p, int r) {
		if (p < r) {
			int q = randomizedPartition(arr, p, r);
			randomizedQuickSort(arr, p, q-1);
			randomizedQuickSort(arr, q+1, r);
		}
	}
	private static<T extends Comparable<T>> int randomizedPartition(T[] arr, int p, int r) {
		Random random = new Random();
		int i = random.nextInt(p, r);
		swap(arr, i, r);
		return partition(arr, p, r);
	}
	/*end of randomized quicksort*/

	/*
	counting sort O(n + k)
	if k is of order O(n) then you're good
	else you should worry
	*/

	public static void countingSort(Integer[] arr, int k) {
		int[] counting = new int[k+1];
		for(int i=0; i<arr.length; i++)
			counting[arr[i]]++;
		int t=0;
		for(int i=0; i<=k; i++) {
			if(counting[i]!=0) {
				for(int j=0; j<counting[i]; j++)
					arr[t++] = i;
			}
		}
	}

	/*auxiliary methods*/
	private static<T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
 }
