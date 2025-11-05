package BitManipulation;

public class ToggleKthBit {
    public static int toggleKthBit(int n, int k) {
        return n ^ (1 << (k - 1));
    }

    public static void main(String[] args) {
        int n = 29, k = 3;
        System.out.println(toggleKthBit(n, k));
    }
}

