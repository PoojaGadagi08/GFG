Given two strings wild and pattern. Determine if the given two strings can be matched given that, wild string may contain * and ? but string pattern will not. * and ? can be converted to another character according to the following rules:

* --> This character in string wild can be replaced by any sequence of characters, it can also be replaced by an empty string.
? --> This character in string wild can be replaced by any one character.
Example 1:

Input: 
wild = ge*ks
pattern = geeks
Output: Yes
Explanation: Replace the '*' in wild string 
with 'e' to obtain pattern "geeks".
Example 2:

Input: 
wild = ge?ks*
pattern = geeksforgeeks
Output: Yes
Explanation: Replace '?' and '*' in wild string with
'e' and 'forgeeks' respectively to obtain pattern 
"geeksforgeeks"
Your Task:
You don't need to read input or print anything. Your task is to complete the function match() which takes the string wild and pattern as input parameters and returns true if the string wild can be made equal to the string pattern, otherwise, returns false.

Expected Time Complexity: O(length of wild string * length of pattern string)
Expected Auxiliary Space: O(length of wild string * length of pattern string)

Constraints:
1 <= length of the two string <= 10^3 





  class Solution{
    static boolean match(String wild, String pattern)
    {
        // code here
        int n=wild.length();
        int m=pattern.length();
        return go(n,m,wild,pattern);  }
    static boolean go(int n, int m, String w, String p){
        if(m==0&& n==0) return true;
        else if(m==0 || n==0) return false;
        if(w.charAt(n-1)==p.charAt(m-1)||w.charAt(n-1)=='?') return go(n-1,m-1,w,p);
        else if(w.charAt(n-1)=='*')
        return go(n-1,m-1,w,p) || go(n,m-1,w,p);
        
        else return false;
    }
}

