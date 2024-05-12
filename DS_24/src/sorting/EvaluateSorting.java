package sorting;

import java.util.Random;

public class EvaluateSorting {
	
	private Sortable sortAlgorithm;
	private int size;
    private int maxNumber;
	
	public EvaluateSorting(Sortable sortAlgorithm, int size, int maxNumber) {
		this.sortAlgorithm = sortAlgorithm;
		this.size = size;
        this.maxNumber = maxNumber;
	}

    public EvaluateSorting(Sortable sortAlgorithm, int size) {
        this(sortAlgorithm, size, Integer.MAX_VALUE);
    }

	public Sortable getSortAlgorithm() {
		return sortAlgorithm;
	}

	public void setSortAlgorithm(Sortable sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	public void evaluate() {
        int[] sequence = generateSequence(size);
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        this.sortAlgorithm.sort(sequence);
        endTime = System.currentTimeMillis();
        if(!isSorted(sequence))
            throw new RuntimeException("Sequence not Sorted");
        System.out.println(this.sortAlgorithm.getClass().getName() + " took " + (endTime - startTime) + " ms for " + size + " numbers");
	}

	private int[] generateSequence(int size) {
		int[] sequence = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sequence[i] = random.nextInt(maxNumber);
        }
        return sequence;
	}
	
	private boolean isSorted(int[] sequence) {
        for (int i = 0; i < sequence.length - 1; i++) {
            if(sequence[i] > sequence[i+1]) return false;
        }
        return true;
    }
	

}
