You are given an undirected graph of N nodes and M edges. Return 1 if the graph is a tree, else return 0.

Note: The input graph can have self-loops and multiple edges.

Example 1:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [1, 3]]
Output: 
1
Explanation: 
Every node is reachable and the graph has no loops, so it is a tree
Example 2:

Input:
N = 4, M = 3
G = [[0, 1], [1, 2], [2, 0]]
Output: 
0
Explanation: 
3 is not connected to any node and there is a loop 0->1->2->0, so it is not a tree.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function isTree() which takes the integer N (the number nodes in the input graph) and the edges representing the graph as input parameters and returns 1 if the input graph is a tree, else 0.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 2*105
0 <= M <= 2*105





  
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
         if (n - 1 != m) {
            // A tree with n nodes will have n-1 edges
            return false;
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // Check for connectivity and cycles using DFS
        if (!dfs(adjList, 0, -1, visited)) {
            return false;
        }

        // Check if all nodes are visited
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adjList, int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (!dfs(adjList, neighbor, node, visited)) {
                    return false;
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and not the parent, there is a cycle
                return false;
            }
        }

        return true;
    }
}

 
