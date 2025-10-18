package Arrays;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of first array:");
        int n1 = in.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = in.nextInt();
        }
        System.out.println("Enter size of second array:");
        int n2 = in.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = in.nextInt();
        }
        int[] result = intersection(nums1, nums2);
        System.out.println("Intersection elements: " + Arrays.toString(result));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) {
            ans[i++] = num;
        }
        return ans;
    }
}
