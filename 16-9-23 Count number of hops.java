A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top of Nth step. As the answer will be large find the answer modulo 1000000007.

Example 1:

Input:
N = 1
Output: 1
Example 2:

Input:
N = 4
Output: 7
Explanation:Below are the 7 ways to reach
4
1 step + 1 step + 1 step + 1 step
1 step + 2 step + 1 step
2 step + 1 step + 1 step
1 step + 1 step + 2 step
2 step + 2 step
3 step + 1 step
1 step + 3 step
Your Task:
Your task is to complete the function countWays() which takes 1 argument(N) and returns the answer%(10^9 + 7).

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 105




  class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        // add your code here
         int mod=1000000007;
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;
        
        long[] dp= new long[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        
            for(int i=4;i<=n;i++){
                dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%mod;
            }
            return dp[n]%mod;
    }
}
