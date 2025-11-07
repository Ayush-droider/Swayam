package Arrays;

import java.util.*;

public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        long sum1 = 0, sum2 = 0;
        int chunks = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += sorted[i];
            if (sum1 == sum2) chunks++;
        }
        return chunks;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII obj = new MaxChunksToMakeSortedII();
        int[] arr = {2, 1, 3, 4, 4};
        System.out.println(obj.maxChunksToSorted(arr)); // Output: 4
    }
}

