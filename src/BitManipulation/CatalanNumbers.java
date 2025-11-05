package BitManipulation;

public class CatalanNumbers {
    static long catalan(int n) {
        long res = nCr(2 * n, n);
        return res / (n + 1);
    }

    static long nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(catalan(n));
    }
}
