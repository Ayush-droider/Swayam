package Arrays;

import java.util.*;

public class ContigSub {
    public int longestContiguous(int[] arr) {
        int n = arr.length, maxLen = 0;
        for (int i = 0; i < n; i++) {
            int min = arr[i], max = arr[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (set.contains(arr[j])) break;
                set.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if (max - min == j - i)
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContigSub obj = new ContigSub();
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Length of largest contiguous subarray: " + obj.longestContiguous(arr));
    }
}
