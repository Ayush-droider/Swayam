package Arrays;

import java.util.Scanner;

public class dulicate_remove {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Array size --->");
        int n = in.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements (sorted):");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int i = 0;
        int count = 0;

        while (i < arr.length) {
            // If next element is same, skip all duplicates
            if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                i++;
                continue;
            } else {
                arr[count] = arr[i];
                count++;
                i++;
            }
        }

        System.out.println("After Duplicates Removal:");
        for (int j = 0; j < count; j++) {
            System.out.print(arr[j] + " ");
        }

        System.out.println("\nUnique element count: " + count);
    }
}
