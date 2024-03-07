Given a string s of length n, find the longest repeating non-overlapping substring in it. In other words find 2 identical substrings of maximum length which do not overlap. Return the longest non-overlapping substring. Return "-1" if no such string exists.

Note: Multiple Answers are possible but you have to return the substring whose first occurrence is earlier.

For Example: "abhihiab", here both "ab" and "hi" are possible answers. But you will have to return "ab" because it's first occurrence appears before the first occurrence of "hi".

Example 1:

Input:
n = 9
s = "acdcdacdc"
Output:
"acdc"
Explanation:
The string "acdc" is the longest Substring of s which is repeating but not overlapping.
Example 2:

Input:
n = 7
s = "heheheh"
Output:
"heh"
Explanation:
The string "heh" is the longest Substring of s which is repeating but not overlapping.
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestSubstring() which takes an Integer n and a string s as input and returns the answer.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

Constraints:
1 <= n <= 103



  
//User function Template for Java

// class Solution {
//     static String longestSubstring(String s, int n) {
//         // code here
//         int dp[][] = new int[n][n];
        
//         int maxLen = 0;
//         int ind = 0;
        
//         for (int i = 1; i <= n; i++) {
//             for (int j = i + 1; j <= n; j++) {
//                 if (j - i > dp[i - 1][j - 1] && s.charAt(i) == s.charAt(j)) {
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
                    
//                     if (dp[i][j] > maxLen) {
//                         maxLen = dp[i][j];
//                         ind = Math.max(ind, i);
//                     }
//                 } else {
//                     dp[i][j] = 0;
//                 }
//             }
//         }
        
//         String res = "";
//         if (maxLen > 0) {
//             for (int i = ind - maxLen+1; i <= ind; i++)
//                 res += s.charAt(i-1);
//         }
//         if (res.equals(""))
//             return "-1";
        
//         return res;
//     }
// };





class Solution {
    static String longestSubstring(String s, int n) {
        String res = "";
        int i=0, j=0;
        
        while(j < n && i < n) {
            String str = s.substring(i, j+1);
            if(s.substring(j+1, n).indexOf(str) != -1) 
                res = res.length() < (j-i+1) ? str : res;
            else
                i++;
            j++;
        }
        return res == "" ? "-1" : res;
    }
};
