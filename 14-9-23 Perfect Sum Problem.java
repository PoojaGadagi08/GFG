Given an array arr[] of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7

Example 1:

Input: N = 6, arr[] = {2, 3, 5, 6, 8, 10}
       sum = 10
Output: 3
Explanation: {2, 3, 5}, {2, 8}, {10} are 
possible subsets.
Example 2:
Input: N = 5, arr[] = {1, 2, 3, 4, 5}
       sum = 10
Output: 3
Explanation: {1, 2, 3, 4}, {1, 4, 5}, 
{2, 3, 5} are possible subsets.
Your Task:  
You don't need to read input or print anything. Complete the function perfectSum() which takes N, array arr[] and sum as input parameters and returns an integer value

Expected Time Complexity: O(N*sum)
Expected Auxiliary Space: O(N*sum)

Constraints:
1 ≤ N*sum ≤ 106
0<=arr[I]<=106




  class Solution{

	 public int perfectSum(int arr[],int n, int sum) 
    { 
        // Your code goes here
        int mod=(int)1e9+7;
        int zero=1;
        int [][] dp=new int[n][sum+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=1;
            if(arr[0]==0)zero=2;
            
        }
        if(arr[0]<=sum)
            dp[0][arr[0]]=1;
       
        
        for(int j=1;j<n;j++)
        {
            for(int t=0;t<=sum;t++)
            {
                int np=dp[j-1][t];
                int p=0;
                if(arr[j]<=t)
                    p=dp[j-1][t-arr[j]];
               dp[j][t]=(p+np)%mod;
                
            }
        }
        return dp[n-1][sum]*zero%mod;
    }
}
