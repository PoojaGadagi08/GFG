Given an array arr of n integers, write a function that returns true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.

Example 1:

Input:
N = 5
Arr[] = {3, 2, 4, 6, 5}
Output: Yes
Explanation: a=3, b=4, and c=5 forms a
pythagorean triplet.
Example 2:

Input:
N = 3
Arr[] = {3, 8, 5}
Output: No
Explanation: No such triplet possible.
Your Task:
You don't have to take any input or print any thing. You have to complete the function checkTriplet() which takes an array arr, a single integer n, as input parameters and returns boolean denoting answer to the problem.
Note: The driver will print "Yes" or "No" instead of corresponding to the boolean value returned.

Expected Time Complexity: O(n+max(Arr[i])2)
Expected Auxiliary Space: O(max(Arr[i]))

Constraints:
1 <= n <= 105
1 <= arr[i] <= 1000






  //User function Template for Java


// Brute force
//O(n^3)
// class Solution {
//     boolean checkTriplet(int[] arr, int n) {
//         // code here
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 for(int k=j+1;k<n;k++){
//                     int a=arr[i]*arr[i];
//                     int b=arr[j]*arr[j];
//                     int c=arr[k]*arr[k];
                    
//                     if( a+b == c || b+c == a || a+c == b)
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }



// Better
// O(n^2)
class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
        set.add(arr[i]*arr[i]);
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int c=arr[i]*arr[i] + arr[j]*arr[j];
                if(set.contains(c))
                return true;
            }
        }
        return false;
    }
}



// Optimal solution
//O(n+n logn + n) == O(n^2)
// class Solution {
//     boolean checkTriplet(int[] arr, int n) {
//         // code here
//         for(int i=0;i<n;i++){
//             arr[i]=arr[i]*arr[i];
//         }
//         Arrays.sort(arr);
        
//         for(int i=n-1;i>=2;i--){
//             int l=0;
//             int r=i-1;
            
//             while(l<r){
//                 if(arr[l]+arr[r]==arr[i]) return true;
//                 else if(arr[l]+arr[r]<arr[i]) l++;
//                 else r--;
//             }
//         }
//         return false;
//     }
// }
