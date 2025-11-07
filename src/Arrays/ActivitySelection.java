package Arrays;

import java.util.*;

public class ActivitySelection {
    public int maxActivities(int[] start, int[] end) {
        int n = start.length;
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));
        int count = 1, lastEnd = activities[0][1];
        for (int i = 1; i < n; i++) {
            if (activities[i][0] > lastEnd) {
                count++;
                lastEnd = activities[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ActivitySelection obj = new ActivitySelection();
        int[] start = {1, 3, 2, 5};
        int[] end = {2, 4, 3, 6};
        System.out.println(obj.maxActivities(start, end)); // Output: 3
    }
}

