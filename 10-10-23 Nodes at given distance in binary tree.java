Given a binary tree, a target node in the binary tree, and an integer value k, find all the nodes that are at distance k from the given target node. No parent pointers are available.
Note: You have to return list in sorted order.

Example 1:

Input:      
          20
        /    \
      8       22 
    /   \
   4    12 
       /   \
      10    14
Target Node = 8
K = 2
Output: 10 14 22
Explanation: The three nodes at distance 2
from node 8 are 10, 14, 22.

Example 2:

Input:      
         20
       /    \
      7      24
    /   \
   4     3
        /  
       1    
Target Node = 7
K = 2
Output: 1 24
Your Task:  
You don't need to read input or print anything. Complete the function KDistanceNodes() which takes the root of the tree, target, and K as input parameters and returns a list of nodes at k distance from target in a sorted order.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(Height of tree)

Constraints:
1 ≤ N ≤ 105
1 ≤ data of node ≤ 109
1 ≤ target ≤ 109
1 ≤ k ≤ 20





  //User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    static boolean flag = false;
    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k) {
        flag = false;
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        rootToTargetNode(root, target, path);
        Node block = null;
        
        Collections.reverse(path);
        
        for(int i=0; i<path.size(); i++) {
            addTargetNodes(path.get(i), block, k-i, ans);
            block = path.get(i);
        }
        Collections.sort(ans);
        return ans;
    }
    
    
    public static void rootToTargetNode(Node node, int target, ArrayList<Node> path) {
        if(node == null || flag) return;
        
        if(node.data == target) {
            flag = true;
        }
        
        path.add(node);
        rootToTargetNode(node.left, target, path);
        rootToTargetNode(node.right, target, path);
        if(!flag) path.remove(path.size()-1);
    }
    
    public static void addTargetNodes(Node node, Node block, int k, ArrayList<Integer> ans) {
        if(node == block || node == null || k < 0) return;
        
        if(k == 0) ans.add(node.data);
        
        addTargetNodes(node.left, block, k-1, ans);
        addTargetNodes(node.right, block, k-1, ans);
    }

};
