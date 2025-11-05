package Recursion;

import java.util.*;

public class CombinationSum {
    static List<List<Integer>> res = new ArrayList<>();

    static void solve(int[] arr, int target, int i, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i == arr.length || target < 0) return;
        curr.add(arr[i]);
        solve(arr, target - arr[i], i, curr);
        curr.remove(curr.size() - 1);
        solve(arr, target, i + 1, curr);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        solve(arr, target, 0, new ArrayList<>());
        System.out.println(res);
    }
}

