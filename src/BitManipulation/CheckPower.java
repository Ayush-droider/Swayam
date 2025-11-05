package BitManipulation;

public class CheckPower {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println("Power of Two: " + isPowerOfTwo(n));
        System.out.println("Power of Four: " + isPowerOfFour(n));
    }
}

