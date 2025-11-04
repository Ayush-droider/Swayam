package String;

import java.util.*;

public class BullsCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] s = new int[10], g = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                s[secret.charAt(i) - '0']++;
                g[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++)
            cows += Math.min(s[i], g[i]);
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BullsCows obj = new BullsCows();
        System.out.print("Enter secret: ");
        String secret = sc.nextLine();
        System.out.print("Enter guess: ");
        String guess = sc.nextLine();
        System.out.println("Hint: " + obj.getHint(secret, guess));
    }
}

