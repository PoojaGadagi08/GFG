

class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        int[][][] dp = new int[n1][n2][n3];
        
        for(int[][] mat : dp)
              for(int[] row : mat)
                   Arrays.fill(row, -1);
        
        
        return helper(A, B, C, n1-1, n2-1, n3-1, dp);
        
    }
    
    private int helper(String A, String B, String C, int n1, int n2, int n3, int[][][] dp) {
        
        if(n1<0 || n2<0 || n3<0)
            return 0;
        
        if(dp[n1][n2][n3]!=-1)
           return dp[n1][n2][n3];
        
        if(A.charAt(n1)==B.charAt(n2) && B.charAt(n2)==C.charAt(n3))
             return dp[n1][n2][n3] = 1+helper(A, B, C, n1-1, n2-1, n3-1, dp);
        
        else
         return dp[n1][n2][n3] = Math.max(helper(A, B, C, n1-1, n2, n3, dp), Math.max(helper(A, B, C, n1, n2-1, n3, dp), Math.max(helper(A, B, C, n1, n2, n3-1, dp), 
                                                  Math.max(helper(A, B, C, n1-1, n2-1, n3, dp), Math.max(helper(A, B, C, n1, n2-1, n3-1, dp), helper(A, B, C, n1-1, n2, n3-1, dp))))));
         
    }
}
 
