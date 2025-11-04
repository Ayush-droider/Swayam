package Arrays;

import java.util.*;

public class koko {
    public static int minEatingSpeed(int[] piles, int hours) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFinish(piles, hours, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canFinish(int[] piles, int hours, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time <= hours;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of banana piles: ");
        int n = sc.nextInt();

        int[] piles = new int[n];
        System.out.println("Enter bananas in each pile:");
        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        System.out.print("Enter total hours available: ");
        int h = sc.nextInt();

        int result = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}

