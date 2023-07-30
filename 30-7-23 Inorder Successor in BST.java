Given a BST, and a reference to a Node x in the BST. Find the Inorder Successor of the given node in the BST.
 

Example 1:

Input:
      2
    /   \
   1     3
K(data of x) = 2
Output: 3 
Explanation: 
Inorder traversal : 1 2 3 
Hence, inorder successor of 2 is 3.

Example 2:

Input:
             20
            /   \
           8     22
          / \
         4   12
            /  \
           10   14
K(data of x) = 8
Output: 10
Explanation:
Inorder traversal: 4 8 10 12 14 20 22
Hence, successor of 8 is 10.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function inOrderSuccessor(). This function takes the root node and the reference node as argument and returns the node that is inOrder successor of the reference node. If there is no successor, return null value.


Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(1).




  //User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
void inorder(Node root,Node x,ArrayList<Node>ans){
        if(root==null)return;
        inorder(root.left,x,ans);
        ans.add(root);
        inorder(root.right,x,ans);
        
    }
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public Node inorderSuccessor(Node root,Node x)
         {
             if(root==null)return root;
             ArrayList<Node>ans=new ArrayList<>();
             inorder(root,x,ans);
             int l=0,ptr=0,r=ans.size()-1;
             while(l<=r){
                 int mid=(l+r)/2;
                 if(ans.get(mid).data==x.data){
                     ptr=mid;
                     break;
                 }
                 else if(ans.get(mid).data>x.data)r=mid-1;
                 else if(ans.get(mid).data<x.data)l=mid+1;
             }
             if(ptr==ans.size()-1)return null;
             return ans.get(ptr+1);
         
     
         }


}
