Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. 

Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 5, arr2 [] = {1, 2, 3, 6, 7}
Output: 
1 2 3 4 5 6 7
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
Example 2:

Input: 
n = 5, arr1[] = {2, 2, 3, 4, 5}  
m = 5, arr2[] = {1, 1, 2, 3, 4}
Output: 
1 2 3 4 5
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5.
Example 3:

Input:
n = 5, arr1[] = {1, 1, 1, 1, 1}
m = 5, arr2[] = {2, 2, 2, 2, 2}
Output: 
1 2
Explanation: 
Distinct elements including both the arrays are: 1 2.
Your Task: 
You do not need to read input or print anything. Complete the function findUnion() that takes two arrays arr1[], arr2[], and their size n and m as input parameters and returns a list containing the union of the two arrays.

Expected Time Complexity: O(n+m).
Expected Auxiliary Space: O(n+m).

Constraints:
1 <= n, m <= 105
-109 <= arr1[i], arr2[i] <= 109



  //User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> ans =new ArrayList<>();
        int i=0;
        int j=0;
        
        while(i<n && j<m){
            while(i<n-1 && arr1[i]==arr1[i+1]) i++;
            while(j<m-1 && arr2[j]==arr2[j+1]) j++;
            
            if(arr1[i]<arr2[j]){
                ans.add(arr1[i]);
                i++;
            }
            else if(arr1[i]==arr2[j]){
                ans.add(arr1[i]);
                i++;
                j++;
            }
            else{
                ans.add(arr2[j]);
                j++;
            }
        }
        while(i<n){
            while(i<n-1 && arr1[i]==arr1[i+1])i++;
            ans.add(arr1[i]);i++;
        }
        while(j<m){
            while(j<m-1 && arr2[j]==arr2[j+1])j++;
            ans.add(arr2[i]);j++;
        }
        
        return ans;
    }
}



