Given three stacks S1, S2 & S3 of size N1, N2 & N3 respectively, having only Positive Integers. The task is to find the 
possible equal maximum sum of the stacks with the removal of top elements allowed. Stacks are represented as an array, and the first index of the array represents 
the top element of the stack.

Example 1:

Input:
N1 = 3, N2 = 4, N3 = 2
S1 = {4,2,3}
S2 = {1,1,2,3}
S3= {1,4}
Output:
5
Explanation:
We can pop 1 element from the 1st stack, and 2
elements from the 2nd stack. Now remaining elements
yield the equal sum of the three stacks, that is 5.
  
  
  class Solution {
    // public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
    //     // code here
    //     int i=0,j=0,k=0,sum1=0,sum2=0,sum3=0;
        
    //     for(int a=0;i<N1;a++) sum1+=S1[a];
    //     for(int a=0;i<N2;a++) sum2+=S2[a];
    //     for(int  a=0;i<N3;a++) sum3+=S3[a];
        
    //     while(i<N1 && i<N2 && i<N3){
    //         if(sum1==sum2 && sum2==sum3)return sum1;
            
    //         else if(sum1<=sum2 && sum1<=sum3 ){
    //             if(sum1<sum2){
    //             sum2-=S2[j];
    //             j++;
    //             }
    //             if(sum1<sum3){
    //                 sum3-=S3[k];
    //                 k++;
    //             }
    //         }
    //         else if(sum2<=sum1 && sum2<=sum3 ){
    //             if(sum2<sum1){
    //             sum1-=S1[j];
    //             j++;
    //             }
    //             if(sum2<sum3){
    //                 sum3-=S3[k];
    //                 k++;
    //             }
    //         }
    //         else{
    //             if(sum3<sum2){
    //             sum2-=S2[j];
    //             j++;
    //             }
    //             if(sum3<sum1){
    //                 sum3-=S3[k];
    //                 k++;
    //             }
    //         }
    //     }
    //     return 0;
    // }
    
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // code here
        int i=0,j=0,k=0,sum1=0,sum2=0,sum3=0;
        for(int l=0;l<N1;l++)sum1+=S1[l];
        for(int l=0;l<N2;l++)sum2+=S2[l];
        for(int l=0;l<N3;l++)sum3+=S3[l];
        while(i<N1 && j<N2 && k<N3){
            if(sum1==sum2 && sum2==sum3)return sum1;
            else if(sum1<=sum2 && sum1<=sum3){
                if(sum1<sum2){
                    sum2-=S2[j];
                    j++;
                }
                if(sum1<sum3){
                    sum3-=S3[k];
                    k++;
                }
            }
            else if(sum2<=sum1 && sum2<=sum3){
                if(sum2<sum1){
                    sum1-=S1[i];
                    i++;
                }
                if(sum2<sum3){
                    sum3-=S3[k];
                    k++;
                }
            }
            else{
                if(sum3<sum2){
                    sum2-=S2[j];
                    j++;
                }
                if(sum3<sum1){
                    sum1-=S1[i];
                    i++;
                }
            }
        }
        return 0;
    }
    
}
        
