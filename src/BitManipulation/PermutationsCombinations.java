package BitManipulation;

public class PermutationsCombinations {
    static long fact(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    static long nCr(int n, int r) {
        if (r > n) return 0;
        return fact(n) / (fact(r) * fact(n - r));
    }

    static long nPr(int n, int r) {
        if (r > n) return 0;
        return fact(n) / fact(n - r);
    }

    public static void main(String[] args) {
        int n = 5, r = 2;
        System.out.println("nCr = " + nCr(n, r));
        System.out.println("nPr = " + nPr(n, r));
    }
}
