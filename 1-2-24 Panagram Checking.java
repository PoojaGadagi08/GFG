Given a string s check if it is "Panagram" or not.

A "Panagram" is a sentence containing every letter in the English Alphabet.

Example 1:

Input:
s = "Bawds jog, flick quartz, vex nymph"
Output: 
1
Explanation: 
In the given input, there
are all the letters of the English
alphabet. Hence, the output is 1.
Example 2:

Input:
s = "sdfs"
Output: 
0
Explanation: 
In the given input, there
aren't all the letters present in the
English alphabet. Hence, the output
is 0.
Your Task:
You do not have to take any input or print anything. You need to complete the function checkPangram() that takes a string as a parameter and returns true if the string is a Panagram, or else it returns false.

Expected Time Complexity: O( |s| )
Expected Auxiliary Space: O(1)
|s| denotes the length of the input string.

Constraints:
1 ≤ |s| ≤ 104
Both Uppercase & Lowercase are considerable




  
class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        // int cnt=0;
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <='Z')
        //     cnt++;
        // }
        
        // if(cnt==26)
        // return true;
        
        // return false;
        
        // HashMap<Character, Integer> h =new HashMap<>();
        // for(char x : s.toCharArray())
        // h.put(x, h.getOrDefault(x, 0)+1);
        
        // if(h.size()==26)
        // return true;
        
        // return false;
        
        if(s.length() < 26)
        return false;
        
        s=s.toLowerCase();
        boolean[] visit =new boolean[26];
        int cnt=0;
        for(int i = 0; i<s.length(); i++){
            
            if((s.charAt(i)-'a')>26 || (s.charAt(i)-'a')<0) continue;
            if(!visit[s.charAt(i)-'a']){
                cnt++;
                visit[s.charAt(i)-'a'] = true;
            }
        }
                return (cnt==26)?true:false;

    }
}
