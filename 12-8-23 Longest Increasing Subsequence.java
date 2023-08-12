Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
Output: 
6
Explanation:
There are more than one LIS in this array. One such Longest increasing subsequence is {0,2,6,9,13,15}.
Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output: 
3
Explanation:
There are more than one LIS in this array.  One such Longest increasing subsequence is {5,7,9}.
Your Task:
Complete the function longestSubsequence() which takes the input array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( N*log(N) )
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 104
0 ≤ A[i] ≤ 106




  class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int arr[])
    {
        // code here
           ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        int len = 1;
        for (int i = 1; i < size; i++) {
            if (arr[i] > ans.get(ans.size() - 1)) {
                ans.add(arr[i]);
                len++;
            } else {
                int indx = binarySearch(ans, arr[i]);
                ans.set(indx, arr[i]);
            }
        }
        return len;
    }
    static int binarySearch(ArrayList<Integer> ans, int key) {
        int low = 0;
        int high = ans.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ans.get(mid) == key) return mid;
            else if (ans.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + 1;
} 
}
