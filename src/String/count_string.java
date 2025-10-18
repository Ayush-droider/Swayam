package String;

import java.util.Scanner;

public class count_string {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = in.nextLine();
        str = str.toLowerCase(); // assuming lowercase

        int digit = 0, vowel = 0, cons = 0, space = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                digit++;
            } else if (ch == ' ') {
                space++;
            } else if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowel++;
                } else {
                    cons++;
                }
            }
        }

        System.out.println("\nNumber of following are:");
        System.out.println("Digit: " + digit);
        System.out.println("Vowel: " + vowel);
        System.out.println("Consonant: " + cons);
        System.out.println("Whitespace: " + space);
    }
}
