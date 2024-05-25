class Solution {
    long max_Books(int arr[], int n, int k) {
        // Your code here
        long res=0;
        long sum=0;
        int ind=0;
        
        while(ind < n){
            sum+=arr[ind];
            if(arr[ind++]>k)
            sum=0;
            res=Math.max(res, sum);
        }
        return res;
    }
}
