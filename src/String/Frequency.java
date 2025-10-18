package String;

import java.util.*;

public class Frequency {
    public static void Printfrequency(String str) {
        str = str.toLowerCase();
        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                freq[ch - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                System.out.print((char) (i + 'a'));
                System.out.print(freq[i] + " ");
            }
        }
        System.out.println(); // newline at the end
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = in.nextLine();
        Printfrequency(str);
    }
}
