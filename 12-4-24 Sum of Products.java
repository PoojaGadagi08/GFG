Given an array arr[] of size n. Calculate the sum of Bitwise ANDs ie: calculate sum of arr[i] & arr[j] for all the pairs in the given array arr[] where i < j.

Example 1:

Input:
n = 3
arr = {5, 10, 15}
Output:
15
Explanation:
The bitwise Ands of all pairs where i<j are (5&10) = 0, (5&15) = 5 and (10&15) = 10.
Therefore, the total sum = (0+5+10) = 15.
Example 2:

Input:
n = 4
arr = {10, 20, 30, 40}
Output:
46
Explanation:
The sum of bitwise Ands 
of all pairs = (0+10+8+20+0+8) = 46.
Your Task:
You don't need to read input or print anything.Your Task is to complete the function pairAndSum() which takes an Integer n and an array arr[]  of size n as input parameters and returns the sum of bitwise Ands of all pairs.

Expected Time Complexity:O(n)
Expected Auxillary Space:O(1)

Constraints:
1 <= n <= 105
1 <= arr[i] <= 108



  class Solution {
    static long pairAndSum(int n, long arr[]) {
        long sum=0; int k=1;
        for(int i=0; i<32; i++){
            long c=0;        
            for(int j=0; j<n; j++){
                if((arr[j]&1)!=0){
                    c++;
                }
                arr[j]>>=1;
            }
            long num = (c*(c-1))/2; 
            sum+= num*k;    
            k<<=1;
        }
        return sum;
    }
}
