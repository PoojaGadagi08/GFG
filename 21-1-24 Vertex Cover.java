Vertex cover of an undirected graph is a list of vertices such that every vertex not in the vertex cover shares their every edge with the vertices in the vertex cover. In other words, for every edge in the graph, atleast one of the endpoints of the graph should belong to the vertex cover. You will be given an undirected graph G, and your task is to determine the smallest possible size of a vertex cover.

Example 1:

Input:
N=5
M=6
edges[][]={{1,2}
           {4, 1},
           {2, 4},
           {3, 4},
           {5, 2},
           {1, 3}}
Output:
3
Explanation:
{2, 3, 4} forms a vertex cover
with the smallest size.
Example 2:

Input:
N=2
M=1
edges[][]={{1,2}} 
Output: 
1 
Explanation: 
Include either node 1 or node 2
in the vertex cover.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function vertexCover() which takes the edge list and an integer n for the number of nodes of the graph as input parameters and returns the size of the smallest possible vertex cover.

Expected Time Complexity: O(M*N2log(N))
Expected Auxiliary Space: O(N2)

 Constraints:
1 <= N <= 16
1 <= M <= N*(N-1)/2
1 <= edges[i][0], edges[i][1] <= N






  class Solution {

    static boolean isPsbl(int n, int m, int mid, List<List<Integer>> adjlst) {
        int base = (1 << mid) - 1;
        int last = 1 << n;

        while (base < last) {
            boolean[][] vis = new boolean[n + 1][n + 1];

            int ec = 0;

            for (int j = 1, u = 1; j < last; j = j << 1, u++) {
                if ((base & j) != 0) {
                    for (int v = 1; v <= n; v++) {
                        if (adjlst.get(u).contains(v) && !vis[u][v]) {
                            ec++;
                            vis[u][v] = true;
                            vis[v][u] = true;
                        }
                    }
                }
            }

            if (ec == m) return true;

            int rmst = base & -base;

            int res = base + rmst;

            base = (((res ^ base) >> 2) / rmst) | res;
        }

        return false;
    }

    public static int vertexCover(int n, int m, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            ans.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            ans.get(edge[0]).add(edge[1]);
            ans.get(edge[1]).add(edge[0]);
        }

        int l = 1, r = n;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (isPsbl(n, m, mid, ans)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}

