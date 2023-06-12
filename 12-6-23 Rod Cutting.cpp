Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by 
cutting up the rod and selling the pieces.

Note: Consider 1-based indexing.

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by 
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.
  
  
  
class Solution{
  public:
    int cutRod(int price[], int n) {
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                int x, y;
                x = y = 0;
                
                if(j - i > -1)
                    x = price[i - 1] + dp[i][j - i];
                    
                y = dp[i - 1][j];
                
                dp[i][j] = max(x, y);
            }
        }
        
        return dp[n][n];
    }
};
