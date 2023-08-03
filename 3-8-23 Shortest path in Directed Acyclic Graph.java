Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

Example1:

Input:
N = 4, M = 2
edge = [[0,1,2],[0,2,1]
Output:
0 2 1 -1
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->2 with edge weight 1.
There is no way we can reach 3, so it's -1 for 3.
Example2:

Input:
N = 6, M = 7
edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
Output:
0 2 3 6 1 5
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
Shortest path from 0 to 4 is 0->4 with edge weight 1.
Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.
Your Task:

You don't need to print or input anything. Complete the function shortest path() which takes an integer N as number of vertices, an integer M as number of edges and a 2D Integer array(or vector) edges as the input parameters and returns an integer array(or vector), denoting the list of distance from src to all nodes.

Expected Time Complexity: O(N+M), where N is the number of nodes and M is edges
Expected Space Complexity: O(N)

Constraint:
1 <= N,M <= 100
0 <= edgei,0,edgei,1 < n
0 <= edgei,2 <=105



class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {

    //Code here

    int dis[]=new int [N];

    for(int i=0;i<N;i++){

        dis[i]=Integer.MAX_VALUE;

    }

    dis[0]=0;

    Stack <Integer> st=new Stack<>();

    boolean vis[]=new boolean[N];

    for(int i=0;i<N;i++){

        if(!vis[i])

        topsort(edges,vis,i,st);

    }

  

    while(!st.isEmpty()){

        int k=st.pop();

        for(int i=0;i<M;i++){

            if(edges[i][0]==k && dis[k]!=Integer.MAX_VALUE){

                if(dis[edges[i][1]]>(dis[k]+edges[i][2]))

                dis[edges[i][1]]=dis[k]+edges[i][2];

            }

        }

    }

    for(int i=0;i<N;i++){

        if(dis[i]==Integer.MAX_VALUE)

        dis[i]=-1;

    }

    return dis;

  }

  

  public void topsort(int edges[][],boolean vis[],int s,Stack<Integer> st){

      vis[s]=true;

      for(int i=0;i<edges.length;i++){

          if(edges[i][0]==s){

              if(!vis[edges[i][1]])

              topsort(edges,vis,edges[i][1],st);

          }

      }

      st.push(s);

  }
}
