Given a Binary Tree, find Right view of it. Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /    \
  4     5   6    7
    \
     8

Example 1:

Input:
       1
    /    \
   3      2
Output: 1 2
Example 2:

Input:
     10
    /   \
  20     30
 /   \
40  60 
Output: 10 30 60
Your Task:
Just complete the function rightView() that takes node as parameter and returns the right view as a list. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes ≤ 105
0 ≤ Data of a node ≤ 105



  //User function Template for Java


/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/


class Solution{
    //Function to return list containing elements of right view of binary tree.
     int max_level ;
    ArrayList<Integer> rightView(Node root) {
        //add code here.
        ArrayList<Integer> al = new ArrayList<>();
        max_level =0 ;
      if (root == null)
      return al;
      
      rightV(al, root,1);
      return al;
 
    }
   void rightV( ArrayList a, Node root, int level)
    {
        if (root ==null)
         return;
        
        if(max_level<level){
            a.add(root.data);
            max_level = level;
        }
        
        rightV(a, root.right, level+1);
        rightV(a, root.left, level+1);
        
    }    

}

