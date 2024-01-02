Given an array a of length n and a number k, find the largest sum of the subarray containing at least k numbers. It is guaranteed that the size of array is at-least k.

Example 1:

Input : 
n = 4
a[] = {1, -2, 2, -3}
k = 2
Output : 
1
Explanation :
The sub-array of length at-least 2
that produces greatest sum is {1, -2}
Example 2:
Input :
n = 6 
a[] = {1, 1, 1, 1, 1, 1}
k = 2
Output : 
6
Explanation :
The sub-array of length at-least 2
that produces greatest sum is {1, 1, 1, 1, 1, 1}
Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxSumWithK() which takes the array a[], its size n and an integer k as inputs and returns the value of the largest sum of the subarray containing at least k numbers.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 105
-105 <= a[i] <= 105
1 <= k <= n



  
//User function Template for Java


class Compute {
    
    // public long maxSumWithK(long nums[], long n, long k) {
    //     // Calculate the initial sum of the first k elements
    //     long currentSum = 0;
    //     for (int i = 0; i < k; i++) {
    //         currentSum += nums[i];
    //     }

    //     // Initialize maxSum with the sum of the first k elements
    //     long maxSum = currentSum;

    //     // Iterate through the array using the sliding window technique
    //     for (int i = (int) k; i < n; i++) {
    //         // Add the current element to the window
    //         currentSum += nums[i];
    //         // Subtract the element at the beginning of the window
    //         currentSum -= nums[i - (int) k];

    //         // Update maxSum if currentSum is greater
    //         maxSum = Math.max(maxSum, currentSum);
    //     }

    //     return maxSum;
    // }
    
    
    
    public long maxSumWithK(long arr[], long N, long K) {
        
        long kWinSum=0;
        for(int i=0; i<K; i++) {
            kWinSum += arr[i];
        }
        // Now apply Kadane algorithm on at least K numbers.
        long currSum=kWinSum;
        long maxSum=kWinSum;
        // jth element will be added in k sum window.
        // kadane - either extend curr sum or start a new K numbers window sum.
        for(int j=(int)K, i=0; j<N; j++,i++) {
            
            kWinSum = kWinSum + arr[j] - arr[i];
            currSum = Math.max(kWinSum, currSum+arr[j]); // extend or start a new window.
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;

}


}
