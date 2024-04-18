class Solution
{
    //Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n)
    {
        int[] ans = new int[2];
        int k=0;
        for(int i=0 ; i<=n+1 ; i++){
            int index = Math.abs(arr[i]);
            if(arr[index]<0){
                ans[k++] = index;
            }
            else{
                arr[index] *= -1;
            }
        }
        return ans;
    }
}

