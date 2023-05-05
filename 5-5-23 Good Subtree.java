
// You are given a root node of a binary Tree and each node of the binary tree is assigned a value and you are also given an integer k and you have to return the count of Good subtrees of this binary Tree . Good subtree is a subtree such that the number of distinct values in this subtree is less than or equal to k.

// Note: Subtree of a node consists of that node and all nodes of the subtrees of left and right child  of that node  if they exist .

class Solution
{
    static int ans;
    public static int goodSubtrees(Node root,int k)
    {
        ans=0;
        help(root,k);
        return ans;
    }
    public static HashSet<Integer> help(Node root,int k)
    {
        if(root==null) return new HashSet<>();
        HashSet<Integer> l = help(root.left, k);
        HashSet<Integer> r = help(root.right, k);
         
         HashSet<Integer> tot =  new HashSet<>();
         for(int x : l)
         tot.add(x);
         
         for(int x : r)
         tot.add(x);
         
         tot.add(root.data);
         
         if(tot.size()<=k)
         ans++;
         
         return tot;
        
    }
}
