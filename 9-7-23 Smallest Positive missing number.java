You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.

Example 1:

Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.
Example 2:

Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing 
number is 2.
Your Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
-106 <= arr[i] <= 106




  class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int A[], int n)
    {
        // Your code here
        // boolean vis[]=new boolean[n+1];
        // for(int i=0;i<n;i++){
        
        //     if(arr[i]>0 && arr[i]<=n)
        //     vis[arr[i]]=true;
        // }
        
        // for(int i=1;i<=n;i++){
        //     if(!vis[i])
        //     return i;
        // }
        // return n+1;
        
        
        
        // 2nd
        // go the every no >0 && <=n  and mark with -ve sign
        
        // if suppose the element we want to find is present in arr then we have gone to that index and marked it 
        // with -ve sign 
        // But that is element is not present and we have not gone to that index so the ans is that index
        
        
          for(int i = 0; i < n; ++ i) {
            while(A[i] >= 1 && A[i] <= n && A[i] != A[A[i]-1])
                // swap(A[i], A[A[i] - 1]);
                {
                    int t = A[A[i] - 1]; A[A[i] - 1] = A[i];  A[i]=t;
                }
        }
        
        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;
        
        return n + 1;
      
    }
}
