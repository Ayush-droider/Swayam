package Recursion;

import java.util.*;

public class Combinations {
    static List<List<Integer>> res = new ArrayList<>();

    static void combine(int n, int k, int start, List<Integer> curr) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            combine(n, k, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        combine(n, k, 1, new ArrayList<>());
        System.out.println(res);
    }
}

