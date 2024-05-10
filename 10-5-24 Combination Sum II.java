Given an array of integers arr, the length of the array n, and an integer k, find all the unique combinations in arr where the sum of the combination is equal to k. Each number can only be used once in a combination.

Example 1:

Input: 
n = 5, k = 7
arr[] = { 1, 2, 3, 3, 5 }
Output:
{ { 1, 3, 3 }, { 2, 5 } }
Explanation:
1 + 3 + 3 = 7
2 + 5 = 7
Example 2:

Input:
n = 6, k = 35
arr[] = { 5, 10, 15, 20, 25, 30 }
Output:
{ { 5,10, 20 }, { 5, 30 }, { 10, 25 }, { 15, 20 } }
Explanation:
5 + 10 + 20 = 35
5 + 30 = 35
10 + 25 = 35
15 + 20 = 35
Your Task:
You don't need to read input or print anything. Your task is to complete the function CombinationSum2() which takes arr[],n, and k as input parameters and returns all the unique combinations.
 

Constraints:
1 <= n <= 100
1 <= arr[i] <= 50
1 <= k <= 30

let p = number of elements, at maximum, can sum up to the given value k.

Expected Time Complexity: O(2min(n,p))
Expected Auxiliary Space: O(n)


  class Solution {
    
    public void fun(int ind, int arr[], int k, List<List<Integer>> ans, List<Integer> ds){
        if(k==0){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            
            if(arr[i]>k) break;
            
            ds.add(arr[i]);
            fun(i+1, arr, k-arr[i], ans, ds);
            ds.remove(ds.size()-1);
        }
    }
    
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        fun(0, arr, k, ans, new ArrayList<>());
        return ans;
    }
}
