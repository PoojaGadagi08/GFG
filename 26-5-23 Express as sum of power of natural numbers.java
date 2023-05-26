Given two numbers n and x, find out the total number of ways n can be expressed as the sum of the Xth power of unique natural numbers.
  As the total number of ways can be very large, so return the number of ways modulo 109 + 7. 

Example 1:

Input: 
n = 10, x = 2
Output: 
1 
Explanation: 
10 = 12 + 32, Hence total 1 possibility. 
  
  class Solution
{
    static final int mod = 1000000007;

    static int numOfWays(int n, int x)
    {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i<=n;i++) 
        {
            int curr = (int) Math.pow(i, x);
           if(curr<=n)  al.add(curr); 
           else break;
            
        }
        //dp[n+1][n+1]
          int[][] dp = new int[n + 1][n + 1];
        for (int y[] :dp)
        Arrays.fill(y,-1);
        
        return help(al,0,n,al.size(),dp);
    }
    static int help(ArrayList<Integer> al, int i, int n, int size, int dp[][])
    {
        if(n<0)
        return 0;
        
        if(i==size)
        {
            if(n==0) return dp[i][n]=1;
            else return   dp[i][n]=0;
        }
        if(dp[i][n]!=-1) return dp[i][n];
        
        return dp[i][n] = ( help(al, i+1, n, size,dp)%mod +  help(al, i+1, n-al.get(i),size,dp)%mod)%mod;

    }
}
