A critical connection refers to an edge that, upon removal, will make it impossible for certain nodes to reach each other through any path. You are given an undirected connected graph with v vertices and e edges and each vertex distinct and ranges from 0 to v-1, and you have to find all critical connections in the graph. It is ensured that there is at least one such edge present.

Note: The answers may be presented in various potential orders. Each edge should be displayed in sorted order. For instance, if there's an edge between node 1 and node 2, it should be stored as (1,2) rather than (2,1). Additionally, it is expected that you store the edges in sorted order.

Example 1:

Input:

Output:
0 1
0 2
Explanation: 
On removing edge (0, 1), you will not be able to
reach node 0 and 2 from node 1. Also, on removing
edge (0, 2), you will not be able to reach node 0
and 1 from node 2.
Example 2:

Input:

Output:
2 3
Explanation:
The edge between nodes 2 and 3 is the only
Critical connection in the given graph.
Your task:
You dont need to read input or print anything. Your task is to complete the function criticalConnections() which takes the integer v denoting the number of vertices and an adjacency list adj as input parameters and returns  a list of lists containing the Critical connections in the sorted order.

Expected Time Complexity: O(v + e)
Expected Auxiliary Space: O(v)

Constraints:
1 ≤ v, e ≤ 104



  class Solution
{
    private void dfs(ArrayList<ArrayList<Integer>> ans,ArrayList<ArrayList<Integer>> adj,boolean vis[],int[] low,int disc[],int src,int parent,int timer){
        vis[src] = true;
        low[src] = disc[src] = timer++;
        for(int nbr:adj.get(src)){
            if(nbr==parent)
                continue;
            
            if(!vis[nbr]){
                dfs(ans,adj,vis,low,disc,nbr,src,timer);
                //check low is updated or not
                if(disc[src]<low[nbr]){
                    ArrayList<Integer> bridge = new ArrayList<>();
                    bridge.add(src);
                    bridge.add(nbr);
                    ans.add(bridge);
                }else{
                     low[src] = Math.min(low[src],low[nbr]);
                }
            }else{
                low[src] = Math.min(low[src],disc[nbr]);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean vis[] = new boolean[v];
        int low[] = new int[v];
        int disc[] = new int[v];
        int parent = -1;
        int timer = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(ans,adj,vis,low,disc,i,parent,timer);
            }
        }
        for(int i=0;i<ans.size();i++)
        Collections.sort(ans.get(i));
        
        Collections.sort(ans,(a,b)->{
            for (int i = 0; i < 2; i++) {
                int compareResult = a.get(i).compareTo(b.get(i));
                if (compareResult != 0)
                    return compareResult; 
            }
            return 0;
        });
        return ans;
        
    }
}
