Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form). The 8 directions are, horizontally left, horizontally right, vertically up, vertically down, and 4 diagonal directions.

Note: The returning list should be lexicographically smallest. If the word can be found in multiple directions starting from the same coordinates, the list should contain the coordinates only once. 

Example 1:

Input: 
grid = {{a,b,c},{d,r,f},{g,h,i}},
word = "abc"
Output: 
{{0,0}}
Explanation: 
From (0,0) we can find "abc" in horizontally right direction.
Example 2:

Input: 
grid = {{a,b,a,b},{a,b,e,b},{e,b,e,b}}
word = "abe"
Output: 
{{0,0},{0,2},{1,0}}
Explanation: 
From (0,0) we can find "abe" in right-down diagonal. 
From (0,2) we can find "abe" in left-down diagonal. 
From (1,0) we can find "abe" in horizontally right direction.
Your Task:
You don't need to read or print anything, Your task is to complete the function searchWord() which takes grid and word as input parameters and returns a list containing the positions from where the word originates in any direction. If there is no such position then returns an empty list.

Expected Time Complexity: O(n*m*k) where k is constant
Expected Space Complexity: O(1)

Constraints:
1 <= n <= m <= 50
1 <= |word| <= 15











  //User function Template for Java

class Solution
{
    
static int[] dir = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dic = {0, 1, 1, 1, 0, -1, -1, -1};

    static boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    static boolean check1(int row, int col, int i, char[][] grid, String st, int ind) {
        boolean p = false;
        while (isValid(row, col, grid.length, grid[0].length) && ind < st.length() && grid[row][col] == st.charAt(ind)) {
            row += dir[i];
            col += dic[i];
            ind++;
        }
        return ind == st.length();
    }

    static boolean check(int row, int col, char[][] grid, String str, int j) {
        if (j == str.length()) return true;
        boolean p = false;
        for (int i = 0; i < 8; i++) {
            int nrow = row + dir[i];
            int ncol = col + dic[i];
            if (isValid(nrow, ncol, grid.length, grid[0].length) && grid[nrow][ncol] == str.charAt(j)) {
                p |= check1(nrow, ncol, i, grid, str, j);
            }
        }
        return p;
    }

    static int[][] searchWord(char[][] grid, String word) {
        List<List<Integer>> positions = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    if (check(i, j, grid, word, 1)) {
                        List<Integer> position = new ArrayList<>();
                        position.add(i);
                        position.add(j);
                        positions.add(position);
                    }
                }
            }
        }
        
        int[][] result = new int[positions.size()][2];
        for (int i = 0; i < positions.size(); i++) {
            result[i][0] = positions.get(i).get(0);
            result[i][1] = positions.get(i).get(1);
        }
        
        return result;


}
}
