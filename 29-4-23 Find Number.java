// Given an integer N, You need to find the Nth smallest number which only contains odd digits i.e. 1,3,5,7,9 means no even digits are 
// allowed on that number (12 will not consider). 
//   For example, the starting numbers which only contain odd digits are 1,3,5,7,9,11,13,15,17,19,31,33,35 and so on.

class Solution
{
    public long findNumber(long N)
    {
        
        // Brute Force Approach
    //  long num=1;
    //  long c=0;
    //     while(c<N){
    //         if(allOdd(num))
    //         c++;
    //         num++;
    //     }
    //     return num-1;
    // }
    // boolean allOdd(long num){
    //     while(num>0){
    //         long id=num%10;
    //         if(id%2==0)
    //         return false;
    //         num/=10;
    //     }
    //     return true;
    
    
    String s="";
    long arr[]={1,3,5,7,9};
    while(N>0){
        //Circular array approach
        long curr=N%5;//arr length
        if(curr==0) s=arr[4]+s;
        else{
            s=arr[(int)curr-1]+s;
        }
        if (N%5==0 && N>0)
        N=N/5-1;
        else 
        N=N/5;
        
    }
        return Long.parseLong(s);
    }
}
