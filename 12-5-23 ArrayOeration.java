// You are given an array arr of n integers. You must return the minimum number of operations required to make this array 0. For this you can do an operation :

// Choose a sub-array of non-zero elements & replace all with 0(0 must be present in arr, if not you can not replace it).

class Solution {
    public static int arrayOperations(int n, int[] arr) {
        // code here
        int ans=0,len=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                if(len!=0)ans++;
                len=0;
            }
            else len++;
        }
        if(len==n)return -1;
        if(len!=0)ans++;
        return ans;
    }
}
 
