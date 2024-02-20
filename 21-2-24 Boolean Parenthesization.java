Given a boolean expression s of length n with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Note: The answer can be large, so return it with modulo 1003

Example 1:

Input: 
n = 7
s = T|T&F^T
Output: 
4
Explaination: 
The expression evaluates to true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
Example 2:

Input: 
n = 5
s = T^F|F
Output: 
2
Explaination: 
((T^F)|F) and (T^(F|F)) are the only ways.
Your Task

  
You do not need to read input or print anything. Your task is to complete the function countWays() which takes n and s as input parameters and returns number of possible ways modulo 1003.

Expected Time Complexity: O(n3)
Expected Auxiliary Space: O(n2)

Constraints:
1 ≤ n ≤ 200 


  class Solution {
    static int countWays(int N, String S) {
        int mod = 1003;
        int[][][] dp = new int[N][N][2];

        for (int gap = 0; gap < N; gap += 2) {
            for (int i = 0, j = gap; j < N; i += 2, j += 2) {
                for (int isTrue = 0; isTrue < 2; isTrue++) {
                    if (i == j) {
                        dp[i][j][isTrue] = (S.charAt(i) == 'T' && isTrue == 1) || (S.charAt(i) == 'F' && isTrue == 0) ? 1 : 0;
                    } else {
                        for (int k = i + 1; k < j; k += 2) {
                            int lt = dp[i][k - 1][1];
                            int lf = dp[i][k - 1][0];
                            int rt = dp[k + 1][j][1];
                            int rf = dp[k + 1][j][0];

                            if (S.charAt(k) == '^') {
                                dp[i][j][isTrue] += (isTrue == 1 ? lt * rf + rt * lf : lt * rt + lf * rf);
                            } else if (S.charAt(k) == '&') {
                                dp[i][j][isTrue] += (isTrue == 1 ? lt * rt : lt * rf + rt * lf + lf * rf);
                            } else if (S.charAt(k) == '|') {
                                dp[i][j][isTrue] += (isTrue == 1 ? lt * rf + rt * lf + lt * rt : lf * rf);
                            }

                            dp[i][j][isTrue] %= mod;
                        }
                    }
                }
            }
        }

        return dp[0][N - 1][1];
    }
}

