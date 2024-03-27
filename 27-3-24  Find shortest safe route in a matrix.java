Given a matrix mat[][] with r rows and c columns, where some cells are landmines (marked as 0) and others are safe to traverse. Your task is to find the shortest safe route from any cell in the leftmost column to any cell in the rightmost column of the mat. You cannot move diagonally, and you must avoid both the landmines and their adjacent cells (up, down, left, right), as they are also unsafe.

Example 1:

Input:
mat = [1, 0, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 0, 1],
      [1, 1, 1, 1, 0]
Output: 
6
Explanation: 
We can see that length of shortest
safe route is 6 (Highlighted in Bold).
[1 0 1 1 1]
[1 1 1 1 1] 
[1 1 1 1 1]
[1 1 1 0 1] 
[1 1 1 1 0]
Example 2:

Input:
mat = [1, 1, 1, 1, 1],
      [1, 1, 0, 1, 1],
      [1, 1, 1, 1, 1]
Output: 
-1
Explanation: There is no possible path from
first column to last column.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findShortestPath() which takes matrix as input parameter and return an integer denoting the shortest safe path form any cell in leftmost column to any cell in rightmost column of mat. If there is no possible path, return -1. 

Expected Time Complexity: O(r * c)
Expected Auxiliary Space: O(1)

Constraints:
1 <= r, c <= 103
0 <= mat[][] <= 1



  class Solution {

    public int findShortestPath(int[][] mat) {

        int n = mat.length;

        int m = mat[0].length;

        int[][] ans = new int[n][m];

        int[] delrow = {-1, 0, 1, 0};

        int[] delcol = {0, 1, 0, -1};

        

        // Initialize ans matrix

        for (int i = 0; i < n; i++) {

            Arrays.fill(ans[i], 1);

        }

        

        // Update ans matrix based on obstacles

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {

                    ans[i][j] = 0;

                    for (int k = 0; k < 4; k++) {

                        int nr = delrow[k] + i;

                        int nc = delcol[k] + j;

                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                            ans[nr][nc] = 0;

                        }

                    }

                }

            }

        }

        

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (ans[i][0] == 1) {

                queue.offer(new int[]{i, 0, 1});

            }

        }

        

        int[][] vis = new int[n][m];

        while (!queue.isEmpty()) {

            int[] a = queue.poll();

            int row = a[0];

            int col = a[1];

            int count = a[2];

            vis[row][col] = 1;

            if (col == m - 1) {

                return count;

            } else {

                for (int i = 0; i < 4; i++) {

                    int nr = delrow[i] + row;

                    int nc = delcol[i] + col;

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && ans[nr][nc] == 1) {

                        vis[nr][nc] = 1;

                        queue.offer(new int[]{nr, nc, count + 1});

                    }

             

  }

            }

        }

        return -1;

    }

}

