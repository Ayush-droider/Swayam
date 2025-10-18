package Arrays;

import java.util.Scanner;

public class Majority_element {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Array size--->");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int cnt = 0;
        int candidate = 0;
        for (int nums : arr) {
            if (cnt == 0) {
                candidate = nums;
            }
            if (candidate == nums) cnt++;
            else cnt--;
        }
        System.out.println("Majority Element:- "+candidate);
    }
}
