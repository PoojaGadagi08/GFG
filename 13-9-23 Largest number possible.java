Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'. Return -1 if it is not possible.

Example 1:

Input: N = 2, S = 9
Output: 90
Explaination: It is the biggest number 
with sum of digits equals to 9.
Example 2:

Input: N = 3, S = 20
Output: 992
Explaination: It is the biggest number 
with sum of digits equals to 20.
Your Task:
You do not need to read input or print anything. Your task is to complete the function findLargest() which takes N and S as input parameters and returns the largest possible number. Return -1 if no such number is possible.

Expected Time Complexity: O(N)
Exepcted Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 104
0 ≤ S ≤ 105







  //User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
        
        // this will give TLE
        // Our ans is immmutable
        // "abcd"+"e"-->4+1=5
        // N=10^4
        // 1+2+3........10^4
        // n(n-1)/2         10^4(10^4-1)/2      hits the TLE
        
        
        // So use StringBuilder bcauze it will take O(1) TC for appending 
        
        // String ans="";
        // if(S==0 && N>1)
        // return "-1";
        
        // for(int i=0;i<N;i++){
        //     if(S>=9){
        //         ans+=9;
        //         S-=9;
        //     }
        //     else{
        //         ans+=(char)(S+48);
        //         S=0;
        //     }
        // }
        // if(S>0)
        // return "-1";
        
        // return ans.toString();
        
        
        
        
         StringBuilder  ans=new StringBuilder();
        if(S==0 && N>1)
        return "-1";
        
        for(int i=0;i<N;i++){
            if(S>=9){
                ans.append('9');
                S-=9;
            }
            else{
                ans.append((char)(S+48));
                S=0;
            }
        }
        if(S>0)
        return "-1";
        
        return ans.toString();
    }
}
