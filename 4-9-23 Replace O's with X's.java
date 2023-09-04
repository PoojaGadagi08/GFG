Given a matrix mat of size N x M where every element is either 'O' or 'X'. Replace all 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.

Example 1:

Input: 
n = 5, m = 4
mat = {{'X', 'X', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix. 
Example 2:

 

Input: 
n = 5, m = 4
mat = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix.
Your Task:
You do not need to read input or print anything. Your task is to complete the function fill() which takes N, M and mat as input parameters ad returns a 2D array representing the resultant matrix.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ n, m ≤ 500





  class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
 
        for(int i = 0;i < n;i++){
		    if(a[i][0] == 'O') //1st col
			    dfs(a, i, 0, 'O', '-', n, m);
			    
			 if(a[i][m-1] == 'O') //last col
			    dfs(a, i, m-1, 'O', '-', n, m);
		}

			    
		
		for(int i = 0;i < m;i++){
			if(a[0][i] == 'O') //1st row
			    dfs(a, 0, i, 'O', '-', n, m);
			 if(a[n-1][i] == 'O')  	// last row
			    dfs(a, n-1, i, 'O', '-', n, m);
		}
		
		// 
// 			for(int i = 0;i < n;i++){
// 			for(int j = 0;j < m;j++){
// 		            System.out.print(a[i][j]+" ");
// 		        }
// 		        System.out.println();
//         }
		        
			    
			    //change exisitng O to X;
		for(int i = 0;i < n;i++)
			for(int j = 0;j < m;j++)
				if(a[i][j] == 'O')
				    a[i][j] = 'X';
				    
				    //change - to X;
	    for(int i = 0;i < n;i++)
			for(int j = 0;j < m;j++)
				if(a[i][j] == '-')
				    a[i][j] = 'O';
				    
		return a;
    }
    
    
     static void dfs(char a[][], int x, int y, 
                        char prevC, char newC, int N, int M)
    {
        // out of bound
        if (x < 0 || x >= N || y < 0 || y >= M)
            return;
        if (a[x][y] != prevC)
            return;
        
        // mark with newC and itr in 4 neighbours
        a[x][y] = newC;
        dfs(a, x+1, y, prevC, newC, N, M);
        dfs(a, x-1, y, prevC, newC, N, M);
        dfs(a, x, y+1, prevC, newC, N, M);
        dfs(a, x, y-1, prevC, newC, N, M);
    }
}
