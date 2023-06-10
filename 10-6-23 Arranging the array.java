You are given an array of size N. Rearrange the given array in-place such that all the negative numbers occur before all non-nagative numbers.
  (Maintain the order of all -ve and non-negative numbers as given in the original array).
Example 1:

Input:
N = 4
Arr[] = {-3, 3, -2, 2}
Output:
-3 -2 3 2
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 3, 2. 
  
  
  
//User function Template for Java

class Solution {
    
    public void Rearrange(int a[], int n)
    {
        // Your code goes here
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int  i=0;i<n;i++){
            if(a[i]<0) ans.add(a[i]);
        }
        for(int i=0;i<n;i++){
            if(a[i]>=0) ans.add(a[i]);
        }
        int i=0;
        for(int x:ans){
            a[i++]=x;
        }
    }
}
