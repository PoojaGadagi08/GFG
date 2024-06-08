
/*Complete the function below*/
class Solution {
    public int findExtra(int n, int a1[], int a2[]) {
        // // add code here.
        // int low1=0;
        // int low2=0;
        // int high1=n-1;
        // int high2=n-2;
        
        // while(low1<=high1 && low2<=high2){
        //     int mid1=(low1+high1)/2;
        //     int mid2=(low2+high2)/2;
            
        //     if(a1[mid1] > a2[mid2] || (a1[mid1] == a2[mid2] && a1[low1]==a2[low2])) {
        //         low1=mid1+1;
        //         low2=mid2+1;
        //     }
            
        //     if(a1[low1]!= a2[low2])
        //     return low1;
            
        //     if(a1[high1] != a2[high2]) return high1;
        // }
        // return -1;
        
         int low = 0;
        int high = n - 2; // a2 has one less element than a1

        while (low <= high) {
            int mid = (low + high) / 2;

            // Compare elements at mid index
            if (a1[mid] == a2[mid]) {
                // Extra element must be in the right half
                low = mid + 1;
            } else {
                // Extra element is in the left half or it is the current element
                high = mid - 1;
            }
        }

        // The loop will exit with low pointing to the extra element
        return low;
    }
}
