package Recursion;

import java.util.*;

public class CombinationSum2 {
    static List<List<Integer>> res = new ArrayList<>();

    static void solve(int[] arr, int target, int start, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            curr.add(arr[i]);
            solve(arr, target - arr[i], i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(arr);
        solve(arr, target, 0, new ArrayList<>());
        System.out.println(res);
    }
}
