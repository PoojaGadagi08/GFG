Given two strings, find the length of longest subsequence present in both of them. Both the strings are in uppercase latin alphabets.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input strings “ABCDGH” and “AEDFHR” is “ADH” of length 3.
Example 2:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is "AC" of length 2.
Your Task:
Complete the function lcs() which takes the length of two strings respectively and two strings as input parameters and returns the length of the longest subsequence present in both of them.

Expected Time Complexity : O(|str1|*|str2|)
Expected Auxiliary Space: O(|str1|*|str2|)

Constraints:
1<=size(str1),size(str2)<=103




  

class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int m, int n, String s1, String s2)
    {
        // your code here
       int  dp[][]=new int[m+1][n+1];
       
       for(int i=0;i<=m;i++){
           for(int j=0;j<=n;j++){
               
               if(i==0 || j==0)
               dp[i][j]=0;
               
               else if(s1.charAt(i-1)==s2.charAt(j-1))
               dp[i][j]=1+dp[i-1][j-1];
               
               else 
               dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
           }
       }
       return dp[m][n];
    }
    
}
