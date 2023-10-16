You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1. A group of connected 1s forms an island. Two 1s are connected if they share one of their sides with each other.

Return the size of the largest island in the grid after applying this operation.

Example 1:

Input: 
grid = [[1,0],[0,1]]
Output:
3
Explanation:
Change any one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: 
grid = [[1,1],[1,0]]
Output:
4
Explanation:
Change the only 0 to 1 and make the island bigger, then we get an island with area = 4.
Example 3:

Input: 
grid = [[1,1],[1,1]]
Output:
4
Explanation:
Can't change any 0 to 1, only one island possible with area = 4.
Your Task:

You don't have to read input or print anything. You have to complete the functions largestIsland(), which takes binary matrix as input and returns an integer denoting the size of the largest island in grid after applying the operation.

Constraints:

1 <= n <= 500
0 <= grid[i][j] <= 1 (grid[i][j] ∈ {0, 1} and 0<=i,j<n)




class Solution{
    private int[] parent;
    private int[] size;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int N,int[][] grid) 
    {
        parent = new int[N * N];
        size = new int[N * N];
        
        // Initialize parent and size arrays
        for (int i = 0; i < N * N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        // Step 1: Union islands
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        
                        if (ni >= 0 && ni < N && nj >= 0 && nj < N && grid[ni][nj] == 1) {
                            union(i * N + j, ni * N + nj);
                        }
                    }
                }
            }
        }
        
        // Step 2: Count sizes of connected components
        int maxIslandSize = 0;
        int[] componentSizes = new int[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    int componentSize = 1;
                    Set<Integer> connectedComponents = new HashSet<>();
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        
                        if (ni >= 0 && ni < N && nj >= 0 && nj < N && grid[ni][nj] == 1) {
                            int parent = find(ni * N + nj);
                            if (!connectedComponents.contains(parent)) {
                                componentSize += size[parent];
                                connectedComponents.add(parent);
                            }
                        }
                    }
                    maxIslandSize = Math.max(maxIslandSize, componentSize);
                }
            }
        }
        
        return maxIslandSize == 0 ? N * N : maxIslandSize;
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }}
    }
