package String;

import java.util.*;

public class valid_palindrome {
    public static boolean isValid(String s) {
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                str.append(Character.toLowerCase(ch));
            }
        }
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str=in.nextLine();
        boolean ans=isValid(str);
        if(ans==false) System.out.println("It is not a palindrome");
        else System.out.println("It is a palindrome");
    }
}
