Given a string consisting of lower case English alphabets, the task is to find the number of distinct subsequences of the string
Note: Answer can be very large, so, ouput will be answer modulo 109+7.

Example 1:

Input: 
s = "gfg"
Output: 
7
Explanation: 
The seven distinct subsequences are "", "g", "f", "gf", "fg", "gg" and "gfg" .
Example 2:

Input: 
s = "ggg"
Output: 
4
Explanation: 
The four distinct subsequences are "", "g", "gg", "ggg".
Your task:
You do not need to read any input or print anything. The task is to complete the function distinctSubsequences(), which takes a string as input and returns an integer.

Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 ≤ |s| ≤ 105
s contains lower case English alphabets







  class Solution {
    // Define the modulo constant
    final int MOD = (int)1e9 + 7;

    int distinctSubsequences(String s) {
        // Get the length of the string
        int n = s.length();

        // Initialize the dp array and last_occurrence array
        int[] dp = new int[n + 1];
        int[] last_occurrence = new int[256];
        Arrays.fill(last_occurrence, -1);

        // Base case: there's only one subsequence (the empty string)
        dp[0] = 1;

        // Iterate over each character in the string
        for (int i = 1; i <= n; i++) {
            // For each character, we have two options: include it in our subsequences or not
            dp[i] = (2 * dp[i - 1]) % MOD;

            // If the current character has appeared before, subtract the number of subsequences at its last occurrence
            if (last_occurrence[s.charAt(i - 1)] != -1) {
                dp[i] -= dp[last_occurrence[s.charAt(i - 1)]];
            }

            // Take modulo to avoid overflow
            dp[i] %= MOD;

            // Update the last occurrence of the current character
            last_occurrence[s.charAt(i - 1)] = i - 1;
        }

        // Return the number of distinct subsequences modulo MOD
        return (dp[n] + MOD) % MOD;
    }
}
