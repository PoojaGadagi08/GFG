You are given a matrix of dimensions n x m. The task is to perform boundary traversal on the matrix in a clockwise manner.

Example 1:

Input:
n = 4, m = 4
matrix[][] = {{1, 2, 3, 4},
         {5, 6, 7, 8},
         {9, 10, 11, 12},
         {13, 14, 15,16}}
Output: 1 2 3 4 8 12 16 15 14 13 9 5
Explanation:
The matrix is:
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
The boundary traversal is:
1 2 3 4 8 12 16 15 14 13 9 5
Example 2:

Input:
n = 3, m = 4
matrrix[][] = {{12, 11, 10, 9},
         {8, 7, 6, 5},
         {4, 3, 2, 1}}
Output: 12 11 10 9 5 1 2 3 4 8
Your Task:
Complete the function boundaryTraversal() that takes matrix, n and m as input parameters and returns the list of integers that form the boundary traversal of the matrix in a clockwise manner.

Expected Time Complexity: O(N + M)
Expected Auxiliary Space: O(1)


  
//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
     
        // code here 
        ArrayList<Integer> list = new ArrayList<>();
        if(n==1) {
            for(int i =0;i<m;i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        if(m==1) {
            for(int i =0;i<n;i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }
        for(int i =0;i<m-1;i++) {
            list.add(matrix[0][i]);
        }
        for(int i = 0;i<n-1;i++) {
            list.add(matrix[i][m-1]);
        }
        for(int i =m-1;i>0;i--) {
            list.add(matrix[n-1][i]);
        }
        for(int i = n-1;i>0;i--) {
            list.add(matrix[i][0]);
        }
        return list;


    }
}
