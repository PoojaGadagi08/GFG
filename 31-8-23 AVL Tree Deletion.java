Given an AVL tree and N values to be deleted from the tree. Write a function to delete a given value from the tree. All the N values which needs to be deleted are passed one by one as input data by driver code itself, you are asked to return the root of modified tree after deleting the value.

Example 1:

Tree = 
        4
      /   \
     2     6
    / \   / \  
   1   3 5   7

N = 4
Values to be deleted = {4,1,3,6}

Input: Value to be deleted = 4
Output:
        5    
      /   \
     2     6
    / \     \  
   1   3     7

Input: Value to be deleted = 1
Output:
        5    
      /   \
     2     6
      \     \  
       3     7

Input: Value to be deleted = 3
Output:
        5    
      /   \
     2     6
            \  
             7

Input: Value to be deleted = 6
Output:
        5    
      /   \
     2     7

Your Task:  
You dont need to read input or print anything. Complete the function delelteNode() which takes the root of the tree and the value of the node to be deleted as input parameters and returns the root of the modified tree.

Note: The tree will be checked after each deletion. 
If it violates the properties of balanced BST, an error message will be printed followed by the inorder traversal of the tree at that moment.
If instead all deletion are successful, inorder traversal of tree will be printed.
If every single node is deleted from tree, 'null' will be printed.

Expected Time Complexity: O(height of tree)
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ N ≤ 500




  
//User function Template for Java

/*
class Node
{
	int data, height;
	Node left, right;
	Node(int x)
	{
		data = x;
		height = 1;
		left = right = NULL;
	}
}
*/
class Sol
{
    Node root; // Instance variable to store the root of the AVL tree
    
    // Calculate the height of a node in the tree
    public static int height(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left); // Height of the left subtree
        int rightHeight = height(root.right); // Height of the right subtree
        return Math.max(leftHeight, rightHeight) + 1; // Return the maximum height and add 1 for the current node
    }

    // Calculate the balance factor of a node in the tree
    public static int getBalance(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left); // Height of the left subtree
        int rightHeight = height(root.right); // Height of the right subtree
        return rightHeight - leftHeight; // Return the difference between right and left subtree heights
    }

    // Perform a left rotation on a given node to balance the tree
    public static Node leftRotation(Node x) {
        Node y = x.right; // y is the right child of x
        Node T = y.left; // T is the left child of y (which will become the right child of x)
        x.right = T; // Update the right child of x to T
        y.left = x; // Make y the new root of the rotated subtree
        return y; // Return the new root of the rotated subtree
    }

    // Perform a right rotation on a given node to balance the tree
    public static Node rightRotation(Node x) {
        Node y = x.left; // y is the left child of x
        Node T = y.right; // T is the right child of y (which will become the left child of x)
        x.left = T; // Update the left child of x to T
        y.right = x; // Make y the new root of the rotated subtree
        return y; // Return the new root of the rotated subtree
    }

    // Find the maximum value in a subtree rooted at the given node
    public static int findMax(Node head) {
        if (head == null)
            return -1; // Return -1 for an empty subtree
        while (head.left != null) {
            head = head.left; // Traverse to the leftmost node
        }
        return head.data; // Return the data of the leftmost node (maximum value)
    }

    // Delete a node with the given data from the tree
    public static Node deleteNode(Node root, int data) {
        if (root == null)
            return root; // Return null if the tree or subtree is empty

        // Recursively delete the node from the appropriate subtree
        if (root.data < data)
            root.right = deleteNode(root.right, data);
        else if (root.data > data)
            root.left = deleteNode(root.left, data);
        else {
            // Node to be deleted found

            if (root.left == null || root.right == null) {
                // Node has one child or no child
                Node temp = (root.left == null) ? root.right : root.left; // Determine the non-null child
                if (temp == null) {
                    temp = root; // If there's no child, set temp to root and root to null
                    root = null;
                } else {
                    root = temp; // Replace root with the non-null child
                }
            } else {
                // Node has two children
                int rep = findMax(root.right); // Find the maximum value in the right subtree
                root.data = rep; // Replace the root's data with the maximum value
                root.right = deleteNode(root.right, rep); // Delete the node with the maximum value
            }
        }

        if (root == null)
            return root; // Return null if the tree or subtree is empty

        // Calculate the balance factor of the root node
        int balance = getBalance(root);

        // Perform rotations based on the balance factor to maintain AVL balance
        if (balance > 1 && getBalance(root.right) >= 0)
            return leftRotation(root);
        else if (balance < -1 && getBalance(root.left) <= 0)
            return rightRotation(root);
        else if (balance > 1 && getBalance(root.right) < 0) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        } else if (balance < -1 && getBalance(root.left) > 0) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        return root; // Return the root of the (sub)tree after deletion and rotations
    }
}
