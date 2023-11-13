Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
Note: X and Y can have both uppercase and lowercase letters.

Example 1

Input:
X = abcd, Y = xycd
Output: 6
Explanation: Shortest Common Supersequence
would be abxycd which is of length 6 and
has both the strings as its subsequences.
Example 2

Input:
X = efgh, Y = jghi
Output: 6
Explanation: Shortest Common Supersequence
would be ejfghi which is of length 6 and
has both the strings as its subsequences.
Your Task:
You don't have to take any input or print anything. Your task is to complete shortestCommonSupersequence() function that takes X, Y, m, and n as arguments and returns the length of the required string.

Expected Time Complexity: O(Length(X) * Length(Y)).
Expected Auxiliary Space: O(Length(X) * Length(Y)).

Constraints:
1<= |X|, |Y| <= 100

 



  //User function Template for Java

// class Solution
// {
//     //Function to find length of shortest common supersequence of two strings.
//     public static int shortestCommonSupersequence(String X,String Y,int m,int n)
//     {
//         StringBuilder sb = new StringBuilder(X);
//         sb.append(Y);

//         String str = sb.toString();

//         char[] arr = str.toCharArray();

//         HashMap<Character, Integer> h = new HashMap<>();

//         for (char ch : arr)
//             h.put(ch, h.getOrDefault(ch, 0) + 1);

//         int cnt = 0;
//         for (char ch : h.keySet()) {
//             if (h.get(ch) > 1)
//                 cnt++;
//         }

//         return arr.length - cnt;
        
//     }
// }





class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        return m+n - LCS(X,Y,m,n);
        
    }
    
    
    // Longest commom subsequesce
    public static int LCS(String X, String Y, int m, int n){
        int dp[][]=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                
                if(i==0 || j==0)
                dp[i][j]=0;
                else if(X.charAt(i-1)==Y.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
                else 
                dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}






