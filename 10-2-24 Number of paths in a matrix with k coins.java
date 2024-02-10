class Solution {
    
    static int numberOfPathsWithKCoins = 0;
    static long dp[][][];
    
    long numberOfPath(int n, int k, int [][]arr) {
        // code here

        dp = new long[n][n][k+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                for(int l=0;l<=k;l++)
                  dp[i][j][l]=-1;
                  
        return dfs(0, 0, n, k, 0, arr);
    }
    
    long dfs(int i, int j, int n, int k, int currentCoins, int arr[][]) {
        
        if(i < 0 || i >=n || j < 0 || j >= n || currentCoins+arr[i][j] > k) return 0;
        
        if(currentCoins+arr[i][j] == k && i == n-1 && j == n-1) {
            //System.out.println(currentCoins);
            return 1;
        }
        
        if(dp[i][j][currentCoins] != -1) return dp[i][j][currentCoins];
        
        dp[i][j][currentCoins] = dfs(i+1, j, n, k, currentCoins + arr[i][j], arr) 
            + dfs(i, j+1, n, k, currentCoins + arr[i][j], arr);
        return dp[i][j][currentCoins];
    }
}
