Given two integers N (1<=N<=9) and K. Find the kth permutation sequence of first N natural numbers. Return the answer in string format.

Example 1:

Input: N = 4, K = 3
Output: 1324
Explanation: 
Permutations of first 4 natural numbers:
1234,1243,1324,1342,1423,1432.....
So the 3rd permutation is 1324. 
  
  class Solution {
    public static String kthPermutation(int n,int k) {
        // code here
        int fact[] = new int[n+1];
        Arrays.fill(fact,1);
        for(int i=1;i<=n;i++)fact[i]=i*fact[i-1];
        boolean vis[] = new boolean[n+1];
        Arrays.fill(vis,false);
        StringBuilder ans = new StringBuilder();
        int i=n;
        while(ans.length()!=n){
            int row = k/fact[i-1];
            if(k%fact[i-1]!=0)row++;
            for(int j=1;j<=n;j++){
                if(vis[j]==false){
                    row--;
                }
                if(row==0){
                    vis[j]=true;
                    char a = (char)(j+'0');
                    ans.append(a);
                    break;
                }
            }
            k = k%fact[i-1];
            if(k==0)k=fact[i-1];
            i--;
        }
        return ans.toString();
    };
}
