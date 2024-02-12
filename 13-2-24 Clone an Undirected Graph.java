Given a connected undirected graph with n nodes and m edges, with each node having a distinct label from 0 to n-1, create a clone of the graph. Each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.

Note: If the user returns a correct copy of the given graph, then the system will print 1; in the case when an incorrect copy is generated or when the user returns the original node, the system will print 0.

For Example :    

class Node {
    val: integer
    neighbors: List[Node]
}
Example 1:

Input:
adjList = 
{
    {1, 3},
    {0, 2},
    {1, 3},
    {0, 2}
}
Output: 1
Explanation:
1 is the output that the driver code will print in case 
you successfully cloned the given graph.
Example 2:

Input:
adjList = 
{
    {1},
    {0}
}
Output: 1
Explanation: 
1 is the output that the driver code will print in case
you successfully cloned the given graph.
Your Task:
You don't need to read input or print anything. Your task is to complete the function cloneGraph( ) which takes a node will always be the first node of the graph as input and returns the copy of the given node as a reference to the cloned graph.

Expected Time Complexity: O(n + m).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n, m <= 104
1 <= Node value <= n



  class Solution{ 
    
    Node cloneGraph(Node node){
       if(node == null){ 
           return null;
       }   
       
       Queue<Node> q = new LinkedList<>(); 
       q.add(node); 
       // create map to keep track of all the node which are already copied 
       HashMap<Node,Node> map = new HashMap<>();  
       // the node into hashmap with copt node; 
       
       map.put(node, new Node(node.val)); 
       while(!q.isEmpty()){ 
           // remove fist node of q 
           Node fn = q.poll();  
           // take coped node from the map
           Node cpn = map.get(fn); 
           if(fn.neighbors != null)
           { 
               ArrayList<Node> clist = fn.neighbors; 
               // treak each node of list 
               // we node is node copied than we will simply get null 
               for( int i=0; i<clist.size(); i++){ 
                   Node ln  = clist.get(i); 
                   // try to get coped node of ln 
                   // if it node copy than we will get null 
                   Node cl = map.get(ln); 
                   if(cl == null){ 
                       q.add(ln); 
                       cl = new Node(ln.val); 
                       map.put(ln ,cl);
                   }  
                   // add the neighbotr of cpd node;
                   cpn.neighbors.add(cl);
                  
               }
           }
           
       } 
       return map.get(node);
    }
}

