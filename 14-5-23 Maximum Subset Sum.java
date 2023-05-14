// Given an array A of size N. Find the maximum subset-sum of elements that you can make from the given array 
// such that for every two consecutive elements in the array, at least one of the elements is present in our subset. 

class Solution {

    public static long findMaxSubsetSum(int N, int[] A) {
        // code here
        
        
    long[][] dp = new long[N+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for (int i = 1; i <= N; i++) 
        {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = Math.max(dp[i-1][0] + A[i-1], dp[i-1][1] + A[i-1]);
        }
        
        return Math.max(dp[N][0], dp[N][1]);

    }
}
   
