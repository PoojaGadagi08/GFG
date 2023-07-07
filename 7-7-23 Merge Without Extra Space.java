Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it 
  contains the first N elements and modify arr2 so that it contains the last M elements.

Example 1:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two 
non-decreasing arrays, we get, 
0 1 2 3 5 6 7 8 9.
Example 2:

Input: 
n = 2, arr1[] = [10 12] 
m = 3, arr2[] = [5 18 20]
Output: 
arr1[] = [5 10]
arr2[] = [12 18 20]
Explanation:
After merging two sorted arrays 
we get 5 10 12 18 20.
Your Task:
You don't need to read input or print anything. You only need to complete the function merge() that takes arr1, arr2, n and m as input parameters and modifies them 
  in-place so that they look like the sorted merged array when concatenated.

Expected Time Complexity:  O((n+m) log(n+m))
Expected Auxilliary Space: O(1)




  
//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here
        long a3[]=new long[n+m];
        int k=0;
        for(long x:arr1)
        a3[k++]=x;
        for(long x:arr2)
        a3[k++]=x;
        
        Arrays.sort(a3);
        
        
        for(int i=0;i<n;i++)
        arr1[i]=a3[i];
        
        for(int i=0;i<m;i++)
        arr2[i]=a3[n+i];
        
        
    }
}
