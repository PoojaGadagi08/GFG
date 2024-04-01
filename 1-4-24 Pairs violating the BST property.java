Given a binary tree with n nodes, find the number of pairs violating the BST property.
BST has the following properties:-

Every node is greater than its left child and less than its right child.
Every node is greater than the maximum value of in its left subtree and less than the minimum value in its right subtree.
The maximum in the left sub-tree must be less than the minimum in the right subtree.
Example 1:

Input : 
n = 5
Input tree
    
Output :
5
Explanation : 
Pairs violating BST property are:-
(10,50), 10 should be greater than its left child value.
(40,30), 40 should be less than its right child value.
(50,20), (50,30) and (50,40), maximum of left subtree of 10 is 50 greater than 20, 30 and 40 of its right subtree.
Example 2:

Input : 
n = 6
Input tree

Output :
5  
Explanation :
Pairs violating BST property are:-
(80,30), greater than its right child.
(80,60), greater than node on its right side.
(80,70), greater than node on its right side.
(30,60), the value of 3 is not more than its left child.
(40,30), the value in the left subtree is greater than the value of the right subtree.
Your task :
You don't have to read input or print anything. Your task is to complete the function pairsViolatingBST() that takes the root of the tree and n as input and returns number of pairs violating BST property.
 
Expected Time Complexity: O(n*logn)
Expected Space Complexity: O(n)
 
Your Task :
1 <= n <= 2*104
-109 <= node->data <= 109




  

/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    // Function to count the number of inversions during the merge process
    private static int mergeAndCount(ArrayList<Integer> arr, int l, int m, int r) {
        ArrayList<Integer> left = new ArrayList<>(arr.subList(l, m + 1));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(m + 1, r + 1));

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j))
                arr.set(k++, left.get(i++));
            else {
                arr.set(k++, right.get(j++));
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.size())
            arr.set(k++, left.get(i++));
        while (j < right.size())
            arr.set(k++, right.get(j++));
        return swaps;
    }

    // Merge sort function
    private static int mergeSortAndCount(ArrayList<Integer> arr, int l, int r) {
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    public static int pairsViolatingBST(int n, Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorderTraversal(root, arr);
        return mergeSortAndCount(arr, 0, arr.size() - 1);
    }

    // Function to perform inorder traversal of BST and store nodes in an array
    public static void inorderTraversal(Node root, ArrayList<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.data);
            inorderTraversal(root.right, result);
        }
}
}
