Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of distinct combinations to reach the given score.

Example 1:

Input
n = 10
Output
2
Explanation
There are two ways {5,5} and {10}.
Example 2:

Input
n = 20
Output
4
Explanation
There are four possible ways. {5,5,5,5}, {3,3,3,3,3,5}, {10,10}, {5,5,10}.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function count( ) which takes n as input parameter and returns the answer to the problem.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:

1 ≤ n ≤ 106



  public long count(int n) {
        int coins[] = {3,5,10};
        long dp[] = new long[n+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++)
            for(int j=coins[i];j<=n;j++)
                dp[j] = dp[j] + dp[j-coins[i]];
        return dp[n];
    }
