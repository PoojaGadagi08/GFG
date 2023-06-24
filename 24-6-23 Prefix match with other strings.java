Given an array of strings arr[] of size n, a string str and an integer k. The task is to find the count of strings in arr[] whose prefix of length k matches with the k-length prefix of str.

Example 1:

Input:
n = 6
arr[] = {“abba”, “abbb”, “abbc”, “abbd”, 
“abaa”, “abca”}
str = “abbg”
k = 3
Output: 
4 
Explanation:
“abba”, “abbb”, “abbc” and “abbd” have their prefix of length 3 equal to 3-length prefix of str i.e., "abb".



  
//User function Template for Java


class Solution{
// {
//     public int klengthpref(String[] arr, int n, int k, String str)
//     {
//         // code here
//         String s=str.substring(0,k);
//         int c=0;
//         if(k>str.length())
//         return 0;
//         for(int i=0;i<arr.length;i++){
//             if(k<=arr[i].length()){
//             if(arr[i].substring(0,k).equals(s))
//             c++;}
//         }
//         if(c>1)
//         return c;
        
//         return 0;
        
//     }


public int klengthpref(String[] arr, int n, int k, String str)
    {
        // code here
        if(k>str.length())return 0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(k<=arr[i].length()){
                int j=0;
                while(j<k){
                    if(arr[i].charAt(j)!=str.charAt(j))break;
                    j++;
                }
                if(j==k)ans++;
            }
        }
        return ans;
    }
}
