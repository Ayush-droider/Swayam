package String;

import java.util.*;

public class UniqueSubsets {
    static Set<String> set = new HashSet<>();

    public static void subsets(String s, String curr, int i) {
        if (i == s.length()) {
            set.add(curr);
            return;
        }
        subsets(s, curr + s.charAt(i), i + 1);
        subsets(s, curr, i + 1);
    }

    public static void main(String[] args) {
        String s = "aab";
        subsets(s, "", 0);
        for (String str : set) System.out.println(str);
    }
}

