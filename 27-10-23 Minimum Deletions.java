Given a string of S as input. Your task is to write a program to delete the minimum number of characters from the string so that the resultant string is a palindrome.
Note: The order of characters in the string should be maintained.

Example 1:

Input: 
S = "aebcbda"
Output: 
2
Explanation: 
Remove characters 'e' and 'd'.
Example 2:

Input: 
S = "geeksforgeeks"
Output: 
8
Explanation: 
One of the possible result string can be "eefee", so answer is 13 - 5 = 8.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function minimumNumberOfDeletions() which takes the string S as inputs and returns the minimum number of deletions required to convert S into a pallindrome.

Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(|S|2)

Constraints:
1 ≤ |S| ≤ 103



  //User function Template for Java

//class Solution{
//      static int[][] memo; //since i and j are changing -that's y 2d
//     static int minimumNumberOfDeletions(String S) {
//         //your code here
//         int n =S.length();
//          memo = new int[n][n];
//         for (int i = 0; i < n; i++) 
//             Arrays.fill(memo[i], -1); // Initialize with -1 to indicate uncalculated values

//         return fun(S, 0, n- 1);
//     }
//       static int fun(String S, int i, int j) {
//         if (i >= j) {
//             return 0;
//         }
//          if (memo[i][j] != -1) 
//             return memo[i][j]; 
        
//         // int ans;
//         if (S.charAt(i) == S.charAt(j)) {
//             return memo[i][j] = fun(S, i + 1, j - 1);
//         }

//         return memo[i][j] = 1 + Math.min(fun(S, i + 1, j), fun(S, i, j - 1));
//     }

// }
class Solution{
     static int minimumNumberOfDeletions(String S) {
         int len = longestPalinSubseq(S);
         return S.length()-len;
     }
    static int longestPalinSubseq(String S)
    {
        StringBuilder str = new StringBuilder(S);
        String s1 = S;
        String s2 = str.reverse().toString();
        int n = S.length();
        int dp[][] = new int[n+1][n+1];
        
        
        for( int i =0 ; i<=n ;i++)
        {
            for( int j =0; j<=n;j++)
            {
                if(i==0 || j==0)
                dp[i][j] =0; 
                
               else if( s1.charAt(i-1)==s2.charAt(j-1) )
                    dp[i][j] = 1+dp[i-1][j-1];  
                    
                else
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        
        return dp[n][n];
    }
}
