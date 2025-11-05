package BitManipulation;

public class InclusionExclusion {
    public static int countMultiples(int n, int a, int b) {
        int countA = n / a;
        int countB = n / b;
        int countAB = n / lcm(a, b);
        return countA + countB - countAB;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        int n = 20, a = 2, b = 3;
        System.out.println(countMultiples(n, a, b));
    }
}

