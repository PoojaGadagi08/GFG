

//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

// class Tree
// {
//      // Recursive function to print right view of a binary tree.
//      ArrayList<Integer> Kdistance(Node root, int k)
//      {
//           // Your code here
//           ArrayList<Integer> ans=new ArrayList<>();
//           Queue<Node> q =new LinkedList<>();
          
//           q.offer(root);
//           while(!q.isEmpty()){
//               Node temp=q.poll();
              
//               int n=q.size();
//               for(int i=0;i<)
//           }
//      }
// }



class Tree
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> ans=new ArrayList<>();
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          if(root==null) return null;
     
          if(k==0){     ans.add(root.data);}
          Kdistance(root.left,k-1);
           Kdistance(root.right,k-1);
          return ans;
     }
}
