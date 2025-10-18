package String;

import java.util.HashMap;
import java.util.Scanner;

public class max_freq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = in.nextLine();

        int max = 0;
        char maxChar = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }

            if (map.get(arr[i]) > max) {
                max = map.get(arr[i]);
                maxChar = arr[i];
            }
        }

        System.out.println("Maximum occurring character: " + maxChar + " (Frequency: " + max + ")");
    }
}
