package sorting;

public class CountingSort implements Sortable {
	private int k;
	public CountingSort(int k) {
		this.k = k;
	}

	@Override
	public void sort(int[] arr) {
		int[] counting = new int[k + 1];
		for(int item : arr) {
			counting[item]++;
		}
		int j = 0;
		for(int i = 0; i <= k; i++) {
			while(counting[i]-- > 0) {
				arr[j++] = i;
			}
		}
	}

}
