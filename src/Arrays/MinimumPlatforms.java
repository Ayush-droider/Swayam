package Arrays;

import java.util.*;

public class MinimumPlatforms {
    public int findPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, platform = 0, maxPlatform = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                platform++;
                maxPlatform = Math.max(maxPlatform, platform);
                i++;
            } else {
                platform--;
                j++;
            }
        }
        return maxPlatform;
    }

    public static void main(String[] args) {
        MinimumPlatforms obj = new MinimumPlatforms();
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(obj.findPlatform(arr, dep)); // Output: 3
    }
}

