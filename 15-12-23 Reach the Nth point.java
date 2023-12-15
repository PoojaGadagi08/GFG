There are N points on the road, you can step ahead by 1 or 2 . If you start from a point 0, and can only move from point i to point i+1 after taking a step of length one, find the number of ways you can reach at point N. 

Example 1:

Input: 
N = 4
Output: 
5
Explanation: Three ways to reach at 4th
point. They are {1, 1, 1, 1}, {1, 1, 2},
{1, 2, 1} {2, 1, 1}, {2, 2}.

Example 2:

Input: N = 5
Output: 8
Explanation: Three ways to reach at 5th
point. They are {1, 1, 1, 1, 1},
{1, 1, 1, 2}, {1, 1, 2, 1}, {1, 2, 1, 1},
{2, 1, 1, 1}{1, 2, 2}, {2, 1, 2}, {2, 2, 1}
Your Task:
You don't need to read or print anyhting. Your task is to complete the function nthPoint() which takes N as input parameter and returns the total number of ways modulo 109 + 7 to reach at Nth point.

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)

Constraints:
1 ≤ N ≤ 105




  //User function Template for Java

// class Solution
// {
//     public int nthPoint(int n)
//     {
//         // Code here
//         int dp[]=new int[n+1];
//         dp[0]=1;
//         dp[1]=1;
//         dp[2]=2;
//         dp[3]=3;
        
//         for(int i=4;i<=n;i++){
//             dp[i]=dp[i-1]+dp[i-2];
//         }
        
//         return dp[n];
//     }
// }



class Solution
{
    public int nthPoint(int n)
    {
        // Code here
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n,int[] dp){
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n]!=-1) return dp[n];
        int one = solve(n-1,dp);
        int two = solve(n-2,dp);
        return dp[n] = (one+two)%1000000007;
    }
}

