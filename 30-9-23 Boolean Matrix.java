Given a boolean matrix of size RxC where each cell contains either 0 or 1, modify it such that if a matrix cell matrix[i][j] is 1 then all the cells in its ith row and jth column will become 1.

Example 1:

Input:
R = 2, C = 2
matrix[][] = {{1, 0},
              {0, 0}}
Output: 
1 1
1 0 
Explanation:
Only cell that has 1 is at (0,0) so all 
cells in row 0 are modified to 1 and all 
cells in column 0 are modified to 1.

Example 2:

Input:
R = 4, C = 3
matrix[][] = {{ 1, 0, 0},
              { 1, 0, 0},
              { 1, 0, 0},
              { 0, 0, 0}}
Output: 
1 1 1
1 1 1
1 1 1
1 0 0 
Explanation:
The position of cells that have 1 in
the original matrix are (0,0), (1,0)
and (2,0). Therefore, all cells in row
0,1,2 are and column 0 are modified to 1. 
Your Task:
You dont need to read input or print anything. Complete the function booleanMatrix() that takes the matrix as input parameter and modifies it in-place.

Expected Time Complexity: O(R * C)
Expected Auxiliary Space: O(R + C) 

Constraints:
1 ≤ R, C ≤ 1000
0 ≤ matrix[i][j] ≤ 1









  //User function Template for Java

class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        // code here 
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<Pair> queue = new LinkedList<Pair>();
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 1){
                    queue.add(new Pair(i,j));
                }
            }
        }
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            
            for(int i = 0 ; i < n ;i++){
                matrix[i][col] = 1;
            }
            
            for(int j = 0 ; j < m ;j++){
                matrix[row][j] = 1;
            }
        }
        
    }
    
    class Pair{
        int row;
        int col;
        
        public Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }


}
