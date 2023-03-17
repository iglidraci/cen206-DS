import java.util.Arrays;

public class LinearRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 2, 4, 5};
        reverse(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(power(2, 6));
        System.out.println(baseTwoLog(9));
    }

    static void reverse(int[] data) {
        reverse(data, 0, data.length - 1);
    }
    private static void reverse(int[] data, int left, int right) {
        if (left > right) return;
        data[left] = data[left] ^ data[right];
        data[right] = data[left] ^ data[right];
        data[left] = data[left] ^ data[right];
        reverse(data, left + 1, right - 1);
    }

    static long power(int a, int n) {
        if (n == 0) return 1;
        int k = n/2;
        long res = power(a, k);
        if (n % 2 == 0)
            return res * res;
        else
            return res * res * a;
    }

    static int baseTwoLog(int n) {
        /*
        Recursive algorithm to compute the integer part of the base-two
        logarithm of n using only addition and integer division.
        */
        return (n <= 1) ? 0 : 1 + baseTwoLog(n/2);
    }
}
