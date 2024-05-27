Given an integer array a[] of size n, find the length of the longest subsequence such that the absolute difference between adjacent elements is 1.

Example 1:

Input:
n = 7
a[] = {10, 9, 4, 5, 4, 8, 6}
Output: 
3
Explaination: 
The three possible subsequences of length 3 are {10, 9, 8}, {4, 5, 4}, and {4, 5, 6}, where adjacent elements have a absolute difference of 1. No valid subsequence of greater length could be formed.
Example 2:

Input: 
n = 5
a[] = {1, 2, 3, 4, 5}
Output: 
5
Explaination: 
All the elements can be included in the valid subsequence.
Your Task:
You do not need to read input. Your task is to complete the function longestSubseq() which takes integer n and array a[] as input parameters and returns the length of the longest subsequence where the absolute difference of adjacent elements is 1.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 103
1 ≤ a[i] ≤ 103

class Solution {
    public static int longestSubseq(int n, int[] a) {
        // code here
        int[] dp = new int[n];
        // Initialize all dp values to 1 (each element can be a subsequence of length 1)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        // Iterate through the array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if the absolute difference between a[i] and a[j] is 1
                if (Math.abs(a[i] - a[j]) == 1) {
                    // Update dp[i] if a longer subsequence ending at i is found
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // Find the maximum value in dp array
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}
