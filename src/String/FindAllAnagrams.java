package String;

import java.util.*;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] scount = new int[26];
        int[] pcount = new int[26];

        for (char c : p.toCharArray()) pcount[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            scount[s.charAt(i) - 'a']++;
            if (i >= p.length()) scount[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(scount, pcount)) res.add(i - p.length() + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = findAnagrams(s, p);
        System.out.println(ans);
    }
}
