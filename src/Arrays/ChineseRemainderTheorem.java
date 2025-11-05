package Arrays;

public class ChineseRemainderTheorem {
    public static int findMinX(int[] num, int[] rem, int k) {
        int prod = 1;
        for (int i = 0; i < k; i++) prod *= num[i];
        int result = 0;
        for (int i = 0; i < k; i++) {
            int pp = prod / num[i];
            result += rem[i] * modInverse(pp, num[i]) * pp;
        }
        return result % prod;
    }

    private static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1) return x;
        return 1;
    }

    public static void main(String[] args) {
        int[] num = {3, 4, 5};
        int[] rem = {2, 3, 1};
        int k = num.length;
        System.out.println(findMinX(num, rem, k));
    }
}

