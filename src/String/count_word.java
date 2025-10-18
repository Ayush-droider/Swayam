package String;

import java.util.Scanner;

public class count_word {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = in.nextLine();
        String[] s=str.split(" ");
        int cnt=0;
        for(String st:s)cnt++;
        System.out.println("Number of words in String are: "+cnt);
    }
}
