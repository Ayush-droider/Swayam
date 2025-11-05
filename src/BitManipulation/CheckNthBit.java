package BitManipulation;

public class CheckNthBit {
    public static void checkNthBit(int n, int k) {
        if ((n & (1 << (k - 1))) != 0)
            System.out.println("Set");
        else
            System.out.println("Unset");
    }

    public static void main(String[] args) {
        int n = 29, k = 3;
        checkNthBit(n, k);
    }
}

