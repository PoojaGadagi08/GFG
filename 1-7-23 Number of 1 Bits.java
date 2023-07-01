Given a positive integer N, print count of set bits in it. 

Example 1:

Input:
N = 6
Output:
2
Explanation:
Binary representation is '110' 
So the count of the set bit is 2.
Example 2:

Input:
8
Output:
1
Explanation:
Binary representation is '1000' 
So the count of the set bit is 1.




  
// User function Template for Java
class Solution {
    static int setBits(int N) {
        // code here
        int c=0;
        for(int i=31;i>=0;i--){
            int k=N>>i;
            if((k&1)>0)
            c++;
        }
        return c;
    }
}
