package Arrays;

import java.util.*;

public class AsteroidCollisions {

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int a : asteroids) {
            boolean alive = true;
            while (alive && a < 0 && !st.isEmpty() && st.peekLast() > 0) {
                int top = st.peekLast();
                if (Math.abs(top) < Math.abs(a)) {
                    st.removeLast();
                    continue;
                } else if (Math.abs(top) == Math.abs(a)) {
                    st.removeLast();
                    alive = false;
                    break;
                } else {
                    alive = false;
                    break;
                }
            }
            if (alive) st.addLast(a);
        }

        int[] res = new int[st.size()];
        int i = 0;
        for (int val : st) res[i++] = val;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of asteroids: ");
        int n = sc.nextInt();
        int[] asteroids = new int[n];
        System.out.println("Enter asteroids values:");
        for (int i = 0; i < n; i++) asteroids[i] = sc.nextInt();

        int[] result = asteroidCollision(asteroids);

        System.out.println("Remaining asteroids:");
        if (result.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
