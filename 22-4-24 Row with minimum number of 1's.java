class Solution {
    int minRow(int n, int m, int a[][]) {
        // code here
        int ans=Integer.MAX_VALUE;
        int ind=-1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<m;j++){
                if(a[i][j]==1){
                    cnt++;
                }
            }
            
            if(cnt<ans){
                ans=cnt;
                ind=i;
            }
        }
        
        return ind+1;
    }
};
