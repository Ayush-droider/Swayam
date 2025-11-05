package BitManipulation;

public class ModularExponentiation {
    public static long power(long x, long n, long m) {
        long res = 1;
        x = x % m;
        while (n > 0) {
            if ((n & 1) == 1) res = (res * x) % m;
            x = (x * x) % m;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        long x = 2, n = 10, m = 1000000007;
        System.out.println(power(x, n, m));
    }
}

