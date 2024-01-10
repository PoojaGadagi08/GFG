Given an array arr containing N integers and a positive integer K, find the length of the longest sub array with sum of the elements divisible by the given value K.

Example 1:

Input:
N = 6, K = 3
arr[] = {2, 7, 6, 1, 4, 5}
Output: 
4
Explanation:
The subarray is {7, 6, 1, 4} with sum 18, which is divisible by 3.
Example 2:

Input:
N = 7, K = 3
arr[] = {-2, 2, -5, 12, -11, -1, 7}
Output: 
5
Explanation:
The subarray is {2,-5,12,-11,-1} with sum -3, which is divisible by 3.
Your Task:
The input is already taken care of by the driver code. You only need to complete the function longSubarrWthSumDivByK() that takes an array arr, sizeOfArray n and a  positive integer K, and returns the length of the longest subarray which has sum divisible by K. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
1 <= K <= 109
-109 <= A[i] <= 109 





  
class Solution{
    int longSubarrWthSumDivByK(int nums[], int n, int k)
    {
        // Complete the function
        //int n = nums.length;
        int maxLength = 0;
        int currentSum = 0;

        // Create a HashMap to store the remainder of the cumulative sum and its corresponding index
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // Initialize with 0 remainder at index -1

        for (int i = 0; i < n; i++) {
            currentSum += nums[i];

            int currentRemainder = currentSum % k;
            if (currentRemainder < 0) {
                // If currentRemainder becomes negative, convert it to a positive remainder
                currentRemainder += k;
            }

            if (remainderMap.containsKey(currentRemainder)) {
                // If the current remainder is already in the map, update maxLength
                maxLength = Math.max(maxLength, i - remainderMap.get(currentRemainder));
            } else {
                // If the current remainder is not in the map, add it with the current index
                remainderMap.put(currentRemainder, i);
            }
        }

        return maxLength;
       
    }
 
}
