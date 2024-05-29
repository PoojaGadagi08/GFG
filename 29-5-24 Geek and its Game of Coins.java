Given three numbers n, x, and y, Geek and his friend are playing a coin game. In the beginning, there are n coins. In each move, a player can pick x, y, or 1 coin. Geek always starts the game. 
  The player who picks the last coin wins the game. The task is to determine whether Geek will win the game or not if both players play optimally.

class Solution {
    public static int findWinner(int n, int x, int y) {
        // Create a DP array to store the results of subproblems
        boolean[] dp = new boolean[n + 1];
        
        // Base cases
        dp[0] = false; // If there are no coins, Geek loses
        
        // Fill the DP array for other values of n
        for (int i = 1; i <= n; i++) {
            dp[i] = !dp[i - 1] || (i - x >= 0 && !dp[i - x]) || (i - y >= 0 && !dp[i - y]);
        }
        
        // Return the result for n coins
        return dp[n] ? 1 : 0;
    }
}
