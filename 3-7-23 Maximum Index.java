Given an array arr[] of n positive integers. The task is to find the maximum of j - i subjected to the constraint of arr[i] <= arr[j].

Example 1:

Input:
n = 9
arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output: 
6
Explanation: 
In the given array arr[1] < arr[7]  satisfying 
the required condition (arr[i] <= arr[j])  thus 
giving the maximum difference of j - i which is
6(7-1).
Example 2:

Input:
N = 2
arr[] = {18, 17}
Output: 
0
Explanation: 
We can either take i and j as 0 and 0 
or we cantake 1 and 1 both give the same result 0.



  
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
