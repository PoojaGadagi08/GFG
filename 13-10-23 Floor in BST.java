You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
Note: when x is smaller than the smallest node of BST then returns -1.

Example:

Input:
n = 7               2
                     \
                      81
                    /     \
                 42       87
                   \       \
                    66      90
                   /
                 45
x = 87
Output:
87
Explanation:
87 is present in tree so floor will be 87.
Example 2:

Input:
n = 4                     6
                           \
                            8
                          /   \
                        7       9
x = 11
Output:
9
Your Task:-
You don't need to read input or print anything. Complete the function floor() which takes the integer n and BST and integer x returns the floor value.

Constraint:
1 <= Noda data <= 109
1 <= n <= 105

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)






  // User function Template for Java

// class Solution {
//     public static int floor(Node root, int x) {
//         // Code here
//         ArrayList<Integer> arr=new ArrayList<>();
//         inorder(root, arr);
        
//         int low=0;
//         int high=arr.size()-1;
        
//         int ans=0;
        
//         while(low<=high){
//             int mid=(low+high)/2;
            
//             if(arr.get(mid)<=x){
//                 ans=arr.get(mid);
//                 low=mid+1;
//             }
//             else {
//                 high=mid-1;
//             }
//         }
//         return ans;
//     }
//     public static  void inorder(Node root, ArrayList<Integer> arr){
//         if(root== null)
// 	return;
	
	
// 	inorder(root.left,arr);
// 	arr.add(root.data);
// 	inorder(root.right,arr);
// 	return;
	
//     }
// }



class Solution {
    private static int result; // Global variable to store the floor value

    public static int floor(Node root, int x) {
        result = -1; // Initialize result to -1 (no floor found yet)
        findFloor(root, x);
        return result;
    }

    private static void findFloor(Node root, int x) {
        if (root == null) {
            return;
        }

        if (root.data <= x) {
            // If current node value is less than or equal to x, update result and explore right subtree
            result = root.data;
            findFloor(root.right, x);
        } else {
            // If current node value is greater than x, explore left subtree
            findFloor(root.left, x);
        }
    }
}
