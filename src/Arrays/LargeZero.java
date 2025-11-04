package Arrays;

import java.util.*;

public class LargeZero {
    public int maxLen(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) max = i + 1;
            else if (map.containsKey(sum))
                max = Math.max(max, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LargeZero obj = new LargeZero();
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Largest subarray length: " + obj.maxLen(arr));
    }
}
