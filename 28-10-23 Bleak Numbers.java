Given an integer, check whether it is Bleak or not.

A number n is called Bleak if it cannot be represented as sum of a positive number x and set bit count in x, i.e., x + countSetBits(x) is not equal to n for any non-negative number x.

Example 1:

Input: 
4
Output: 
1
Explanation: 
There is no x such that x + countSetbit(x) = 4
Example 2:

Input: 
3
Output: 
0
Explanation: 
3 is a Bleak number as 2 + countSetBit(2) = 3.
Your Task:
You don't need to read or print anything. Your task is to complete the function is_bleak() which takes n as input parameter and returns 0 if n is not a Bleak number otherwise returns 1.

Expected Time Complexity: O(log(n) * log(n))
Expected Space Complexity: O(1)
 
Constraints:
1 <= n <= 109






  
//User function Template for Java

class Solution
{
    
    public int countSetBits(int n){
        int count=0;
        while(n>0){
            if((n & 1)==1)
            count++;
            n=n>>1;
        }
        return count;
    }
    
    
    public int is_bleak(int n)
    {
        // Code here
        // for(int i=1;i<n;i++){
        //     if(i + countSetBits(i) == n)
        //     return 0;
        // }
        // return 1;
        
        
    
        
         for(int i=n-30;i<=n;i++){
            if(i + countSetBits(i) == n)
            return 0;
        }
        return 1;
    }
}
