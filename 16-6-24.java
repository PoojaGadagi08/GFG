class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);

        if (n < 2) {
            return result;
        }

        // Step 1: Sieve of Eratosthenes to find all primes <= n
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Step 2: Find the prime pair
        for (int a = 2; a <= n; a++) {
            if (isPrime[a] && n - a > 1 && isPrime[n - a]) {
                result.set(0, a);
                result.set(1, n - a);
                return result;
            }
        }
        return result;
        
    }
}
