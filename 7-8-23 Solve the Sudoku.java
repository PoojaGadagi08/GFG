Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (grid[][]), the task is to find a solved Sudoku. For simplicity, you may assume that there will be only one unique solution.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Zeros in the grid indicates blanks, which are to be filled with some number between 1-9. You can not replace the element in the cell which is not blank.


Sample Sudoku for you to get the logic for its solution:



Example 1:

Input:
grid[][] = 
[[3 0 6 5 0 8 4 0 0],
[5 2 0 0 0 0 0 0 0],
[0 8 7 0 0 0 0 3 1 ],
[0 0 3 0 1 0 0 8 0],
[9 0 0 8 6 3 0 0 5],
[0 5 0 0 9 0 6 0 0],
[1 3 0 0 0 0 2 5 0],
[0 0 0 0 0 0 0 7 4],
[0 0 5 2 0 6 3 0 0]]
Output:
True
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
Explanation: 
There exists a valid Sudoku for the input grid, which is shown in output.
Example 2:

Input:
grid[][] = 
[[3 6 6 5 0 8 4 0 0],
[5 2 0 0 0 0 0 0 0],
[0 8 7 0 0 0 0 3 1 ],
[0 0 3 0 1 0 0 8 0],
[9 0 0 8 6 3 0 0 5],
[0 5 0 0 9 0 6 0 0],
[1 3 0 0 0 0 2 5 0],
[0 0 0 0 0 0 0 7 4],
[0 0 5 2 0 6 3 0 0]]
Output:
False
Explanation: 
There does not exists a valid Sudoku for the input grid, since there are two 6s in the first row. Which cannot replaced.
Your Task:
You need to complete the two functions:
SolveSudoku(): Takes a grid as its argument and returns true if a solution is possible and false if it is not.
printGrid(): Takes a grid as its argument and prints the 81 numbers of the solved Sudoku in a single line with space separation.
NOTE: Do not give a new line character after printing the grid. It has already been taken care of in the Driver Code.

Expected Time Complexity: O(9N*N).
Expected Auxiliary Space: O(N*N).

Constraints:
0 ≤ grid[i][j] ≤ 9







  class Solution
{
    //Function to find a solved Sudoku. 
    public static final int ROWS = 9;
    public static final int COLS = 9;
    static boolean SolveSudoku(int grid[][])
    {
        return playSudoku(grid,0,0);
    }
    private static boolean playSudoku(int[][] grid,int row,int col){
        if(row == ROWS){
            return true;
        }
        if(col == COLS){
            return playSudoku(grid,row+1,0);
        }
        if(grid[row][col] != 0){
           return playSudoku(grid,row,col+1);
        }
        for(int num = 1; num <= 9; num++){
           if(canPlace(grid,row,col,num)){
               grid[row][col] = num;
               //System.out.println(row+" "+col+" "+grid[row][col]);
               if(playSudoku(grid,row,col+1)){
                   return true;
               }
               else{
                   grid[row][col] = 0;
               }
           }
        }
        return false;
    }
    private static boolean canPlace(int[][] grid,int row,int col,int value){
        //check if the same value exists in the row;
        for(int i = 0; i < COLS; i++){
            if(grid[row][i] == value){
                return false;
            }
        }
        //check if the same value exists in the column
        for(int i = 0; i < ROWS; i++){
            if(grid[i][col] == value){
                return false;
            }
        }
        //check if the same value exists in the grid
        int grid_row = (row/3)*3,grid_col = (col/3)*3;
        for(int r = grid_row ; r < grid_row+3; r++){
            for(int c = grid_col; c < grid_col+3; c++){
                if(grid[r][c] == value){
                    return false;
                }
            }
        }
        return true;
    }
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}
