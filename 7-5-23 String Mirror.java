// You are given a string str of length n. You want to choose a non-zero integer k (k<=n), such that you can perform the following operation:
// Take the prefix of the string of length k and append the reverse of it to itself.
// Your task is to find the lexicographically smallest string you can get.


class Solution {
    public static String stringMirror(String str) {
        // // code here
        // StringBuilder s="";
        // String ans="";
       
        // for(int i=0;i<str.length();i++){
        //     if(str.charAt(i)>str.charAt(i+1))
        //     s=new StringBuilder(str.charAt(i));
        //     s.reverse();
        //     ans=s+str;
        // }
        // return ans;
        
        StringBuilder ans=new StringBuilder();
        ans.append(str.charAt(0));
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1)>str.charAt(i) || (i>1 &&str.charAt(i-1)==str.charAt(i)))
            ans.append(str.charAt(i));
            else break;
            
        }
        
       String c=ans.toString();
       
        
        
        
        return c+ans.reverse().toString();
        
    }
}
