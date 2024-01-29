Given a string str consisting of digits, you can divide it into sub-groups by separating the string into substrings. For example, "112" can be divided as {"1", "1", "2"}, {"11", "2"}, {"1", "12"}, and {"112"}.

A valid grouping can be done if you are able to divide sub-groups where the sum of digits in a sub-group is less than or equal to the sum of the digits of the sub-group immediately right to it. Your task is to determine the total number of valid groupings that could be done for a given string.

Example 1: 

Input: 
str = "1119"
Output: 
7
Explanation: 
One valid grouping is {"1", "11", "9"}.
Sum of digits of first sub-group ("1") is 1,
for the second sub-group ("11"), it is 2,
and for the third one ("9"), it is 9.
As the sum of digits of the sub-groups is 
in increasing order, it forms a valid grouping.
Other valid grouping are {"1", "119"}, {"1","1","19"}, 
{"1","1","1","9"}, {"11","19"}, {"111","9"} and {"1119"}
are six other valid groupings.
Example 2:

Input: 
str = "12"
Output: 
2
Explanation: 
{"1","2"} and {"12"} are two valid groupings.
Your Task:
You don't need to read or print anything. Your task is to complete the function TotalCount() which takes the string str as input parameter and returns total possible groupings.

Expected Time Complexity: O(N3) where N is the length of the string.
Expected Space Complexity: O(N2)

Constraints:
1 <= N <= 100
stri ∈ {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}



class Solution
{
    public int TotalCount(String str)
    {
        // Code here
          int i,j,sum=0,ans =1,n = str.length();
       int[][] sums = new int[n][n];
       
       for(i=0;i<n;i++){
           for(j=i;j<n;j++){
               if(i==j)
                   sums[i][j] = str.charAt(j)-'0';
               else
                   sums[i][j] = sums[i][j-1]+ (str.charAt(j)-'0');
           }
       }
       
       int[][] dp = new int[n][n];
       
       Arrays.fill(dp[0],1);
       for(i=1;i<n;i++){
           for(j=i;j<n;j++){
               for(int k=0;k<=i-1;k++){
                   if(sums[k][i-1] <= sums[i][j])
                       dp[i][j] += dp[k][i-1]; 
               }
               
           }
           ans += dp[i][n-1];
       }
       
       return ans;
    }
}
