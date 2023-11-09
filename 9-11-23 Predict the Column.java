Given a matrix(2D array) M of size N*N consisting of 0s and 1s only. The task is to find the column with maximum number of 0s. If more than one column exists, print the one which comes first. If the maximum number of 0s is 0 then return -1.

Example:

Input:
N = 3
M[][] = {{0, 0, 0},
          {1, 0, 1},
          {0, 1, 1}}
Output:
0
Explanation:
0th column (0-based indexing) is having 2 zeros which is maximum among all columns and comes first.
Your Task:
Your task is to complete the function columnWithMaxZero() which should return the column number with the maximum number of zeros. 

Expected Time Complexity: O(N * N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 103
0 <= A[i][j] <= 1



  //User function Template for Java

class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        // code here 
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int col = 0;col < N; col++){
            int count = -1;
            for(int row = 0;row < N;row++){
                if(arr[row][col]==0){
                    count++;
                }
            }
            if(count > max && count > -1){
                max = count;
                ans = col;
            }
            
        }
        return ans;


    }
}
