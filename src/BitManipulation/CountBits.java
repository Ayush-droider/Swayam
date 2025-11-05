package BitManipulation;

public class CountBits {
    public static void countBits(int n) {
        int setBits = 0, unsetBits = 0;
        int totalBits = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        for (int i = 0; i < totalBits; i++) {
            if ((n & (1 << i)) != 0) setBits++;
            else unsetBits++;
        }
        System.out.println("Set Bits: " + setBits);
        System.out.println("Unset Bits: " + unsetBits);
    }

    public static void main(String[] args) {
        int n = 29;
        countBits(n);
    }
}

