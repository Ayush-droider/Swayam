package Arrays;

import java.util.*;

public class FBV {
    static int bad;

    public static boolean isBadVersion(int version) {
        return version >= bad;
    }

    public static int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total versions: ");
        int n = sc.nextInt();
        System.out.print("Enter first bad version: ");
        bad = sc.nextInt();
        System.out.println("First bad version is: " + firstBadVersion(n));
    }
}
