Given two arrays that represent Preorder traversals of a Full binary tree preOrder[] and its mirror tree preOrderMirror[], 
your task is to complete the function constructBinaryTree(), that constructs the full binary tree using these two Preorder traversals.

Note: It is not possible to construct a general binary tree using these two traversal. But it is possible to create a full binary 
tree using the above traversals without any ambiguity.

Example 1:

Input :
preOrder[] = {0,1,2}
preOrderMirror[] = {0,2,1} 

Output :
                0
              /   \
             1     2
Explanation :
Tree in the output and it's mirror tree matches the preOrder and preOrderMirror.
  
  
  class Solution
{
    static int index=0;
    
    static Node help(int start, int end, int p[], int pm[], int n){
        if(index>=n || start>end) return null;
        
        if(index==n-1 || start==end){
            Node temp=new Node(p[index]);
            index++;
            return temp;
            
        }
        
        Node temp = new Node(p[index]);
        index++;
        
        for(int i=start;i<=end;i++){
            if(p[index]==pm[i]){
                temp.left=help(i, end, p,pm,n);
                temp.right=help(start+1,i-1,p,pm,n);
                break;
            }
        }
        return temp;
    }
    
    
    public Node constructBTree(int pre[], int preM[], int size)
    {
        // your code here
        
        index=0;
        return help(0,size-1,pre,preM,size);
    }
    
}
