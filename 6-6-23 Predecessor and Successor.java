There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key. 
  If either predecessor or successor is not found, then set it to NULL.

Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 

Example 1:

Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
key = 8
Output: 
6 10
Explanation: 
In the given BST the inorder predecessor of 8 is 6 and inorder successor of 8 is 10.
  
  //Function to check whether a Binary Tree is BST or not.
public static void findPreSuc(Node root, int key)
{
    // code here.
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */
    
    ArrayList<Integer> al=new ArrayList<>();
    in(root,key,al);
    
    int a1=-1;
    int a2=-1;
    
    for(int i=0;i<al.size();i++){
        if(al.get(i)>key){
            a1=al.get(i);
            if((i-1)>=0 && al.get(i-1)!=key)
            a2=al.get(i-1);
            if((i-2)>=0 && al.get(i-1)==key)
            a2=al.get(i-2);
         break;   
        }
        
        if(i==al.size()-1 && al.get(i)<key)
        a2=al.get(i);
        if(i==al.size()-1 && al.get(i)==key)
        a2=al.get(i-1);
    }
    pre=new Node(a2);
    suc=new Node(a1);
}

static void in(Node root,int k,ArrayList<Integer> al){
    if(root!=null){
        in(root.left,k,al);
       al.add(root.data);
       in(root.right,k,al);
    }
}


}




// 2nd Approach
//Function to check whether a Binary Tree is BST or not.
public static void findPreSuc(Node root, int key)
{
    // code here.
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */
    
     pre = floor(root,key);
     suc = ceil(root, key);
}


static Node ceil(Node root, int x)
{
    Node res =null;
    while(root!=null)
    {
        // if(root.data==x)
        // {
        if(root.data>x)
        {
            res=root;
            root=root.left;
        }
        //<=
        else root=root.right;
    }
    return res;
}

static Node floor(Node root, int x)
{
    Node res =null;
    while(root!=null)
    {
        if(root.data>=x)
        {
          
          root=root.left;
        }
        else
        {  res=root;
            root=root.right;
        }
    }
    return res;
}
}
