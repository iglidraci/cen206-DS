package recursion;

public class Searching {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 3, 4, 4, 5};
        System.out.println(binarySearch(array, 9));
    }

    public static<T extends Comparable<T>> boolean binarySearch(T[] array, T key) {
        // return whether a key is located inside a sorted sequence of keys
        return binarySearch(array, key, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> boolean binarySearch(T[] array, T key, int low, int high) {
        if (low > high) return false;
        int mid = (low + high) / 2; // remember the case when this won't work? TODO: FIX IT
        int cmp = key.compareTo(array[mid]);
        if (cmp == 0)
            return true;
        else if (cmp > 0) {
            return binarySearch(array, key, mid + 1, high);
        } else {
            return binarySearch(array, key, low, mid - 1);
        }
    }
}
