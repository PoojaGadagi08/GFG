Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S).
  Palindrome string: A string that reads the same backward. More formally, S is a palindrome if reverse(S) = S. In case of conflict,
return the substring which occurs first ( with the least starting index).

Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".
  
  
  


//User function Template for Java

class Solution{
    //static String longestPalin(String S){
        // code here
    //     int len=0;
    //     String ans="";
    //     for(int i=0;i<S.length();i++){
    //         StringBuilder sb=new StringBuilder();
    //         for(int j=i;j<S.length();j++){
    //             sb.append(S.charAt(j));
    //             if(palin(sb.toString())){
    //                 if(sb.length()>len){
    //                     ans=sb.toString();
    //                     len=sb.length();
    //                 }
    //             }
    //         }
    //     }
    //     return ans;
    // }
    
    // static boolean palin(String s){
    //     int i=0;
    //     int j=s.length()-1;
    //     while(i<j){
    //         if(s.charAt(i)==s.charAt(j)){
    //             i++;
    //             j--;
                
    //         }
    //          else return false;
    //     }
    //     return true;
    
    
    
    //}
     static String longestPalin(String s){
        // code here
        int n=s.length();
        // char ar[] = S.toCharArray();
        int len=0;
        String ans="";
        for(int i=0; i<n; i++)
        {
             String curr = help(s,i,i); //odd
             if(curr.length() > len)
             {
                 ans=curr;
                 len = curr.length();
             }
             
             curr = help(s,i,i+1); //even
             if(curr.length() > len)
             {
                 ans=curr;
                 len = curr.length();
             }
        }
        return ans;
    }
    static String help(String s, int st, int end)
    {
        int n=s.length();
        while(st>=0 && end<n)
        {
            if(s.charAt(st) == s.charAt(end))
            {
                st--; end++;
            }
            else break;
            
        }
        return s.substring(st+1, end);
    }
}
