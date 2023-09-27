Given two arrays arr and brr and a number x, find the pair whose sum is closest to x and the pair has an element from each array. 
  In the case of multiple closest pairs return any one of them. Note: The output represents the closest difference of the sum with the number x. 
  Example 1: Input : N = 4, M = 4 arr[ ] = {1, 4, 5, 7} brr[ ] = {10, 20, 30, 40} X = 32 Output : 1 Explanation: The closest pair whose sum is closest to 32 is {1, 30} = 31. 
  Example 2: Input : N = 4, M = 4 arr[ ] = {1, 4, 5, 7} brr[ ] = {10, 20, 30, 40} X = 50 Output : 3 Explanation: The closest pair whose sum is closest to 50 is {7, 40} = 47.
  Your Task: This is a function problem. The input is already taken care of by the driver code. You only need to complete the function printClosest() that takes an array (arr), another array (brr),
  size of array arr (N), size of array brr (M), and return the array of two integers whose sum is closest to X. The driver code takes care of the printing of the closest difference. 
  Expected Time Complexity: O(max(N,M)). 
  Expected Auxiliary Space: O(1). Constraints: 1 ≤ N, M ≤ 105 1 ≤ A[i], B[i] ≤ 107













  class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
        int i = 0, j = m - 1;
        int diff = Integer.MAX_VALUE;
        int a = -1, b = -1;

        while (i < n && j >= 0) {
            if (Math.abs(arr[i] + brr[j] - x) < diff) {
                diff = Math.abs(arr[i] + brr[j] - x);
                a = arr[i];
                b = brr[j];
            }

            if (arr[i] + brr[j] > x) {
                j--;
            } else {
                i++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }
}

