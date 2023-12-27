Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Example 1:

Input:
           1
         /   \
       2       3
     /   \   /   \
   4      5 6      7
              \      \
               8      9           
Output: 
4 2 1 5 6 3 8 7 9 
Explanation:

Example 2:

Input:
       1
    /    \
   2       3
 /    \      \
4      5      6
Output: 4 2 1 5 3 6
Your Task:
You don't need to read input or print anything. Your task is to complete the function verticalOrder() which takes the root node as input parameter and returns an array containing the vertical order traversal of the tree from the leftmost to the rightmost level. If 2 nodes lie in the same vertical level, they should be printed in the order they appear in the level order traversal of the tree.

Expected Time Complexity: O(N*log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 <= Number of nodes <= 3*104




  class Solution{
    static class Pair implements Comparable<Pair>{
        int hd;// horizontal distance
        int data;
        int lev;
       public Pair(int hd,int data,int lev){
            this.hd = hd;
            this.data = data;
            this.lev = lev;
       }
      @Override
       public int compareTo(Pair p2){
           if(this.hd == p2.hd){
               return this.lev - p2.lev;
           }else{
               return this.hd - p2.hd;
           }
       }
    }
    static void Inorder(ArrayList<Pair> list,Node root,int hd,int lev){
        if(root == null){
            return;
        }
        Inorder(list,root.left,hd-1,lev+1);
        list.add(new Pair(hd,root.data,lev));
        Inorder(list,root.right,hd+1,lev+1);
    }
    static ArrayList<Integer> verticalOrder(Node root){
        // add your code here
        ArrayList<Pair> list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Inorder(list,root,0,1);
        Collections.sort(list);
        for(Pair k : list){
            arr.add(k.data);
        }
        return arr;
        
    }
}
