Given a Binary Search Tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.

Example 1:

Input:
      4
    /   \
   2     9
k = 2 
Output: 4
Example 2:

Input:
       9
        \ 
          10
K = 1
Output: 10
Your Task:
You don't need to read input or print anything. Your task is to complete the function kthLargest() which takes the root of the BST and an integer K as inputs and returns the Kth largest element in the given BST.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H) where H is max recursion stack of height H at a given time.

Constraints:
1 <= N <= 105
1 <= K <= N









//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        int n = count(root);
        convertArray(root);
        Integer[] arr = new Integer[n];
        arr = nodeArray.toArray(arr);
        Arrays.sort(arr);
        
        return arr[n-K];
    }
    
    ArrayList<Integer> nodeArray = new ArrayList<>();
    
    private void convertArray(Node root){
        if(root == null){
            return;
        }
        
        nodeArray.add(root.data);
        convertArray(root.left);
        convertArray(root.right);
    }
    
    private int count(Node root){
        if(root == null){
            return 0;
        }
        
        return count(root.left) + count(root.right) + 1;
    }
}
