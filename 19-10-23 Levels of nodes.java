Given an integer X and an undirected acyclic graph with V nodes, labeled from 0 to V-1, and E edges, find the level of node labeled as X.

Level is the minimum number of edges you must travel from the node 0 to some target.

If there doesn't exists such a node that is labeled as X, return -1.

Example 1:

Input:

X = 4
Output:
2
Explanation:

We can clearly see that Node 4 lies at Level 2.
Example 2:

Input:

X = 1
Output:
1
Explanation:
Node 1 lies at level 1, immediate after Node 0.
Your task:
You dont need to read input or print anything. Your task is to complete the function nodeLevel() which takes two integers V and X denoting the number of vertices and the node, and another adjacency list adj as input parameters and returns the level of Node X. If node X isn't present it returns -1.

Expected Time Complexity: O(V)
Expected Auxiliary Space: O(V)

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ 104
0 ≤ adji, j < V
1 ≤ X < V
Graph doesn't contain multiple edges and self loops.







  class Solution {
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        boolean visited[] = new boolean[V];
        int levels = 0; // Initialize levels to 0.
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int currNode = q.poll();
                if (currNode == X) {
                    return levels;
                }
                for (int nbr : adj.get(currNode)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        q.add(nbr);
                    }
                }
            }
            levels++; // Increase levels after processing the current level.
        }
        return -1;
    }
}
