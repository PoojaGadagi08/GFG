

class Solution {
    public int LCS(String x, String y){
        int n=x.length();
        int m=y.length();
        
        int dp[][]=new int[n+1][m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(x.charAt(i-1) == y.charAt(j-1))
                dp[i][j]= 1 + dp[i-1][j-1];
                else 
                dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n][m];
    }
    public int findMinCost(String x, String y, int costX, int costY) {
        int lcs = LCS(x, y);
        
        if(lcs == 0)
        return x.length()*costX+y.length()*costY;
        
        return (x.length()-lcs)*costX+(y.length()-lcs)*costY;
    }
}
