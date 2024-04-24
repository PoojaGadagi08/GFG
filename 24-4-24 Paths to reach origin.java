class Solution
{
    public static int ways(int n, int m)
    
    
    {
        
        int mod=1000000007;
        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n+1][m+1];
        
        // Fill the first row and first column with 1
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int j = 0; j <= m; j++)
            dp[0][j] = 1;
        
        // Fill the rest of the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] =( (dp[i - 1][j])%mod + (dp[i][j - 1])%mod)%mod;
            }
        }
        
        // Return the result which is at the bottom-right corner
        return (dp[n][m])%mod;
    
