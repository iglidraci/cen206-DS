package recursion;

public class Power {
    public static long pow(int a, int n) {
        if(n == 0) return 1;
        int k = n / 2;
        long temp = pow(a, k);
        long res = temp * temp;
        if(n % 2 == 1)
            res *= a;
        return res;
    }
}
