As the clock struck midnight on New Year's Eve, Geek bid farewell to the wasted moments of 2023, realizing the untapped potential of GFG's Problem of the Day.

His 2024 resolution: Solve POTD every day.

Eager to earn coins for GFG Merchandise, Geek faces new rules:

Earning Coin: Geek can accumulate coins[i] by solving the POTD on the ith day, where 1 <= coins[i] <= 2024 and the sum of coins <= 2024.
Merchandise Eligibility: To purchase merchandise, the coins earned must be divisible by 20 or 24, or precisely equal to 2024.
Geek's resolutions often fades over time. Realistically, he can only commit to active participation for N (where N ≤ 366) days. Given the value of N and number of coins associated with each POTD, can Geek strategically solve some (or all) POTDs to become eligible for redeeming merchandise?

Example 1:

Input:
N = 8
coins = [5, 8, 9, 10, 14, 2, 3, 5]

Output: 1

Explanation:
Geek can fulfill the criteria in many ways.
One such way is to solve POTD on 4th and 5th day.
Another way is to solve POTD on 1st, 4th and 8th day.
Example 2:

Input:
N = 5
coins = [1, 2, 3, 4, 5]

Output: 0

Explanation: There is no way Geek can become eligible.
Your Task: 
You don't need to read input or print anything. Complete the function isPossible() which takes n and coins[ ] as input parameters and returns a boolean value.

Expected Time Complexity: O(N*(Sum of coins))
Expected Auxiliary Space: O(N*(Sum of coins))

Constraints:
1 <= N <= 366
1 <= coins[i] <= 2024
1 <= Sum of coins <=  2024




  class Solution {
    public static boolean isPossible(int N, int[] coins) {
        // code here
        if(N==1){
            if(coins[0]==2024 || coins[0]%20==0 || coins[0]%24==0)return true;
            return false;
        }
        boolean[][] dp = new boolean[N+1][2025];
        for(int i=0;i<=N;i++){
            dp[i][0]=true;
        }
        for(int j=1;j<=N;j++){
            for(int i=1;i<2025;i++){
              if(coins[j-1]>i){
                  dp[j][i]=dp[j-1][i];
              }else if(dp[j-1][i] || dp[j-1][i-coins[j-1]]){
                  dp[j][i]=true;
              }
              if(dp[j][i] && (i%20==0 || i%24==0))return true;
            }
        }
        return dp[N][2024];
    }
}

