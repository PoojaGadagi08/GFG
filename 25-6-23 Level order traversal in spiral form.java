Given a binary tree and the task is to find the spiral order traversal of the tree.

Spiral order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and for all the odd levels we print the node's value from left to right. 

For below tree, function should return 1, 2, 3, 4, 5, 6, 7.


 
 

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
Your Task:
The task is to complete the function findSpiral() which takes root node as input parameter and returns the elements in spiral form of level order traversal as a list. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
0 <= Data of a node <= 105





  
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

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> al = new  ArrayList<Integer>();
         if(root== null) return al;
         if(root.left==null && root.right==null)
         {
             al.add(root.data);
             return al;
         }
         Stack <Node> s1 =  new Stack<>();
         Stack <Node> s2 =  new Stack<>();
         
         s1.push(root);
         while(!s1.isEmpty() || !s2.isEmpty())
         {
             while(!s1.isEmpty())
             {
                 Node temp = s1.pop();
                 al.add(temp.data);
                 
                 if(temp.right!=null)  s2.push(temp.right);
                 if(temp.left!=null) s2.push(temp.left);
             }
             while(!s2.isEmpty())
             {
                 Node temp = s2.pop();
                 al.add(temp.data);
                 
                 if(temp.left!=null) s1.push(temp.left);
                 if(temp.right!=null)  s1.push(temp.right);
    
             }

         }
            return al;
    }
}
