// Given an integer array arr[] of size n which contains only 1 and 0. Your task is to make the array perfect. 
//   An array is said to be perfect if for each i from 0 to n-1 arr[i]==arr[n-1-i] is satisfied. 

// To Make the array perfect you are allowed to do the following operation  :

// In one operation you can choose two different indexes i and j and set value of both arr[i] and arr[j] to arr[i]^arr[j].

// Your task is to make the array perfect in minimum possible number of operations and return the number of operations.

// Note: 0-based indexing is used.

class Solution {
   public static int bitMagic(int n, int[] arr) {
        // code here
         // Initialize count of differences
        int differenceCount = 0;
        
        // Initialize indices startIndex and endIndex
        int startIndex = 0;
        int endIndex = n - 1;
        
        // Iterate through the array until startIndex < endIndex
        while (startIndex < endIndex) {
            // If arr[startIndex] and arr[endIndex] are not equal, increment the count of differences
            if (arr[startIndex] != arr[endIndex]) {
                differenceCount++;
            }
            
            // Move the indices inward
            startIndex++;
            endIndex--;
        }
        
        // Calculate the minimum number of operations required as (differenceCount + 1) / 2
        return (differenceCount + 1) / 2;
    }


}
        
