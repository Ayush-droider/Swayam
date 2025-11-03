package Arrays;

import java.util.*;

public class findSmaller {

    public static void findSmallerOnLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) st.pop();
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        System.out.println("Smaller Element on Left:");
        for (int i = 0; i < n; i++)
            System.out.println(arr[i] + " -> " + result[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        findSmallerOnLeft(arr);
    }
}
