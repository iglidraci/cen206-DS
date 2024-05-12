package sorting;

public class Main {
    public static void main(String[] args) {
    	int size = 20_000_000;
    	EvaluateSorting evaluateSort = new EvaluateSorting(new MergeSort(), size, 10*size);
    	evaluateSort.evaluate();
    	evaluateSort.setSortAlgorithm(new CountingSort(10*size));
        evaluateSort.evaluate();
        evaluateSort.setSortAlgorithm(new InsertionSort());
        evaluateSort.evaluate();
    }
}
