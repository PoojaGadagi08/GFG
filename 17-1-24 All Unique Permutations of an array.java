Given an array arr[] of length n. Find all possible unique permutations of the array in sorted order. A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

Example 1:

Input: 
n = 3
arr[] = {1, 2, 1}
Output: 
1 1 2
1 2 1
2 1 1
Explanation:
These are the only possible unique permutations
for the given array.
Example 2:

Input: 
n = 2
arr[] = {4, 5}
Output: 
Only possible 2 unique permutations are
4 5
5 4
Your Task:
You don't need to read input or print anything. You only need to complete the function uniquePerms() that takes an integer n, and an array arr of size n as input and returns a sorted list of lists containing all unique permutations of the array.

Expected Time Complexity:  O(n*n!)
Expected Auxilliary Space: O(n*n!)

Constraints:
1 ≤ n ≤ 9
1 ≤ arri ≤ 10



  class Solution {
    public static void unique(ArrayList<Integer> ds,ArrayList<Integer> arr,HashSet<ArrayList<Integer>> set,boolean feq[]){
        if(ds.size()==arr.size()){
            set.add(new ArrayList<>(ds));
            // System.out.println(ds);
            return;
        }
        for(int i=0;i<arr.size();i++){
            if(!feq[i]){
                feq[i]=true;
                ds.add(arr.get(i));
                unique(ds,arr,set,feq);
                ds.remove(ds.size()-1);
                feq[i]=false;ArrayList<ArrayList<Integer>>
                
            }
        }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        Collections.sort(arr);
        ArrayList<Integer> ds=new ArrayList<>();
        HashSet<ArrayList<Integer>> set=new LinkedHashSet<>();
        boolean feq[]=new boolean[n];
        unique(ds,arr,set,feq);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(ArrayList<Integer> a:set){
            ans.add(new ArrayList<>(a));
        }
        return ans;
    }
};

