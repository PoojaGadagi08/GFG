


Given a BST and an integer. Find the least absolute difference between any node value of the BST and the given integer.

Example 1:

Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
K = 13
Output: 
2
Explanation: K=13. The node that has
value nearest to K is 11. so the answer
is 2
  
  //User function Template for Java

/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
*/

// class Solution
// {
//     //Function to find the least absolute difference between any node
//     //value of the BST and the given integer.
//       static int ans;
//     static int minDiff(Node  root, int K) 
//     { 
//         // Write your code here
//         // BruteForce
//         ans=Integer.MAX_VALUE;
//         ino(root,K);
//         return ans;
      
//     } 
//     static void ino(Node root,int k){
//         if(root!=null){
//             ino(root.left,k);
//         ans=Math.min(ans,Math.abs(k-root.data));
//         ino(root.right,k);
//         }
//     }
// }

class Solution
{
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    static int minDiff(Node  root, int K) 
    { 
       return help(root, K);
    } 
    static int help(Node root, int k)
    {
        if(root==null) return Integer.MAX_VALUE;
        
         if(root.data==k) //if node is fonnd return 0;
            return 0;
        
        
        if(root.data>k)
            return Math.min( root.data-k ,help(root.left,k) );
        
        //else we call the function recursively for the right subtree.
        return Math.min( k - root.data , help(root.right,k) );
    }
}

