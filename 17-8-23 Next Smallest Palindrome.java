Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive). The task is to find the next smallest palindrome strictly larger than the given number.

Example 1:

Input:
N = 11
Num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}
Output: 9 4 1 8 8 0 8 8 1 4 9
Explanation: Next smallest palindrome is
94188088149.
Example 2:

Input:
N = 5
Num[] = {2, 3, 5, 4, 5}
Output: 2 3 6 3 2
Explanation: Next smallest palindrome is
23632.
Your Task:
Complete the function generateNextPalindrome() which takes an array num, and an single integer n, as input parameters and returns an array of integers denoting the answer. You don't to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= Num[i] <= 9





class Solution {
    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        int i=(n-1)/2;
        int j=n/2;
        boolean in=isnine(num);
        if(in){
              Vector<Integer> v = new Vector<Integer>(n+1);
        for(int k=0;k<n+1;k++){
            if(k==0 ||k==n){
                v.add(1);
            }else{
            v.add(0);
        }}
        return v;
        }
        boolean flag=is(num);

        while(i>=0){
        if(flag){
             if(num[i]==9){
                 num[i]=0;
                 flag=true;
             }
             else{
                 num[i]++;
                 flag=false;
             }
        }
        num[j++]=num[i--];
        }
        Vector<Integer> v = new Vector<Integer>(n);
        for(int k=0;k<n;k++){
            v.add(num[k]);
        }
        return v;
    }
  public boolean is(int []num){
      int n=num.length;
      int i=(n-1)/2;
      int j=(n)/2;
      while(i>=0){
           if(num[i]<num[j]){
               return true;
           }
        else if(num[i] > num[j]) {return false;}
           i--;
           j++;
      }
      return true;
  }
  public boolean isnine(int []num){
        for(int i=0;i<num.length;i++){
            if(num[i]!=9){
                return false;
            }
        }
        return true;
  }
}


