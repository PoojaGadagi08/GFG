Given an array A of size N. The elements of the array consist of positive integers. You have to find the largest element with minimum frequency.

Example 1:

Input: 
5
2 2 5 50 1
Output:
50
Explanation :
All elements are having frequency 1 except 2.
50 is the maximum element with minimum frequency.
  
  
  // User function Template for Java

// Helper class to find largest number with minimum frequency

class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: arr)
        {
            map.put(x, map.getOrDefault(x,0)+1);
        }
        int min_val=Integer.MAX_VALUE;
        int ans=Integer.MIN_VALUE;
       for (Map.Entry<Integer,Integer> e : map.entrySet()) {
           
           int x = e.getKey(); int y=e.getValue();
           if(y<=min_val)
           {
               ans = Math.max(ans, x);
               min_val=y;
           }
       }
       return ans;
      
    }
}
