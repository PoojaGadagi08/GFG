// You are given an array A of N integers and an integer K, and your task is to find the total number of cuts that you can make such that for 
//   each cut these two conditions are satisfied
// 1. A cut divides an array into two parts equal or unequal length (non-zero).
// 2. Sum of the largest element in the left part and the smallest element in the right part is greater than or equal to K.

class Solution {
    public static int totalCuts(int N, int K, int[] A) {
        // code here
        int r[]=new int[N];
        int l[]=new int [N];
        l[0]=A[0];
        r[N-1]=A[N-1];
        
        for(int i =1;i<N;i++)
        l[i]=Math.max(l[i-1],A[i]);
        
        for(int i=N-2;i>=0;i--){
            r[i]=Math.min(r[i+1],A[i]);
        }
        
        int a=0;
        for(int i=0;i<N-1;i++){
            if(l[i]+r[i+1]>=K)
            a++;
        }
        return a;
    }
}
