Given two Binary Search Trees. Find the nodes that are common in both of them, ie- find the intersection of the two BSTs.

Note: Return the common nodes in sorted order.

Example 1:

Input:
BST1:
                  5
               /     \
             1        10
           /   \      /
          0     4    7
                      \
                       9
BST2:
                10 
              /    \
             7     20
           /   \ 
          4     9
Output: 4 7 9 10

Example 2:

Input:
BST1:
     10
    /  \
   2   11
  /  \
 1   3
BST2:
       2
     /  \
    1    3
Output: 1 2 3
Your Task:
You don't need to read input or print anything. Your task is to complete the function findCommon() that takes roots of the two BSTs as input parameters and returns a list of integers containing the common nodes in sorted order. 

Expected Time Complexity: O(N1 + N2) where N1 and N2 are the sizes of the 2 BSTs.
Expected Auxiliary Space: O(H1 + H2) where H1 and H2 are the heights of the 2 BSTs.

Constraints:
1 <= Number of Nodes <= 105
1 <= Node data <= 109








class Solution
{
    //Function to find the nodes that are common in both BST.
public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
       ArrayList<Integer> result = new ArrayList<>();
        findCommonNodes(root1, root2, result);
        return result;
    }
 
    private static void findCommonNodes(Node curnode1, Node curnode2, ArrayList<Integer> result) {
        if (curnode1 == null || curnode2 == null) {
            return;
        }
        
        findCommonNodes(curnode1.left, curnode2, result);
        if(isPresent(curnode2,curnode1.data))
        result.add(curnode1.data);
        findCommonNodes(curnode1.right,curnode2,result);
    }
    private static boolean isPresent(Node curnode, int data) {
        if(curnode == null)
        return false;
        
        if(data < curnode.data){
            return isPresent(curnode.left,data);
        }else if(data > curnode.data){
            return isPresent(curnode.right,data);
        }else{
            return true;
        }
 
    }
}
