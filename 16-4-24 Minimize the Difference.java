You are given an array arr of size n. You have to remove a subarray of size k , such that the difference between the maximum and minimum values of the remaining array is minimized.
Find the minimum value obtained after performing the operation of the removal of the subarray and return it.

Example 1:

Input:
n = 5
k = 3
arr = {1, 2, 3, 4, 5}
Output: 
1
Explanation: 
We can remove first subarray of length 3(i.e. {1, 2, 3}) then remaining array will be {4,5} and the difference of maximum and minimum element will be 1 i.e 5 - 4 = 1
Example 2:

Input:
n = 6
k = 3
arr = {2, 3, 1, 4, 6, 7}
Output: 
2
Explanation:
If we remove the subarray {2,3,1} then remaining array will be {4,6,7} and the difference  = 7-4 = 3
If we remove the subarray {3,1,4} then remaining array will be {2,6,7} and the difference  = 7-2 = 5
If we remove the subarray {1,4,6} then remaining array will be {2,3,7} and the difference  = 7-2 = 5
If we remove the subarray {4,6,7} then remaining array will be {2,3,1} and the difference  = 3-1 = 2
So the answer will be min(3,5,5,2) = 2
Your Task: 
You have to complete the function minimizeDifference( ), which takes two integers n and k and an integer array arr of size n. You have to return the minimum difference of maximum and minimum elements of the remaining array after removing one k length subarray of it.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
2 <= n <= 105
1 <= k <= n-1
0 <= arr[i] <= 109

  class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        int[] maxSuff=new int[n+1];
        int[] minSuff=new int[n+1];
        maxSuff[n]=Integer.MIN_VALUE; 
        minSuff[n]=Integer.MAX_VALUE; 
        maxSuff[n-1]=arr[n-1];
        minSuff[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            maxSuff[i]=Math.max(maxSuff[i+1],arr[i]);
            minSuff[i]=Math.min(minSuff[i+1],arr[i]);
        }
        int mindiff=maxSuff[k]-minSuff[k]; //aditya
        int minPre=arr[0];
        int maxPre=arr[0];
        for(int i=1;i<n;i++){
            if(i+k<=n){
            int maxi=Math.max(maxSuff[i+k],maxPre);
            int mini=Math.min(minSuff[i+k],minPre);
            mindiff=Math.min(mindiff,maxi-mini);
            }
            minPre=Math.min(minPre,arr[i]);
            maxPre=Math.max(maxPre,arr[i]);
        }
        return mindiff;
    }
}
