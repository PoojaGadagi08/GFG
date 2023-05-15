// You are given a number N. Find the total number of setbits in the numbers from 1 to N. 

//class Solution {
    //public static long countBits(long N) {
        // code here
        
        //TC=O(nlogn)
    //     long ans=0;
    //     for(int i=1;i<=N;i++){
    //         ans+=setBit(i);
    //     }
    //     return ans;
    // }
    // static long setBit(long x){
    //     int c=0;
    //   while(x>0){
    //       if((x&1)==1)
    //       c++;
    //       x/=2;
    //   }
    //   return c;
    
    //}
//}

class Solution {
    public static long countBits(long n) {
        // code here
      if(n==0)
        return 0;
        
        long x = larPowOf2(n);
        long y = x * (1 << (x - 1));
        long z = n - (1 << x);
        return y + z + 1 + countBits(z);
    }
    
    static long larPowOf2(long n) {
        long x = 0;
        while((1 << x) <= n)
            x++;
        
        return x - 1;
    }
    
}
