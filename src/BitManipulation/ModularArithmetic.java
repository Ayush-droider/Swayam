package BitManipulation;

public class ModularArithmetic {
    static int mod = 1000000007;

    public static long add(long a, long b) {
        return ((a % mod) + (b % mod)) % mod;
    }

    public static long subtract(long a, long b) {
        return ((a % mod) - (b % mod) + mod) % mod;
    }

    public static long multiply(long a, long b) {
        return ((a % mod) * (b % mod)) % mod;
    }

    public static void main(String[] args) {
        long a = 15, b = 28;
        System.out.println("Add: " + add(a, b));
        System.out.println("Subtract: " + subtract(a, b));
        System.out.println("Multiply: " + multiply(a, b));
    }
}

