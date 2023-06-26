Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 109+7.

Example 1:

Input: n = 3, r = 2
Output: 3
Explaination: 3C2 = 3. 
Example 2:

Input: n = 2, r = 4
Output: 0
Explaination: r is greater than n.



  
// User function Template for Java

// class Solution{
//     static int nCr(int n, int r)
//     {
//         // code her
        
//         int mod=1000000007;
        
//         return   fact(n)%mod/((fact(r)%mod )*(fact(n-r)%mod))%mod;
        
        
//     }
//     static int fact(int n){
//         if(n==0 || n==1)return 1;
        
//         return n*fact(n-1);
//     }
// }

class Solution{
    static int nCr(int n, int r)
    {
         int dp[] = new int [r+1];
        dp[0]  =1;
     
         if(r>n)
         return 0;
        if( r== 0 || r==n)
         return 1;
     
        if( r > n-r)
        r = n-r;
        int mod = 1000000007;
        
        for( int i = 0 ; i <= n; i++)
        for(int  j = Math.min(i ,r) ; j>0 ; j--)
        dp[j] =  (dp[j]  + dp[j-1] ) %mod;
        
        return dp[r];
    }
}
