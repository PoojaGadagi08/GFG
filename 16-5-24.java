class Solution {
    private int dfs(List<Integer>[] adj, int node, int parent, int[] ans) {
        int cnt = 1;
        for(int it: adj[node]) {
            if(it != parent) {
                int cntNode = dfs(adj, it, node, ans);
                if(cntNode % 2 == 0) {
                    ans[0]++;
                }
                else {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int minimumEdgeRemove(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] ans = new int[1];
        dfs(adj, 1, -1, ans);
        return ans[0];
    }
}
 
