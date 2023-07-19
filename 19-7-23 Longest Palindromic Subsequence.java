Given a String, find the longest palindromic subsequence.

Example 1:

Input:
S = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the
longest subsequence which is also a palindrome.
Example 2:

Input: 
S = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are
palindromic and all have a length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPalinSubseq() which takes the string S as input and returns an integer denoting the length of the longest palindromic subsequence of S.

Expected Time Complexity: O(|S|*|S|).
Expected Auxiliary Space: O(|S|*|S|).


  
//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        int m=S.length();
        StringBuilder sb=new StringBuilder(S);
        String s1=sb.reverse().toString();
        int n=s1.length();
        
        int dp[][]=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                
                if(i==0 || j==0)
                dp[i][j]=0;
                
                else if(S.charAt(i-1)==s1.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
                
                else 
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
}
