Given a pair of strings of equal lengths, Geek wants to find the better string. The better string is the string having more number of distinct subsequences. If both the strings have equal count of distinct subsequence then return str1.

Example 1:

Input:
str1 = "gfg", str2 = "ggg"
Output: "gfg"
Explanation: "gfg" have 7 distinct subsequences whereas "ggg" have 4 distinct subsequences. 
Example 2:

Input: str1 = "a", str2 = "b"
Output: "a"
Explanation: Both the strings have only 1 distinct subsequence. 
Your Task:
You don't need to read input or print anything. Your task is to complete the function betterString() which takes str1 and str2 as input parameters and returns the better string.

Expected Time Complexity: O( max( str1.length, str2.length ) )

Expected Auxiliary Space: O( max( str1.length, str2.length ) )

Constraints:
1 <= str1.lenght , str2.length <= 30





  // User function Template for Java
// class Solution {
//     public static String betterString(String str1, String str2) {
//         // Code here
//         int a = getAllSubsequences(str1);
//         int b = getAllSubsequences(str2);
        
//         if(b>a) return str2;
//         return str1;
//     }
    
//      static int getAllSubsequences(String str) {
//         Set<String> result = new HashSet<>();
//         generateSubsequences(str, 0, "", result);
//         return result.size();
//     }

//      static void generateSubsequences(String input, int index, String current, Set<String> result) {
//         if (index == input.length()) {
//             result.add(current);
//             return;
//         }

//         // take the current character
//         generateSubsequences(input, index + 1, current + input.charAt(index), result);

//         // not take the current character
//         generateSubsequences(input, index + 1, current, result);
//     }

// }

class Solution {

    // Function to find the better string among the two input strings
    public static String betterString(String str1, String str2) {
        // Count the number of substrings of each string
        int a = countSub(str1);
        int b = countSub(str2);
        
        // Return the string with more substrings
        if (a < b) {
            return str2;
        }
        return str1;
    }
    
    
    static int countSub(String str) {
        // map to store the last occurrence of characters
      Map<Character, Integer> map = new HashMap<>();
       
        int n = str.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            
            dp[i] = 2 * dp[i - 1];

            if (map.containsKey(str.charAt(i - 1))) {
                dp[i] = dp[i] - dp[map.get(str.charAt(i - 1))];
            }
            map.put(str.charAt(i - 1), (i - 1));
        }
        return dp[n];
    }
}
