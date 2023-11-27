
Given an undirected graph with no self loops with V (from 0 to V-1) nodes and E edges, the task is to check if there is any cycle in the undirected graph.

Note: Solve the problem using disjoint set union (DSU).

Example 1:

Input: 

Output: 1
Explanation: There is a cycle between 0->2->4->0
Example 2:

Input: 

Output: 0
Explanation: The graph doesn't contain any cycle
Your Task:
You don't need to read or print anyhting. Your task is to complete the function detectCycle() which takes number of vertices in the graph denoting as V and adjacency list adj and returns 1 if graph contains any cycle otherwise returns 0.

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ 104





  class Solution
{
    public:
    //Function to detect cycle using DSU in an undirected graph.
    // dsu 
    int par[10001]; 
    int siz[10001]; 
    void make(int u)
    {
        par[u]= u ;
        siz[u]=1; 
    }
    int find(int u)
    {
        if(par[u]==u)
        return u ;
        return par[u] = find(par[u]) ;
    }
    
    int Union(int u ,int v )
    {
        int a = find(u) ;
        int b = find(v) ; 
        
        if(a!=b)
        {
            if(siz[b]>siz[a])
            swap(a,b); 
            par[b] =a ; 
            siz[a]+=siz[b]; 
        }
    }
    
    
    
	int detectCycle(int V, vector<int>adj[])
	{
	    // Code here
	    map<pair<int,int>, int >m ; 
	    for(int i =0 ;i<V; i++ )
	    {
	        make(i) ;
	    }
	    for(int i= 0; i<V ;i++ )
	    {
	        for(auto it: adj[i])
	        {
	            if(m.find({i, it})!=m.end() || m.find({it, i })!=m.end())
	            {
	                continue ;
	            }
	            int a = find(i) ;
	            int b = find(it) ;
	            if(a!=b)
	            {
	                Union(i, it ) ;
	                m[{i, it}]=1 ;
	            }
	            else
	            return true ;
	        }
	    }
	    return false ;
	}
};
