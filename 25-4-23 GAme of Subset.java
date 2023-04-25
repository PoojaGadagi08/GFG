// Q.Elena is the topper of the class. Once her teacher asked her a problem. He gave Elena an array of integers of length n. 
// He calls a subset of array arr good if its product can be represented as a product of one or more distinct prime numbers. 
// He asked her to find the number of different good subsets in arr modulo 109 + 7.


class Solution {

   private static final int MOD = (int) 1e9 + 7;
    // list of the first 10 primes
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    // array of masks representing whether each number from 2 to 30 is divisible by any of the primes
    private static final int[] PRIME_MASKS = new int[31];

    static {
        for (int i = 2; i <= 30; ++i) {
            // We exclude the numbers that are divisible by a square of a prime number,
            // since they cannot be part of a good subset (see explanation in countGoodSubsets method).
            if (i % 4 == 0 || i % 9 == 0 || i == 25) continue;
            int mask = 0;
            for (int j = 0; j < 10; ++j) {
                // Check if i is divisible by the jth prime factor
                if (i % PRIMES[j] == 0) {
                    // If it is, set the corresponding bit in the mask
                    mask |= 1 << j;
                }
            }
            PRIME_MASKS[i] = mask;
        }
    }
    
    // This method computes (2^n) % MOD in logarithmic time using exponentiation by squaring
    private static long pow2(int n) {
        long ans = 1, m = 2;
        while (n != 0) {
            if ((n & 1) == 1) ans = (ans * m) % MOD;
            m = (m * m) % MOD;
            n >>= 1;
        }
        return ans;
    }

    // main method to count the number of good subsets in an array
    public int goodSubsets(int[] arr, int n) {
        // count of the number of 1s in arr
        int oneCount = 0;
        // array to store the number of good subsets for each possible subset mask
        int[] dp = new int[1 << 10];
        // array to store the number of times each prime appears in arr
        int[] primeCounts = new int[31]; 
        dp[0] = 1; // there is one good subset of the empty set
        for (int i : arr) {
            if (i == 1) {
                oneCount++; // increment the count of 1s
            } else if (PRIME_MASKS[i] != 0) {
                // increment the count of the prime represented by the mask for this number
                primeCounts[i]++; 
            }
        }
        
        for (int i = 0; i < 31; ++i) {
            // Skip primes that are not present in arr
            if (primeCounts[i] == 0) continue;
            int primeMask = PRIME_MASKS[i];
            for (int j = 0; j < 1 << 10; ++j) {
                // If the prime mask of i and the current subset mask j have any bits in common,
                // then adding i to j would create a bad subset (i.e., a subset that contains
                // two numbers that share a prime factor).
                if ((j & primeMask) != 0) continue;
                dp[j | primeMask] = (int) ((dp[j | primeMask] + dp[j] * (long) primeCounts[i]) % MOD);
            }
        }
    // Initialize the answer variable as 0.
        long ans = 0;

    // Loop through the "dp" array, which contains the counts of subsets that can be formed using prime numbers.
    // Add each count to the answer variable and take modulo with "MOD" to avoid integer overflow.
        for (int count : dp) {
            ans = (ans + count) % MOD;
        }
        // Decrement the answer by 1 to exclude the empty set.
        ans--;
    
    // If there are any ones in the input array, multiply the answer with 2 raised to the power of the count of ones.
        if (oneCount != 0) {
            ans = (ans * pow2(oneCount)) % MOD;
        }
    
    // Return the answer as an integer.
        return (int) ans;
    }

};
