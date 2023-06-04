Given a mathematical equation that contains only numbers and +, -, *, /. Print the equation in reverse, such that the equation is reversed, but the numbers remain the same.
It is guaranteed that the given equation is valid, and there are no leading zeros.

Example 1:

Input:
S = "20-3+5*2"
Output: 2*5+3-20
Explanation: The equation is reversed with
numbers remaining the same.
  
  
  //User function Template for Java
class Solution
{
   String reverseEqn(String S)
    {
        // your code here
        char s[] = S.toCharArray();
        int n = S.length();
        for(int i=0;i<n/2;i++){
            char temp = s[i];
            s[i]=s[n-1-i];
            s[n-i-1]=temp;
        }
        int prev=0;
        for(int i=0;i<n;i++){
            if(s[i]=='+' || s[i]=='-' || s[i]=='/' || s[i]=='*'){
                int j=i-1;
                while(prev<j){
                    char temp = s[prev];
                    s[prev] = s[j];
                    s[j] = temp;
                    j--;
                    prev++;
                }
                prev=i+1;
            }
        }
        int j=n-1;
        while(prev<j){
            char temp = s[prev];
            s[prev] = s[j];
            s[j] = temp;
            j--;
            prev++;
        }
        S = new String(s);
        return S;
    }
    
}
