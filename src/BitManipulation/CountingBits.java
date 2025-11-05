package BitManipulation;

public class CountingBits {
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ans = countBits(n);
        for (int x : ans) System.out.print(x + " ");
    }
}
