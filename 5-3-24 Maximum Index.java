Given an array a of n positive integers. The task is to find the maximum of j - i subjected to the constraint of a[i] < a[j] and i < j.

Example 1:

Input:
n = 2
a[] = {1, 10}
Output:
1
Explanation:
a[0] < a[1] so (j-i) is 1-0 = 1.
Example 2:

Input:
n = 9
a[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output:
6
Explanation:
In the given array a[1] < a[7] satisfying the required condition(a[i] < a[j]) thus giving the maximum difference of j - i which is 6(7-1).
Your Task:
The task is to complete the function maxIndexDiff() which finds and returns maximum index difference. Printing the output will be handled by driver code. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ n ≤ 106
0 ≤ a[i] ≤ 109



  class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
 int right[] = new int[n]; //max, j
        int left[] = new int[n];//min, i
        left[0] = arr[0];  right[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) 
        left[i] = Math.min(arr[i], left[i - 1]);

        for (int j = n - 2; j >= 0; j--)
            right[j] = Math.max(arr[j], right[j + 1]);

        int i = 0, j = 0, ans = Integer.MIN_VALUE;
        while (j < n && i < n) 
        {
            if (left[i] <= right[j]) 
            {
                ans = Math.max(ans, j - i);
                j++;
            } 
            else
                i++;
        }
        return ans;

        
    }
}
