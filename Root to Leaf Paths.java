Given a Binary Tree of size N, you need to find all the possible paths from root node to all the leaf node's of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output: 1 2 #1 3 #
Explanation: 
All possible paths:
1->2
1->3

Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 10 20 40 #10 20 60 #10 30 #

Your Task:
Your task is to complete the function Paths() that takes the root node as an argument and return all the possible path. (All the path are printed '#' separated by the driver's code.)

Note: The return type
cpp: vector
java: ArrayList>
python: list of list

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1<=N<=103.





  class Tree{
    public ArrayList<ArrayList<Integer>> Paths(Node root){
       ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> arl=new ArrayList<>();
           if(root == null){
            return ans;
        }

        func1(root,arl,ans);
        return ans;
    }
    public   void func1(Node root,ArrayList<Integer> arl,ArrayList<ArrayList<Integer>> ans){
        //ArrayList<Integer> arl=new ArrayList<>();
        if(root == null){
            return;
        }
        arl.add(root.data);
        if(root.left==null && root.right==null){
         ans.add(new ArrayList(arl));
         //new ArrayList  is mandatory in adding  arraylist in arraylist ;
            }
        func1(root.left,arl,ans);
        func1(root.right,arl,ans);
        arl.remove(arl.size()-1);// removes the last element in arl recursivly .
    }
}

