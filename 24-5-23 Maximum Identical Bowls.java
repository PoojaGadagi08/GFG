There are N bowls containing cookies. In one operation, you can take one cookie from any of the non-empty bowls and put it into another bowl.
  If the bowl becomes empty you discard it. You can perform the above operation any number of times. You want to know the maximum number of bowls you can have with an identical number of cookies.

Note: All the non-discarded bowls should contain the identical number of cookies.

Example 1:

Input:
N = 3
arr[] = {3, 1, 5}
Output: 3
Explanation: We can put 2 cookies from the 3rd bowl
and put them into the 2nd bowl.Now the array
becomes {3, 3, 3}. Each bowl now contains 3 cookies.


class Solution {
    public static int getMaximum(int N, int[] arr) {
        // code here
         long sum=0;
        for(int x: arr)
        sum+=x;
        
        while(N>0){
            if(sum%N==0)
            return N;
            N--;
            
        }
        return -0;
    }
}
        
