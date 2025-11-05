package BitManipulation;

import java.util.*;

public class SieveOfEratosthenes {
    public static List<Integer> sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (prime[i]) primes.add(i);
        return primes;
    }

    public static void main(String[] args) {
        int n = 50;
        System.out.println(sieve(n));
    }
}
