Given an array of positive numbers, the task is to find the number of possible contiguous subarrays having product less than a given number k.

Example 1:

Input : 
n = 4, k = 10
a[] = {1, 2, 3, 4}
Output : 
7
Explanation:
The contiguous subarrays are {1}, {2}, {3}, {4} 
{1, 2}, {1, 2, 3} and {2, 3} whose count is 7.
Example 2:

Input:
n = 7 , k = 100
a[] = {1, 9, 2, 8, 6, 4, 3}
Output:
16




  
//User function Template for Java


class Solution {
    
    public int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        
        long p=1;
        int ans=0,i=0,j=0;
        for(i=0, j=0; j<n ; j++)
        {
            p = p*a[j];
            while(p>=k && i<j)
            {
                p/=a[i];
                i++;
            }
            
            if(p<k)
            ans+= (j-i+1);
        
        }
        return ans;
    }
}
