Given a binary tree and a budget. Assume you are at the root of the tree(level 1), you need to maximise the count of leaf nodes you can visit in your budget if the cost of visiting a leaf node is equal to the level of that leaf node.

Example 1:

Input: 
                  10
                /    \
               8      2
             /      /   \
            3      3     6
                    \
                     4
and budget = 8
Output: 2
Explanation:
Cost For visiting Leaf Node 3: 3
Cost For visiting Leaf Node 4: 4
Cost For visiting Leaf Node 6: 3
In budget 8 one can visit Max 2 Leaf Nodes.
Example 2:

Input: 
         1
       /   \
      2     3
     / \   / \
    4   5 6   7
and budget = 5
Output: 1
Explanation: We can only visit either node 4 or 5.
Your Task:

You don't need to read input or print anything. Your task is to complete the function getCount() which takes root node of the tree and a integer denoting the budget as input parameters and returns an integer denoting the count of visited leaf nodes of the tree.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1<=N<=105
1<=budget<=104







//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
     ArrayList<Integer> al; 
    public int getCount(Node node, int bud)
    {
        //code here  
        int cnt=0;
        al = new ArrayList<Integer>();
        vis_leaf(node, 0);
        Collections.sort(al);
        //   for(int x : al)
        // System.out.print(x+" ");
        
         for(int i=0; i<al.size(); i++)
         {
             if(bud - al.get(i) >=0)
             {
                 cnt++ ;  bud-=al.get(i); 
             }
             else 
             return cnt;
         }
          return cnt;
    }
    void vis_leaf(Node node, int level)
    {
        if (node==null)	return;  // If the node is null, return
        
        level++;  // Increment the path length
        
        if (node.left==null && node.right==null)  // If the node is a leaf node
        {
            al.add(level);  
            return;
        }
            vis_leaf(node.left, level);
            vis_leaf(node.right,  level);
    }
}
