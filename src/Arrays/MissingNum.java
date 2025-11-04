package Arrays;

import java.util.*;

public class MissingNum {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int total = 0;
        for (int x : nums) total += x;
        return sum - total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MissingNum obj = new MissingNum();
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Missing number: " + obj.missingNumber(arr));
    }
}

