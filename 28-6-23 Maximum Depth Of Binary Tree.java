Given a binary tree, find its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:

Input:
 root  -->     1
             /   \
            3     2
           /
          4           
Output: 3
Explanation:
Maximum depth is between nodes 1 and 4, which is 3.
Example 2:

Input:
 root -->    10
           /    \
          20    30
           \      \  
           40     60
                  /
                 2 
Output: 4
Explanation:
Maximum depth is between nodes 10 and 2, which is 4




  
//User function Template for Java

/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
  public static int maxDepth(Node root) {
    // // code here
       if(root == null) return 0;
       
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    
    // if (node == null)
    //         return 0;
        
    //         /* compute the depth of each subtree */
    //         int lDepth = maxDepth(node.left);
    //         int rDepth = maxDepth(node.right);
 
    //         /* use the larger one */
    //         if (lDepth > rDepth)
    //             return (lDepth + 1);
        
    //             return (rDepth + 1);
    
    
    
    
    //2nd
    // if( root == null ){
    //         return 0;
    //     }

    //     LinkedList<Node> queue = new LinkedList<>();
    //     queue.addLast(root);

    //     int level = 0;

    //     while( queue.size() > 0 ){
    //         int size = queue.size();

    //         while( size-- > 0 ){
    //             Node remNode = queue.removeFirst();
    //             if( remNode.left != null ){
    //                 queue.addLast( remNode.left );
    //             }
    //             if( remNode.right != null ){
    //                     queue.addLast( remNode.right );
    //             }
    //         }

    //         level++;
    //     }

    //     return level;
    
    
  }
}
     
