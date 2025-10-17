package Arrays;

import java.util.*;

public class pivot {
    public static int equi(int[] arr) {
        int start = 0, end = arr.length - 1;

        // handle edge cases
        if (arr.length == 0) return -1;
        if (arr.length == 1) return 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || arr[mid] < arr[mid - 1]) &&
                    (mid == arr.length - 1 || arr[mid] < arr[mid + 1])) {
                return mid;
            }
            else if (mid > 0 && arr[mid - 1] < arr[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Array size ---> ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int ans = equi(arr);
        if (ans == -1)
            System.out.println("No local minimum exists");
        else
            System.out.println("Local minimum exists at index " + ans + " with value " + arr[ans]);
    }
}
