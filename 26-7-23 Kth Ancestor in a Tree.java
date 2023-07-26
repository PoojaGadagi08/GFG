Given a binary tree of size  N, a node, and a positive integer k., Your task is to complete the function kthAncestor(), the function should return the kth ancestor of the given node in the binary tree. If there does not exist any such ancestor then return -1.
Note: It is guaranteed that the node exists in the tree.

Example 1:



Input:
K = 2 Node = 4
Output: 1
Explanation:
Since, K is 2 and node is 4, so we
first need to locate the node and
look k times its ancestors.
Here in this Case node 4 has 1 as his
2nd Ancestor aka the Root of the tree.
Example 2:

Input:
k=1 
node=3
      1
    /   \
    2     3

Output:
1
Explanation:
K=1 and node=3 ,Kth ancestor of node 3 is 1.
Your Task:
You are asked to complete the function kthAncestor() which accepts root of the tree, k and node as input parameters, and returns the kth ancestor of Node which contains node as its value.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)






  //User function Template for Java

/*
Structure of Node class is:

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class Solution
{
    int ans=-1;
    void help(Node root,int k,int node,ArrayList<Integer> temp){
        if(root==null)return;
        if(root.data==node && temp.size()>=k){
            ans = temp.get(temp.size()-k);
            return;
        }
        temp.add(root.data);
        help(root.left,k,node,temp);
        help(root.right,k,node,temp);
        temp.remove(temp.size()-1);
    }
    public int kthAncestor(Node root, int k, int node)
    {
        //Write your code here
        ArrayList<Integer> temp = new ArrayList<>();
        help(root,k,node,temp);
        return ans;
    }
}
