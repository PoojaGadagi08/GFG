Given a Binary Search Tree, modify the given BST such that it is balanced and has minimum possible height. Return the balanced BST.

Example1:

Input:
       30
      /
     20
    /
   10
Output:
     20
   /   \
 10     30
Example2:

Input:
         4
        /
       3
      /
     2
    /
   1
Output:
      3            3           2
    /  \         /  \        /  \
   1    4   OR  2    4  OR  1    3   
    \          /                  \ 
     2        1                    4

Your Task:
The task is to complete the function buildBalancedTree() which takes root as the input argument and returns the root of tree after converting the given BST into a balanced BST with minimum possible height. The driver code will print the height of the updated tree in output itself.
 
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
Here N denotes total number of nodes in given BST.

Constraints:
1 <= N <= 105
1 <= Node data <= 109






  /*class Node
{
    int data;
    Node right, left;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class GfG
{
    Node buildBalancedTree(Node root) 
    {
        //Add your code here.
        ArrayList<Integer> alist=new ArrayList<>();
        fill(root,alist);
        Collections.sort(alist);
        Node root1=build(alist,0,alist.size()-1);
        return root1;
        
    }
    public static Node build(ArrayList<Integer> alist,int l,int h)
    {
        int mid=(l+h)/2;
        if(l>h)
            return null;
        Node root=new Node(alist.get(mid));
        root.left=build(alist,l,mid-1);
        root.right=build(alist,mid+1,h);
        return root;
    }
    public static void  fill(Node root,ArrayList<Integer> alist)
    {
        if(root==null) return ;
        
        alist.add(root.data);
        fill(root.left,alist);
        fill(root.right,alist);
    }
    
}
