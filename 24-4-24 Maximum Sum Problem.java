A number n can be broken into three parts n/2, n/3, and n/4 (consider only the integer part). Each number obtained in this process can be divided further recursively. Find the maximum sum that can be obtained by summing up the divided parts together.
Note: It is possible that we don't divide the number at all.

Example 1:

Input:
n = 12
Output: 
13
Explanation: 
Break n = 12 in three parts {12/2, 12/3, 12/4} = {6, 4, 3}, now current sum is = (6 + 4 + 3) = 13. Further breaking 6, 4 and 3 into parts will produce sum less than or equal to 6, 4 and 3 respectively.
Example 2:

Input:
n = 24
Output: 
27
Explanation: 
Break n = 24 in three parts {24/2, 24/3, 24/4} = {12, 8, 6}, now current sum is = (12 + 8 + 6) = 26 . But recursively breaking 12 would produce value 13. So our maximum sum is 13 + 8 + 6 = 27.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxSum() which accepts an integer n and returns the maximum sum.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
0 <= n <= 106



  public int solveTab(int n)
    {
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int val1=dp[i/2];
            int val2=dp[i/3];
            int val3=dp[i/4];
            
            dp[i]=Math.max(i,val1+val2+val3);
        }
        return dp[n];
    }
    
    public int maxSum(int n) 
    { 
        if(n==0)
            return 0;
        // return solveRec(n);
        //int dp[]=new int[n+1];
        //Arrays.fill(dp,-1);
        // return solveMem(n,dp);
        
        return solveTab(n);
    } 
}

